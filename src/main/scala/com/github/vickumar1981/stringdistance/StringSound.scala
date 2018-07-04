package com.github.vickumar1981.stringdistance

import com.github.vickumar1981.stringdistance.impl.sound.MetaphoneImpl

/**
  * Main class to organize functionality of different string distance algorithms
  *
  * {{{
  * import com.github.vickumar1981.stringdistance.StringSound._
  *
  * // Phonetic similarity between strings
  * val metaphone: Boolean = Metaphone.score("merci", "mercy")
  * }}}
  */
object StringSound {
  object Metaphone extends StringMetric[MetaphoneAlgorithm]
}

/**
  * Jave Wrapper for metaphone similarity.
  */
class MetaphoneImplWrapper extends MetaphoneImpl
