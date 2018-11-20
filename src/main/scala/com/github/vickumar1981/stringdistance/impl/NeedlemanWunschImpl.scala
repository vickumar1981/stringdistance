package com.github.vickumar1981.stringdistance.impl

import scala.math.{max, min}

trait NeedlemanWunschImpl {
  def needleman(s1: String, s2: String, gap: ConstantGap = ConstantGap()): Double = {
    require(gap.matchValue > 0, "NeedlmanWunsch match value must be a number > 0.")
    require(gap.misMatchValue < 0, "NeedlemanWunsh mismatch value must be a number < 0.")
    require(gap.gapValue <= 0, "Needleman Wunsh gap value must be a number <= 0.")
    if (s1 == s2) 1
    else {
      val maxDist = max(s1.length, s2.length) * max(gap.matchValue, gap.gapValue)
      val minDist = max(s1.length, s2.length) * min(gap.misMatchValue, gap.gapValue)
      (-1d * needlemanW(s1, s2, gap) - minDist) / (maxDist - minDist)
    }
  }

  private def subst(a: String, aIndex: Int, b: String, bIndex: Int, gap: Gap): Double = {
    if (a(aIndex) == b(bIndex)) gap.matchValue else gap.misMatchValue
  }

  private def needlemanW(s1: String, s2: String, gap: ConstantGap): Double = {
    (s1.length, s2.length) match {
      case (0, s2Len) => -gap.gapValue * s2Len
      case (s1Len, 0) => -gap.gapValue * s1Len
      case (s1Len, s2Len) => {
        val v0 = Array.ofDim[Double](s2Len + 1)
        val v1 = Array.ofDim[Double](s2Len + 1)
        v0.indices.foreach {
          i => v0(i) = i
        }

        (1 until s1Len).foreach {
          i => {
            (1 until v0.length).foreach {
              j => {
                v1(j) = min(min(v0(j) - gap.gapValue, v1(j - 1) - gap.gapValue),
                  v0(j - 1) - subst(s1, i - 1, s2, j - 1, gap))
              }
            }
            v0.indices.foreach {
              j => {
                v0(j) = v1(j)
              }
            }
          }
        }
        v1(v1.length - 1)
      }
    }
  }
}
