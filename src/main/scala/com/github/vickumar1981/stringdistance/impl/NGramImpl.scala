package com.github.vickumar1981.stringdistance.impl

import com.github.vickumar1981.stringdistance.interfaces.NGramTokenizer

trait NGramImpl extends NGramTokenizer {
  protected def nGram(s1: String, s2: String, n: Int = 1): Double = {
    foldNGram(s1, s2, n)(0d)(_ => 1d) {
      (s1Tok, s2Tok, dist) => 1 - dist.toDouble / math.max(s1Tok.length, s2Tok.length)
    }
  }

  protected def nGramDist(s1: String, s2: String, n: Int = 1): Int = {
    foldNGram(s1, s2, n)(0)(identity) {
      (_, _, dist) => dist
    }
  }
}
