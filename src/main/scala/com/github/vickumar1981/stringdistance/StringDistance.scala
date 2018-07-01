package com.github.vickumar1981.stringdistance

import com.github.vickumar1981.stringdistance.impl._

object StringDistance {
  object DiceCoefficient extends StringDistanceImpl[DiceCoefficientAlgorithm]
  object Hamming extends StringDistanceImpl[HammingAlgorithm]
  object Jaro extends StringDistanceImpl[JaroAlgorithm]
  object JaroWinkler extends StringDistanceImpl[JaroWinklerAlgorithm]
  object Levenshtein extends StringDistanceImpl[LevenshteinAlgorithm]
  object NGram extends StringDistanceImpl[NGramAlgorithm]
}

class JaroImplWrapper extends JaroImpl
class LevenshteinDistanceImplWrapper extends LevenshteinDistanceImpl
class DiceCoefficientImplWrapper extends DiceCoefficientImpl
class HammingImplWrapper extends HammingImpl
class NGramImplWrapper extends NGramImpl