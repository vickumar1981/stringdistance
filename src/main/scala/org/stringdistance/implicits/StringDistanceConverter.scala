package org.stringdistance.implicits

import org.stringdistance.StringDistance

sealed class StringDistanceConverter(s1: String) {
  def toJaro(s2: String) = StringDistance.jaro(s1, s2)
  def toJaroWinkler(s2: String) = StringDistance.jaroWinkler(s1, s2)
  def toLevenschtein(s2: String) = StringDistance.levenschtein(s1, s2)
}

object Converters {
  implicit def StringToStringdistance(in: String) = new StringDistanceConverter(in)
}
