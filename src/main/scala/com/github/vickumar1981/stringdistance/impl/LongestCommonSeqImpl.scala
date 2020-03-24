package com.github.vickumar1981.stringdistance.impl

trait LongestCommonSeqImpl[T] {
  private def lcs(x: Array[T], y: Array[T], m: Int, n: Int): Int = {
    if (m == 0 || n == 0) 0
    else if (x(m - 1) == y(n - 1)) 1 + lcs(x, y, m - 1, n - 1)
    else math.max(lcs(x, y, m, n - 1), lcs(x, y, m -  1, n))
  }

  protected def longestCommonSeq(s1: Array[T], s2: Array[T]): Int = lcs(s1, s2, s1.length, s2.length)
}
