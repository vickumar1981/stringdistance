package com.github.vickumar1981.stringdistance

import com.github.vickumar1981.stringdistance.impl._

/**
  * Main class to organize functionality of different string distance algorithms
  *
  * {{{
  * import com.github.vickumar1981.stringdistance.StringDistance._
  *
  * val cosSimilarity: Double = Cosine.score("hello", "chello")
  * val diceCoefficient: Double = DiceCoefficient.score("martha", "marhta")
  * val diceCoefficientWeighted: Double = DiceCoefficient.score("martha", "marhta", 0.2)
  * val hammingDist: Int = Hamming.distance("martha", "marhta")
  * val hamming: Double = Hamming.score("martha", "marhta")
  * val jaccard: Double = Jaccard.score("karolin", "kathrin")
  * val jaro: Double = Jaro.score("martha", "marhta")
  * val jaroWinkler: Double = JaroWinkler.score("martha", "marhta")
  * val levenshteinDist: Int = Levenshtein.distance("martha", "marhta")
  * val levenshtein: Double = Levenshtein.score("martha", "marhta")
  * val longestCommonSubSeq: Int = LongestCommonSeq.distance("martha", "marhta")
  * val ngramSimilarity: Double = NGram.score("karolin", "kathrin")
  * val bigramSimilarity: Double = NGram.score("karolin", "kathrin", 2)
  * }}}
  */
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

/**
  * Jave Wrapper for cosine similarity.
  */
class CosineSimilarityImplWrapper extends CosSimilarityImpl

/**
  * Jave Wrapper for dice coefficient similarity.
  */
class DiceCoefficientImplWrapper extends DiceCoefficientImpl

/**
  * Jave Wrapper for hamming distance.
  */
class HammingImplWrapper extends HammingImpl

/**
  * Jave Wrapper for jaccard similarity.
  */
class JaccardImplWrapper extends JaccardImpl

/**
  * Jave Wrapper for jaro and jaro winkler similarity.
  */
class JaroImplWrapper extends JaroImpl

/**
  * Jave Wrapper for levenshtein distance.
  */
class LevenshteinDistanceImplWrapper extends LevenshteinDistanceImpl

/**
  * Jave Wrapper for longest comment sequence.
  */
class LongestCommonSeqWrapper extends LongestCommonSeqImpl

/**
  * Jave Wrapper for n-gram similarity.
  */
class NGramImplWrapper extends NGramImpl
