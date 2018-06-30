package org

package object stringdistance {
  object StringConverter {
    implicit class StringToStringDistanceConverter(s1: String) {
      def jaro(s2: String): Double = StringDistance.jaro(s1, s2)
      def jaroWinkler(s2: String, weight: Double = 0.1): Double =
        StringDistance.jaroWinkler(s1, s2, weight)
      def levenshtein(s2: String): Int = StringDistance.levenshtein(s1, s2)
      def diceCoefficient(s2: String): Double = StringDistance.diceCoefficient(s1, s2)
      def hamming(s2: String): Int = StringDistance.hamming(s1, s2)
    }
  }
}
