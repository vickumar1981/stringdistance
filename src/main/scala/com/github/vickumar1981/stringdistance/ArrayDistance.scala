package com.github.vickumar1981.stringdistance

import com.github.vickumar1981.stringdistance.impl._

object ArrayDistance {
  sealed trait ScoreMetric {
    def score[T](arr1: Array[T], arr2: Array[T]): Double
  }

  sealed trait DistanceMetric {
    def distance[T](arr1: Array[T], arr2: Array[T]): Int
  }

  sealed trait WeightedScoreMetric[T2] {
    def score[T1](arr1: Array[T1], arr2: Array[T1], weight: T2): Double
    def score[T1](arr1: Array[T1], arr2: Array[T1]): Double
  }

  sealed trait WeightedDistanceMetric[T2] {
    def distance[T1](arr1: Array[T1], arr2: Array[T1], weight: T2): Int
    def distance[T1](arr1: Array[T1], arr2: Array[T1]): Int
  }

  sealed trait ScoreFromDistanceMetric {
    def distance[T](arr1: Array[T], arr2: Array[T]): Int
    private def score[T](s1: Array[T], s2: Array[T]): Double = {
      val maxLen = math.max(s1.length, s2.length)
      val minLen = maxLen - distance(s1, s2)
      (if (minLen < 0 || minLen > maxLen) 0d else minLen * 1d) / maxLen
    }
  }

  object Cosine extends ScoreMetric with CosSimilarityImpl {
    override def score[T](arr1: Array[T], arr2: Array[T]): Double = cosSimilarity(arr1, arr2)
  }

  object Damerau extends ScoreFromDistanceMetric with LevenshteinDistanceImpl {
    override def distance[T](arr1: Array[T], arr2: Array[T]): Int = damerauLevenshtein(arr1, arr2)
  }

  object DiceCoefficient extends ScoreMetric with DiceCoefficientImpl {
    override def score[T](arr1: Array[T], arr2: Array[T]): Double = diceCoefficient(arr1, arr2)
  }

  object Hamming extends ScoreFromDistanceMetric with HammingImpl {
    override def distance[T](arr1: Array[T], arr2: Array[T]): Int = hamming(arr1, arr2)
  }

  object Jaccard extends WeightedScoreMetric[Int] with JaccardImpl {
    override def score[T](arr1: Array[T], arr2: Array[T]): Double = jaccard(arr1, arr2)
    override def score[T](arr1: Array[T], arr2: Array[T], weight: Int): Double = jaccard(arr1, arr2, weight)
  }

  object Jaro extends ScoreMetric with JaroImpl {
    override def score[T](arr1: Array[T], arr2: Array[T]): Double = jaro(arr1, arr2)
  }

  object JaroWinkler extends WeightedScoreMetric[Double] with JaroImpl {
    override def score[T1](arr1: Array[T1], arr2: Array[T1]): Double = jaroWinkler(arr1, arr2)
    override def score[T1](arr1: Array[T1], arr2: Array[T1], weight: Double): Double = jaroWinkler(arr1, arr2, weight)
  }

  object Levenshtein extends ScoreFromDistanceMetric with LevenshteinDistanceImpl {
    override def distance[T](arr1: Array[T], arr2: Array[T]): Int = levenshtein(arr1, arr2)
  }

  object LongestCommonSeq extends DistanceMetric with LongestCommonSeqImpl {
    override def distance[T](arr1: Array[T], arr2: Array[T]): Int = longestCommonSeq(arr1, arr2)
  }

  object NeedlemanWunsch extends WeightedScoreMetric[ConstantGap] with NeedlemanWunschImpl {
    override def score[T1](arr1: Array[T1], arr2: Array[T1]): Double = needleman(arr1, arr2)
    override def score[T1](arr1: Array[T1], arr2: Array[T1], weight: ConstantGap): Double =
      needleman(arr1, arr2, weight)
  }

  object NGram extends WeightedScoreMetric[Int] with WeightedDistanceMetric[Int] with NGramImpl {
    override def distance[T1](arr1: Array[T1], arr2: Array[T1]): Int = nGramDist(arr1, arr2)
    override def distance[T1](arr1: Array[T1], arr2: Array[T1], weight: Int): Int = nGramDist(arr1, arr2, weight)
    override def score[T1](arr1: Array[T1], arr2: Array[T1]): Double = nGram(arr1, arr2)
    override def score[T1](arr1: Array[T1], arr2: Array[T1], weight: Int): Double = nGram(arr1, arr2, weight)

  }

  object Overlap extends WeightedScoreMetric[Int] with OverlapImpl {
    override def score[T1](arr1: Array[T1], arr2: Array[T1]): Double = overlap(arr1, arr2)
    override def score[T1](arr1: Array[T1], arr2: Array[T1], weight: Int): Double =
      overlap(arr1, arr2, weight)
  }

  object SmithWaterman extends WeightedScoreMetric[(Gap, Int)] with SmithWatermanImpl {
    override def score[T1](arr1: Array[T1], arr2: Array[T1]): Double = smithWaterman(arr1, arr2)
    override def score[T1](arr1: Array[T1], arr2: Array[T1], n: (Gap, Int)): Double =
      smithWaterman(arr1, arr2, n._1, n._2)
  }

  object SmithWatermanGotoh extends WeightedScoreMetric[ConstantGap] with SmithWatermanImpl {
    override def score[T1](arr1: Array[T1], arr2: Array[T1]): Double = smithWatermanGotoh(arr1, arr2)
    override def score[T1](arr1: Array[T1], arr2: Array[T1], weight: ConstantGap): Double =
      smithWatermanGotoh(arr1, arr2, weight)
  }

  object Tversky extends WeightedScoreMetric[Double] with JaccardImpl {
    override def score[T1](arr1: Array[T1], arr2: Array[T1]): Double = tversky(arr1, arr2)
    override def score[T1](arr1: Array[T1], arr2: Array[T1], weight: Double): Double =
      tversky(arr1, arr2, weight)
  }

}
