package com.github.vickumar1981.stringdistance

import com.github.vickumar1981.stringdistance.impl._

/**
  * Main class to organize functionality of different string distance algorithms
  *
  * {{{
  * import com.github.vickumar1981.stringdistance.Strategy
  * import com.github.vickumar1981.stringdistance.StringDistance._
  * import com.github.vickumar1981.stringdistance.impl.{ConstantGap, LinearGap}
  *
  * // Scores between strings
  * val cosSimilarity: Double = Cosine.score("hello", "chello", Strategy.splitWord)
  * val damerau: Double = Damerau.score("martha", "marhta")
  * val diceCoefficient: Double = DiceCoefficient.score("martha", "marhta")
  * val hamming: Double = Hamming.score("martha", "marhta")
  * val jaccard: Double = Jaccard.score("karolin", "kathrin", 1)
  * val jaro: Double = Jaro.score("martha", "marhta")
  * val jaroWinkler: Double = JaroWinkler.score("martha", "marhta", 0.1)
  * val levenshtein: Double = Levenshtein.score("martha", "marhta")
  * val needlemanWunsch: Double = NeedlemanWunsch.score("martha", "marhta", ConstantGap())
  * val ngramSimilarity: Double = NGram.score("karolin", "kathrin", 1)
  * val bigramSimilarity: Double = NGram.score("karolin", "kathrin", 2)
  * val overlap: Double = Overlap.score("karolin", "kathrin", 1)
  * val smithWaterman: Double = SmithWaterman.score("martha", "marhta", (LinearGap(gapValue = -1), Integer.MAX_VALUE))
  * val smithWatermanGotoh: Double = SmithWatermanGotoh.score("martha", "marhta", ConstantGap())
  * val tversky: Double = Tversky.score("karolin", "kathrin", 0.5)
  *
  * // Distances between strings
  * val damerauDist: Int = Damerau.distance("martha", "marhta")
  * val hammingDist: Int = Hamming.distance("martha", "marhta")
  * val levenshteinDist: Int = Levenshtein.distance("martha", "marhta")
  * val longestCommonSubSeq: Int = LongestCommonSeq.distance("martha", "marhta")
  * val ngramDist: Int = NGram.distance("karolin", "kathrin", 1)
  * val bigramDist: Int = NGram.distance("karolin", "kathrin", 2)
  * }}}
  */
object StringDistance {
  object Cosine extends WeightedStringMetric[CosineAlgorithm, String]
  object Damerau extends StringMetric[DamerauLevenshteinAlgorithm]
  object DiceCoefficient extends StringMetric[DiceCoefficientAlgorithm]
  object Hamming extends StringMetric[HammingAlgorithm]
  object Jaccard extends WeightedStringMetric[JaccardAlgorithm, Int]
  object Jaro extends StringMetric[JaroAlgorithm]
  object JaroWinkler extends WeightedStringMetric[JaroWinklerAlgorithm, Double]
  object Levenshtein extends StringMetric[LevenshteinAlgorithm]
  object LongestCommonSeq extends StringMetric[LongestCommonSeqAlorithm]
  object NeedlemanWunsch extends WeightedStringMetric[NeedlemanWunschAlgorithm, ConstantGap]
  object NGram extends WeightedStringMetric[NGramAlgorithm, Int]
  object Overlap extends WeightedStringMetric[OverlapAlgorithm, Int]
  object SmithWaterman extends WeightedStringMetric[SmithWatermanAlgorithm, (Gap, Int)]
  object SmithWatermanGotoh extends WeightedStringMetric[SmithWatermanGotohAlgorithm, ConstantGap]
  object Tversky extends WeightedStringMetric[TverskyAlgorithm, Double]
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
class LevenshteinDistanceImplWrapper extends LevenshteinDistanceImpl[Char]

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

