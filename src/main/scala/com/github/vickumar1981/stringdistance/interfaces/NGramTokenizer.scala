package com.github.vickumar1981.stringdistance.interfaces

trait NGramTokenizer {
  protected val intersectLength: ((Array[String], Array[String]) => Int) = (mt1, mt2) => mt1.intersect(mt2).length

  private def tokenize(a: Array[Char], n: Int): Array[Array[Char]] =
    sequence(a, Array.empty[Array[Char]], n)

  protected def tokenizeNGram(a: String, n: Int): Array[String] = tokenize(a.toCharArray, n).map(_.mkString)

  @annotation.tailrec
  private val sequence: ((Array[Char], Array[Array[Char]], Int) => Array[Array[Char]]) = (i, o, n) =>
    if (i.length <= n) o :+ i
    else sequence(i.tail, o :+ i.take(n), n)

  protected def foldNGram[T](s1: String, s2: String, n: Int = 1)
                            (err: => T)(success: (Int) => T)
                            (fuzzy: (Int, Int, Int) => T): T = {
    if (n <= 0 || s1.length < n || s2.length < n) err
    else if (s1.sameElements(s2)) {
      val s1Tokenized = tokenizeNGram(s1, n)
      success(s1Tokenized.length)
    }
    else {
      val s1Tokenized = tokenizeNGram(s1, n)
      val s2Tokenized = tokenizeNGram(s2, n)
      val intersectionLength = intersectLength(s1Tokenized, s2Tokenized)
      fuzzy(s1Tokenized.length, s2Tokenized.length, intersectionLength)
    }
  }
}
