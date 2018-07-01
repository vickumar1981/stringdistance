package com.github.vickumar1981.stringdistance.impl

import scala.collection.mutable.Set

trait DiceCoefficientImpl {
  def diceCoefficient(s1: String, s2: String, weight: Double = 0.1): Double = {
    val nx = Set[String]()
    val ny = Set[String]()

    s1.zipWithIndex.foreach {
      case (ch, chIndex) => {
        if (chIndex < s1.length - 1)
          nx += ("" + s1(chIndex) + s1(chIndex + 1))
      }
    }

    s2.zipWithIndex.foreach {
      case (ch, chIndex) => {
        if (chIndex < s2.length - 1)
          ny += ("" + s2(chIndex) + s2(chIndex + 1))
      }
    }
    val intersection = nx intersect ny
    2.0 * intersection.size / (nx.size + ny.size)
  }
}
