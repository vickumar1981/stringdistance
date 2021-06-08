package com.github.vickumar1981.stringdistance.impl

private[stringdistance] trait LongestCommonSeqImpl {
  protected def longestCommonSeq[T](s1: Array[T], s2: Array[T]): Int = {
    val m = s1.length
    val n = s2.length
    val T = Array.ofDim[Int](m + 1, n + 1)
    for (i <- 1 to m) {
      for (j <- 1 to n) {
        if (s1(i - 1) == s2(j - 1)) {
          T(i)(j) = T(i - 1)(j - 1) + 1
        } else {
          T(i)(j) = math.max(T(i - 1)(j), T(i)(j - 1))
        }
      }
    }
    T(m)(n)
  }
}
