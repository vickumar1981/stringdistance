package com.github.vickumar1981.stringdistance.interfaces

trait NGramTokenizer[T] {
  protected val intersectLength: (List[List[T]], List[List[T]]) => Int = (mt1, mt2) => mt1.intersect(mt2).length

  private def tokenize(a: List[T], n: Int): List[List[T]] =
    sequence(a, List.empty, n)

  protected def tokenizeNGram(a: Array[T], n: Int): List[List[T]] = tokenize(a.toList, n)

  @annotation.tailrec
  private val sequence: (List[T], List[List[T]], Int) => List[List[T]] = (i, o, n) =>
    if (i.length <= n) o :+ i
    else sequence(i.tail, o :+ i.take(n), n)

  protected def foldNGram[R](s1: Array[T], s2: Array[T], n: Int = 1)
                            (err: => R)(success: Int => R)
                            (fuzzy: (List[List[T]], List[List[T]], Int) => R): R = {
    if (n <= 0 || s1.length < n || s2.length < n) err
    else if (s1.sameElements(s2)) {
      val s1Tokenized = tokenizeNGram(s1, n)
      success(s1Tokenized.length)
    }
    else {
      val s1Tokenized = tokenizeNGram(s1, n)
      val s2Tokenized = tokenizeNGram(s2, n)
      val intersectionLength = intersectLength(s1Tokenized, s2Tokenized)
      fuzzy(s1Tokenized, s2Tokenized, intersectionLength)
    }
  }
}
