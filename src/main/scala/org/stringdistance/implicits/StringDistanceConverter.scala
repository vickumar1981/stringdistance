package org.stringdistance.implicits

import org.stringdistance.StringDistance

sealed class StringDistanceConverter(s1: String) {
  def jaro(s2: String) = StringDistance.jaro(s1, s2)
  def jaroWinkler(s2: String, weight: Double = 0.1) =
    StringDistance.jaroWinkler(s1, s2, weight)
  def levenschtein(s2: String) = StringDistance.levenschtein(s1, s2)
  def diceCoefficient(s2: String) = StringDistance.diceCoefficient(s1, s2)
}

object Converters {
  implicit def StringToStringDistanceConverter(in: String) =
    new StringDistanceConverter(in)
}
