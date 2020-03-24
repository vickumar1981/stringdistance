package com.github.vickumar1981.stringdistance

import com.github.vickumar1981.stringdistance.impl._

package object arrays {
  sealed trait ScoreMetric {
    def score[T](arr1: Array[T], arr2: Array[T]): Double
  }

  sealed trait DistanceMetric[T] {
    def distance(arr1: Array[T], arr2: Array[T]): Int
  }

  sealed trait WeightedScoreMetric[T1, T2] {
    def score(arr1: Array[T1], arr2: Array[T1], weight: T2): Double
    def score(arr1: Array[T1], arr2: Array[T1]): Double
  }

  sealed trait WeightedDistanceMetric[T1, T2] {
    def distance(arr1: Array[T1], arr2: Array[T1], weight: T2): Int
    def distance(arr1: Array[T1], arr2: Array[T1]): Int
  }

  sealed trait ScoreFromDistanceMetric[T] {
    def distance(arr1: Array[T], arr2: Array[T]): Int
    private def scoreFromDist(s1: Array[T], s2: Array[T]): Double = {
      val maxLen = math.max(s1.length, s2.length)
      val minLen = maxLen - distance(s1, s2)
      (if (minLen < 0 || minLen > maxLen) 0d else minLen * 1d) / maxLen
    }
  }

  object Cosine extends ScoreMetric with CosSimilarityImpl {
    override def score[T](arr1: Array[T], arr2: Array[T]): Double = cosSimilarity(arr1, arr2)
  }

//  class Damerau[T] extends ScoreFromDistanceMetric[T] with LevenshteinDistanceImpl[T] {
//    override def distance(arr1: Array[T], arr2: Array[T]): Int = damerauLevenshtein(arr1, arr2)
//  }
//
//  class DiceCoefficient[T] extends ScoreMetric[T] with DiceCoefficientImpl[T] {
//    override def score(arr1: Array[T], arr2: Array[T]): Double = diceCoefficient(arr1, arr2)
//  }
//
//  class Hamming[T] extends ScoreFromDistanceMetric[T] with HammingImpl[T] {
//    override def distance(arr1: Array[T], arr2: Array[T]): Int = hamming(arr1, arr2)
//  }
//
//  class Jaccard[T] extends WeightedScoreMetric[T, Int] with JaccardImpl[T] {
//    override def score(arr1: Array[T], arr2: Array[T]): Double = jaccard(arr1, arr2)
//    override def score(arr1: Array[T], arr2: Array[T], weight: Int): Double = jaccard(arr1, arr2, weight)
//  }
//
//  object Jaro extends StringMetric[JaroAlgorithm]
//  object JaroWinkler extends WeightedStringMetric[JaroWinklerAlgorithm, Double]
//
//  class Levenshtein[T] extends ScoreFromDistanceMetric[T] with LevenshteinDistanceImpl[T] {
//    override def distance(arr1: Array[T], arr2: Array[T]): Int = levenshtein(arr1, arr2)
//  }

  object LongestCommonSeq extends StringMetric[LongestCommonSeqAlorithm]
  object NeedlemanWunsch extends WeightedStringMetric[NeedlemanWunschAlgorithm, ConstantGap]
  object NGram extends WeightedStringMetric[NGramAlgorithm, Int]
  object Overlap extends WeightedStringMetric[OverlapAlgorithm, Int]
  object SmithWaterman extends WeightedStringMetric[SmithWatermanAlgorithm, (Gap, Int)]
  object SmithWatermanGotoh extends WeightedStringMetric[SmithWatermanGotohAlgorithm, ConstantGap]
  object Tversky extends WeightedStringMetric[TverskyAlgorithm, Double]
}
