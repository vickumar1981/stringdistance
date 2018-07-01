package com.github.vickumar1981

import com.github.vickumar1981.stringdistance.impl._

package object stringdistance {
  sealed trait StringDistanceAlgorithm
  trait DiceCoefficientAlgorithm extends StringDistanceAlgorithm
  trait HammingAlgorithm extends StringDistanceAlgorithm
  trait JaroAlgorithm extends StringDistanceAlgorithm
  trait JaroWinklerAlgorithm extends StringDistanceAlgorithm
  trait LevenshteinAlgorithm extends StringDistanceAlgorithm
  trait NGramAlgorithm extends StringDistanceAlgorithm

  trait DistanceAlgorithm[+T <: StringDistanceAlgorithm] {
    def distance(s1: String, s2: String): Int
  }

  trait ScoringAlgorithm[+T <: StringDistanceAlgorithm] {
    def score(s1: String, s2: String): Double
  }

  trait WeightedScoringAlgorithm[+A <: StringDistanceAlgorithm, B] {
    def score(s1: String, s2: String, weight: B): Double
  }

  trait ScorableFromDistance[+T <: StringDistanceAlgorithm] extends ScoringAlgorithm[T] { self: DistanceAlgorithm[T] =>
    def score(s1: String, s2: String): Double = {
      val maxLen = Math.max(s1.length, s2.length)
      val minLen = maxLen - distance(s1, s2)
      (if (minLen < 0 || minLen > maxLen) 0d else minLen * 1d) / maxLen
    }
  }

  implicit object DiceCoefficientScore extends DiceCoefficientImpl
    with WeightedScoringAlgorithm[DiceCoefficientAlgorithm, Double] {
    override def score(s1: String, s2: String, weight: Double = 0.1): Double = diceCoefficient(s1, s2, weight)
  }

  implicit object HammingDistance extends HammingImpl
    with DistanceAlgorithm[HammingAlgorithm] with ScorableFromDistance[HammingAlgorithm] {
    override def distance(s1: String, s2: String): Int = hamming(s1, s2)
  }

  implicit object JaroScore extends JaroImpl with ScoringAlgorithm[JaroAlgorithm] {
    override def score(s1: String, s2: String): Double = jaro(s1, s2)
  }

  implicit object JaroWinklerScore extends JaroImpl with WeightedScoringAlgorithm[JaroWinklerAlgorithm, Double] {
    override def score(s1: String, s2: String, weight: Double = 0.1): Double = jaroWinkler(s1, s2, weight)
  }

  implicit object LevenshteinDistance extends LevenshteinDistanceImpl
    with DistanceAlgorithm[LevenshteinAlgorithm] with ScorableFromDistance[LevenshteinAlgorithm] {
    override def distance(s1: String, s2: String): Int = levenshtein(s1, s2)
  }

  implicit object NGramScore extends NGramImpl with WeightedScoringAlgorithm[NGramAlgorithm, Int] {
    override def score(s1: String, s2: String, n: Int = 1): Double = nGram(s1, s2, n)
  }

  trait StringDistanceImpl[A <: StringDistanceAlgorithm] {
    def distance(s1: String, s2: String)
                (implicit algo: DistanceAlgorithm[A]): Int = algo.distance(s1, s2)
    def score(s1: String, s2: String)
             (implicit algo: ScoringAlgorithm[A]): Double = algo.score(s1, s2)
    def score[B](s1: String, s2: String, weight: B)
             (implicit algo: WeightedScoringAlgorithm[A, B]): Double = algo.score(s1, s2, weight)
  }

  object StringConverter {
    import StringDistance._
    implicit class StringToStringDistanceConverter(s1: String) {
      def diceCoefficient(s2: String, weight: Double = 0.1): Double = DiceCoefficient.score(s1, s2, weight)
      def hamming(s2: String): Double = Hamming.score(s1, s2)
      def hammingDist(s2: String): Int = Hamming.distance(s1, s2)
      def jaro(s2: String): Double = Jaro.score(s1, s2)
      def jaroWinkler(s2: String, weight: Double = 0.1): Double =
        JaroWinkler.score(s1, s2, weight)
      def levenshtein(s2: String): Double = Levenshtein.score(s1, s2)
      def levenshteinDist(s2: String): Int = Levenshtein.distance(s1, s2)
      def nGram(s2: String, n: Int = 1): Double = NGram.score(s1, s2, n)
    }
  }
}
