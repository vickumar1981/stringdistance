package com.github.vickumar1981.stringdistance.algo

import scala.math.min

trait LevenshteinDistance {
  def levenshtein(a: String, b: String): Int =
    ((0 to b.size).toList /: a)((prev, x) =>
      (prev zip prev.tail zip b).scanLeft(prev.head + 1) {
        case (h, ((d, v), y)) => min(min(h + 1, v + 1), d + (if (x == y) 0 else 1))
      }) last
}
