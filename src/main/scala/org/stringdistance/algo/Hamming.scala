package org.stringdistance.algo

trait Hamming {
  def hamming(s1: String, s2: String): Int = {
    if (s1.length != s2.length) -1
    else {
      s1.zip(s2).map { case (ch1, ch2) => if (ch1 == ch2) 0 else 1 }.sum
    }
  }
}
