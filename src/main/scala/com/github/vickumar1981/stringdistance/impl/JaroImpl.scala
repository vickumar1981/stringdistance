package com.github.vickumar1981.stringdistance.impl

import com.github.vickumar1981.stringdistance.interfaces.CommonStringDistanceAlgo

trait JaroImpl extends CommonStringDistanceAlgo {
  protected def jaroWinkler(s1: String, s2: String, weight: Double = 0.1): Double = {
    val jaroScore = jaro(s1, s2)
    val l = minStartPrefix(s1, s2)
    jaroScore + (l * weight * (1 - jaroScore))
  }

  protected def jaro(s1: String, s2: String): Double = {
    val minLen = math.min(s1.length, s2.length)
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
      transpositions /= 2d
      (((common1.length * 1d) / s1.length) +
        (common2.length * 1d / s2.length) +
        ((1d * common1.length - transpositions) / common1.length)) / 3d
    } else 0d
  }
}
