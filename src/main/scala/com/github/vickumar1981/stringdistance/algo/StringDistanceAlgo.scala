package com.github.vickumar1981.stringdistance.algo

trait StringDistanceAlgo {
  protected def minStartPrefix(s1: String, s2: String, minPrefixLen: Int = 4): Int = {
    var isSame = true
    var minPrefix = 0
    s1.zipWithIndex.foreach{
      case (ch, chIndex) => {
        if (isSame && chIndex < s2.length && ch == s2(chIndex))
          minPrefix += 1
        else
          isSame = false
      }
    }
    Math.min(minPrefix, minPrefixLen)
  }

  protected def getCommonChars(s1: String, s2: String, halfLen: Int): String = {
    val commonChars = new StringBuilder()
    val strCopy = new StringBuilder(s2)
    var n = s1.length
    val m = s2.length
    s1.zipWithIndex.foreach{
      case (ch, chIndex) => {
        var foundIt = false
        var j = Math.max(0, chIndex - halfLen)
        while (!foundIt && j <= Math.min(chIndex + halfLen, m - 1)) {
          if (strCopy(j) == ch) {
            foundIt = true
            commonChars.append(ch)
            strCopy.setCharAt(j, '\0')
          }
          j += 1
        }
      }}
    commonChars.toString
  }
}
