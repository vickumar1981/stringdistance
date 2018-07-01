package org.stringdistance.algo

trait NGramTokenizer {
  private def tokenize(a: Array[Char], n: Int): Array[Array[Char]] =
    sequence(a, Array.empty[Array[Char]], n)

  protected def tokenizeNGram(a: String, n: Int): Array[String] = tokenize(a.toCharArray, n).map(_.mkString)

  @annotation.tailrec
  private val sequence: ((Array[Char], Array[Array[Char]], Int) => Array[Array[Char]]) = (i, o, n) =>
    if (i.length <= n) o :+ i
    else sequence(i.tail, o :+ i.take(n), n)
}
