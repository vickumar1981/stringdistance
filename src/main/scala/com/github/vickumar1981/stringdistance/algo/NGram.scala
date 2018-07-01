package com.github.vickumar1981.stringdistance.algo

trait NGram extends NGramTokenizer {
  private val intersectLength: ((Array[String], Array[String]) => Int) = (mt1, mt2) => mt1.intersect(mt2).length

  def nGram(s1: String, s2: String, n: Int = 1): Double = {
    if (n <= 0 || s1.length < n || s2.length < n) 0d
    else if (s1.sameElements(s2)) 1d
    else {
      val s1Tokenized = tokenizeNGram(s1, n)
      val s2Tokenized = tokenizeNGram(s2, n)
      val intersectionLength = intersectLength(s1Tokenized, s2Tokenized)
      1 - intersectionLength.toDouble / math.max(s1Tokenized.length, s2Tokenized.length)
    }
  }
}
