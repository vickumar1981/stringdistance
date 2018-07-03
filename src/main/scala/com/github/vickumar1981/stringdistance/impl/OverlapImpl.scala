package com.github.vickumar1981.stringdistance.impl

import com.github.vickumar1981.stringdistance.interfaces.NGramTokenizer

trait OverlapImpl extends NGramTokenizer {
  protected def overlap(s1: String, s2: String, n: Int = 1): Double = {
    foldNGram(s1, s2, n)(0d)(_ => 1d) {
      (s1TokLen, s2TokenLen, dist) => 1 - dist.toDouble / math.min(s1TokLen, s2TokenLen)
    }
  }
}
