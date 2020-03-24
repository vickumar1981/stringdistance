package com.github.vickumar1981.stringdistance

import com.github.vickumar1981.stringdistance.impl.{ConstantGap, Gap}

package object arrays {
  trait ScoreMetric[T] {
    def score(arr1: Array[T], arr2: Array[T]): Double
  }

  trait DistanceMetric[T] {
    def distance(arr1: Array[T], arr2: Array[T]): Int
  }

  trait WeightedScoreMetric[T1, T2] {
    def score(arr1: Array[T1], arr2: Array[T1], weight: T2): Double
    def score(arr1: Array[T1], arr2: Array[T1]): Double
  }

  trait WeightedDistanceMetric[T1, T2] {
    def distance(arr1: Array[T1], arr2: Array[T1], weight: T2): Int
    def distance(arr1: Array[T1], arr2: Array[T1]): Int
  }

  object ArrayDistance {
    class Cosine[T] extends StringMetric[CosineAlgorithm]
    object Damerau extends StringMetric[DamerauLevenshteinAlgorithm]
    object DiceCoefficient extends StringMetric[DiceCoefficientAlgorithm]
    object Hamming extends StringMetric[HammingAlgorithm]
    object Jaccard extends WeightedStringMetric[JaccardAlgorithm, Int]
    object Jaro extends StringMetric[JaroAlgorithm]
    object JaroWinkler extends WeightedStringMetric[JaroWinklerAlgorithm, Double]
    object Levenshtein extends StringMetric[LevenshteinAlgorithm]
    object LongestCommonSeq extends StringMetric[LongestCommonSeqAlorithm]
    object NeedlemanWunsch extends WeightedStringMetric[NeedlemanWunschAlgorithm, ConstantGap]
    object NGram extends WeightedStringMetric[NGramAlgorithm, Int]
    object Overlap extends WeightedStringMetric[OverlapAlgorithm, Int]
    object SmithWaterman extends WeightedStringMetric[SmithWatermanAlgorithm, (Gap, Int)]
    object SmithWatermanGotoh extends WeightedStringMetric[SmithWatermanGotohAlgorithm, ConstantGap]
    object Tversky extends WeightedStringMetric[TverskyAlgorithm, Double]
  }
}
