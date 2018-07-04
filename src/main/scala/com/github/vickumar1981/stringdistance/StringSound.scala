package com.github.vickumar1981.stringdistance

import com.github.vickumar1981.stringdistance.impl.sound.{MetaphoneImpl, SoundexImpl}

/**
  * Main class to organize functionality of different string distance algorithms
  *
  * {{{
  * import com.github.vickumar1981.stringdistance.StringSound._
  *
  * // Phonetic similarity between strings
  * val metaphone: Boolean = Metaphone.score("merci", "mercy")
  * val soundex: Boolean = Soundex.score("merci", "mercy")
  * }}}
  */
object StringSound {
  object Metaphone extends StringMetric[MetaphoneAlgorithm]
  object Soundex extends StringMetric[SoundexAlgorithm]
}

/**
  * Jave Wrapper for metaphone similarity.
  */
class MetaphoneImplWrapper extends MetaphoneImpl

/**
  * Jave Wrapper for soundex similarity.
  */
class SoundexImplWrapper extends SoundexImpl
