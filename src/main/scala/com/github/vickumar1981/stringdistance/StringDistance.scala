package com.github.vickumar1981.stringdistance

import com.github.vickumar1981.stringdistance.impl._

/**
  * Main class to organize functionality of different string distance algorithms
  *
  * {{{
  * import com.github.vickumar1981.stringdistance.StringDistance._
  *
  * // Scores between strings
  * val cosSimilarity: Double = Cosine.score("hello", "chello")
  * val damerau: Double = Damerau.score("martha", "marhta")
  * val diceCoefficient: Double = DiceCoefficient.score("martha", "marhta")
  * val hamming: Double = Hamming.score("martha", "marhta")
  * val jaccard: Double = Jaccard.score("karolin", "kathrin")
  * val jaro: Double = Jaro.score("martha", "marhta")
  * val jaroWinkler: Double = JaroWinkler.score("martha", "marhta")
  * val levenshtein: Double = Levenshtein.score("martha", "marhta")
  * val needlemanWunsch: Double = NeedlemanWunsch.score("martha", "marhta")
  * val ngramSimilarity: Double = NGram.score("karolin", "kathrin")
  * val bigramSimilarity: Double = NGram.score("karolin", "kathrin", 2)
  * val overlap: Double = Overlap.score("karolin", "kathrin")
  * val tversky: Double = Tversky.score("karolin", "kathrin", 0.5)
  * val smithWaterman: Double = SmithWaterman.score("martha", "marhta")
  * val smithWatermanGotoh: Double = SmithWatermanGotoh.score("martha", "marhta")
  *
  * // Distances between strings
  * val damerauDist: Int = Damerau.distance("martha", "marhta")
  * val hammingDist: Int = Hamming.distance("martha", "marhta")
  * val levenshteinDist: Int = Levenshtein.distance("martha", "marhta")
  * val longestCommonSubSeq: Int = LongestCommonSeq.distance("martha", "marhta")
  * val ngramDist: Int = NGram.distance("karolin", "kathrin")
  * val bigramDist: Int = NGram.distance("karolin", "kathrin", 2)
  * }}}
  */
object StringDistance {
  object Cosine extends StringMetric[CosineAlgorithm]
  object Damerau extends StringMetric[DamerauLevenshteinAlgorithm]
  object DiceCoefficient extends StringMetric[DiceCoefficientAlgorithm]
  object Hamming extends StringMetric[HammingAlgorithm]
  object Jaccard extends StringMetric[JaccardAlgorithm]
  object Jaro extends StringMetric[JaroAlgorithm]
  object JaroWinkler extends StringMetric[JaroWinklerAlgorithm]
  object Levenshtein extends StringMetric[LevenshteinAlgorithm]
  object LongestCommonSeq extends StringMetric[LongestCommonSeqAlorithm]
  object NeedlemanWunsch extends StringMetric[NeedlemanWunschAlgorithm]
  object NGram extends StringMetric[NGramAlgorithm]
  object Overlap extends StringMetric[OverlapAlgorithm]
  object SmithWaterman extends StringMetric[SmithWatermanAlgorithm]
  object SmithWatermanGotoh extends StringMetric[SmithWatermanGotohAlgorithm]
  object Tversky extends StringMetric[TverskyAlgorithm]
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
  * Jave Wrapper for needleman wunsch similarity.
  */
class NeedlemanWunschImplWrapper extends NeedlemanWunschImpl

/**
  * Jave Wrapper for n-gram similarity.
  */
class NGramImplWrapper extends NGramImpl

/**
  * Jave Wrapper for overlap similarity.
  */
class OverlapImplWrapper extends OverlapImpl


/**
  * Jave Wrapper for smith waterman similarity.
  */
class SmithWatermanImplWrapper extends SmithWatermanImpl

