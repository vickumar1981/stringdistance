package com.github.vickumar1981.stringdistance.impl

import com.github.vickumar1981.stringdistance.interfaces.NGramTokenizer

trait JaccardImpl extends NGramTokenizer {
  protected def jaccard(s1: String, s2: String, n: Int = 1): Double = {
    foldNGram(s1, s2, n)(0d)(_ => 1d) {
      (s1TokLen, s2TokenLen, dist) => dist.toDouble / (s1TokLen + s2TokenLen - dist)
    }
  }
}
