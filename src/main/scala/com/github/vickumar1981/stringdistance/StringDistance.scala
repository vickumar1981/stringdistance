package com.github.vickumar1981.stringdistance

import com.github.vickumar1981.stringdistance.impl._

object StringDistance {
  object Cosine extends StringDistanceImpl[CosineAlgorithm]
  object DiceCoefficient extends StringDistanceImpl[DiceCoefficientAlgorithm]
  object Hamming extends StringDistanceImpl[HammingAlgorithm]
  object Jaccard extends StringDistanceImpl[JaccardAlgorithm]
  object Jaro extends StringDistanceImpl[JaroAlgorithm]
  object JaroWinkler extends StringDistanceImpl[JaroWinklerAlgorithm]
  object Levenshtein extends StringDistanceImpl[LevenshteinAlgorithm]
  object LongestCommonSeq extends StringDistanceImpl[LongestCommonSeqAlorithm]
  object NGram extends StringDistanceImpl[NGramAlgorithm]
}

class CosineSimilarityImplWrapper extends CosSimilarityImpl
class DiceCoefficientImplWrapper extends DiceCoefficientImpl
class HammingImplWrapper extends HammingImpl
class JaccardImplWrapper extends JaccardImpl
class JaroImplWrapper extends JaroImpl
class LevenshteinDistanceImplWrapper extends LevenshteinDistanceImpl
class LongestCommonSeqWrapper extends LongestCommonSeqImpl
class NGramImplWrapper extends NGramImpl