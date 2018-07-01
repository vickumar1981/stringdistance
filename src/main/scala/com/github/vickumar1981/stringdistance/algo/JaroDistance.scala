package com.github.vickumar1981.stringdistance.algo

trait JaroDistance extends StringDistanceAlgo {
  def jaroWinkler(s1: String, s2: String, weight: Double = 0.1): Double = {
    val jaroScore = jaro(s1, s2)
    val l = minStartPrefix(s1, s2)
    jaroScore + (l * weight * (1 - jaroScore))
  }

  def jaro(s1: String, s2: String): Double = {
    val minLen = Math.min(s1.length, s2.length)
    val halflen = (minLen / 2) + (minLen % 2)
    val common1 = getCommonChars(s1, s2, halflen)
    val common2 = getCommonChars(s2, s1, halflen)
    if (common1.length > 0 && common2.length > 0 && common1.length == common2.length) {
      var transpositions = 0d
      common1.zipWithIndex.foreach {
        case (ch: Char, chIndex: Int) => {
          if (common1(chIndex) != common2(chIndex)) {
            transpositions += 1
          }
        }}
      transpositions /= 2.0
      (((common1.length * 1.0) / s1.length) +
        (common2.length * 1.0 / s2.length) +
        ((1.0 * common1.length - transpositions) / common1.length)) / 3
    } else 0d
  }
}
