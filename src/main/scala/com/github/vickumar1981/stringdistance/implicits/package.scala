package com.github.vickumar1981.stringdistance

import com.github.vickumar1981.stringdistance.impl._
import com.github.vickumar1981.stringdistance.impl.sound.{MetaphoneImpl, SoundexImpl}

package object implicits {
  /**
    * Implicit definition of cosine similarity score for [[CosineAlgorithm]].
    */
  implicit object CosSimilarityScore extends CosSimilarityImpl
    with WeightedScoringAlgorithm[CosineAlgorithm, String] {
    /**
      * The score method takes two strings and returns the cosine similarity between them.
      *
      * @param s1 The 1st String.
      * @param s2 The 2nd String.
      * @return Returns the cosine similarity between Strings s1 and s2.
      */
    override def score(s1: String, s2: String, splitOn: String = Strategy.splitWord): Double = cosSimilarity(s1, s2)
  }

  /**
    * Implicit definition of damerau levenshtein distance for [[DamerauLevenshteinAlgorithm]].
    */
  implicit object DamerauLevenshteinDistance extends LevenshteinDistanceImpl
    with DistanceAlgorithm[DamerauLevenshteinAlgorithm] with ScorableFromDistance[DamerauLevenshteinAlgorithm] {
    /**
      * The score method takes two strings and returns the damerau levenshtein distance between them.
      *
      * @param s1 The 1st String.
      * @param s2 The 2nd String.
      * @return Returns the damerau levenshtein distance between Strings s1 and s2.
      */
    override def distance(s1: String, s2: String): Int = damerauLevenshtein(s1, s2)
  }

  /**
    * Implicit definition of dice coefficient score for [[DiceCoefficientAlgorithm]].
    */
  implicit object DiceCoefficientScore extends DiceCoefficientImpl
    with ScoringAlgorithm[DiceCoefficientAlgorithm] {
    /**
      * The score method takes two strings and returns the dice coefficient score between them.
      *
      * @param s1 The 1st String.
      * @param s2 The 2nd String.
      * @return Returns the dice coefficient score between Strings s1 and s2.
      */
    override def score(s1: String, s2: String): Double = diceCoefficient(s1, s2)
  }

  /**
    * Implicit definition of hamming distance for [[HammingAlgorithm]].
    */
  implicit object HammingDistance extends HammingImpl
    with DistanceAlgorithm[HammingAlgorithm] with ScorableFromDistance[HammingAlgorithm] {
    /**
      * The distance method takes two strings and returns the hamming distance between them.
      *
      * @param s1 The 1st String.
      * @param s2 The 2nd String.
      * @return Returns the hamming distance between Strings s1 and s2.
      */
    override def distance(s1: String, s2: String): Int = hamming(s1, s2)
  }

  /**
    * Implicit definition of jaccard score for [[JaccardAlgorithm]].
    */
  implicit object JaccardScore extends JaccardImpl with WeightedScoringAlgorithm[JaccardAlgorithm, Int] {
    /**
      * The score method takes two strings and returns jaccard score between them.
      *
      * @param s1 The 1st String.
      * @param s2 The 2nd String.
      * @return Returns the jaccard score between Strings s1 and s2.
      */
    override def score(s1: String, s2: String, n: Int = 1): Double = jaccard(s1, s2, n)
  }

  /**
    * Implicit definition of jaro score for [[JaroAlgorithm]].
    */
  implicit object JaroScore extends JaroImpl with ScoringAlgorithm[JaroAlgorithm] {
    /**
      * The score method takes two strings and returns the jaro score between them.
      *
      * @param s1 The 1st String.
      * @param s2 The 2nd String.
      * @return Returns the jaro score between Strings s1 and s2.
      */
    override def score(s1: String, s2: String): Double = jaro(s1, s2)
  }

  /**
    * Implicit definition of jaro winkler score for [[JaroWinklerAlgorithm]].
    */
  implicit object JaroWinklerScore extends JaroImpl with WeightedScoringAlgorithm[JaroWinklerAlgorithm, Double] {
    /**
      * The score method takes two strings and returns the jaro winkler score between them.
      *
      * @param s1 The 1st String.
      * @param s2 The 2nd String.
      * @return Returns the jaro winkler score between Strings s1 and s2.
      */
    override def score(s1: String, s2: String, weight: Double = 0.1): Double = jaroWinkler(s1, s2, weight)
  }

  /**
    * Implicit definition of levenshtein distance for [[LevenshteinAlgorithm]].
    */
  implicit object LevenshteinDistance extends LevenshteinDistanceImpl
    with DistanceAlgorithm[LevenshteinAlgorithm] with ScorableFromDistance[LevenshteinAlgorithm] {
    /**
      * The score method takes two strings and returns the levenshtein distance between them.
      *
      * @param s1 The 1st String.
      * @param s2 The 2nd String.
      * @return Returns the levenshtein distance between Strings s1 and s2.
      */
    override def distance(s1: String, s2: String): Int = levenshtein(s1, s2)
  }

  /**
    * Implicit definition of longest common subsequence for [[CosineAlgorithm]].
    */
  implicit object LongestCommonSeqDistance extends LongestCommonSeqImpl
    with DistanceAlgorithm[LongestCommonSeqAlorithm] {
    /**
      * The score method takes two strings and returns longest common subsequence distance between them.
      *
      * @param s1 The 1st String.
      * @param s2 The 2nd String.
      * @return Returns the longest common subsequence distance between Strings s1 and s2.
      */
    override def distance(s1: String, s2: String): Int = longestCommonSeq(s1, s2)
  }

  /**
    * Implicit definition of needleman wunsch score for [[NeedlemanWunschAlgorithm]].
    */
  implicit object NeedlemanWunschScore extends NeedlemanWunschImpl
    with WeightedScoringAlgorithm[NeedlemanWunschAlgorithm, ConstantGap] {
    /**
      * The score method takes two strings and returns needleman wunsch similarity between them.
      *
      * @param s1 The 1st String.
      * @param s2 The 2nd String.
      * @return Returns the needleman wunsch similarity between Strings s1 and s2.
      */
    override def score(s1: String, s2: String, gap: ConstantGap = ConstantGap()): Double =
      needleman(s1, s2, gap)
  }

  /**
    * Implicit definition of n-gram distance for [[NGramAlgorithm]].
    */
  implicit object NGramDistance extends NGramImpl with WeightedDistanceAlgorithm[NGramAlgorithm, Int] {
    /**
      * The score method takes two strings and returns n-gram similarity between them.
      *
      * @param s1 The 1st String.
      * @param s2 The 2nd String.
      * @return Returns the n-gram distance between Strings s1 and s2.
      */
    override def distance(s1: String, s2: String, n: Int = 1): Int = nGramDist(s1, s2, n)
  }

  /**
    * Implicit definition of n-gram score for [[NGramAlgorithm]].
    */
  implicit object NGramScore extends NGramImpl with WeightedScoringAlgorithm[NGramAlgorithm, Int] {
    /**
      * The score method takes two strings and returns n-gram similarity between them.
      *
      * @param s1 The 1st String.
      * @param s2 The 2nd String.
      * @return Returns the n-gram similarity between Strings s1 and s2.
      */
    override def score(s1: String, s2: String, n: Int = 1): Double = nGram(s1, s2, n)
  }

  /**
    * Implicit definition of overlap score for [[OverlapAlgorithm]].
    */
  implicit object OverlapScore extends OverlapImpl with WeightedScoringAlgorithm[OverlapAlgorithm, Int] {
    /**
      * The score method takes two strings and returns n-gram similarity between them.
      *
      * @param s1 The 1st String.
      * @param s2 The 2nd String.
      * @return Returns the overlap similarity between Strings s1 and s2.
      */
    override def score(s1: String, s2: String, n: Int = 1): Double = overlap(s1, s2, n)
  }

  /**
    * Implicit definition of metaphone score for [[MetaphoneAlgorithm]].
    */
  implicit object MetaphoneScore extends MetaphoneImpl with SoundScoringAlgorithm[MetaphoneAlgorithm] {
    /**
      * The score method takes two strings and returns whether they sound alike.
      *
      * @param s1 The 1st String.
      * @param s2 The 2nd String.
      * @return Returns true or false if String s1 sounds like string s2.
      */
    override def score(s1: String, s2: String): Boolean = metaphone(s1, s2)
  }

  /**
    * Implicit definition of smith waterman score for [[SmithWatermanAlgorithm]].
    */
  implicit object SmithWatermanScore extends SmithWatermanImpl
    with WeightedScoringAlgorithm[SmithWatermanAlgorithm, (Gap, Int)] {
    /**
      * The score method takes two strings and returns smith waterman similarity between them.
      *
      * @param s1 The 1st String.
      * @param s2 The 2nd String.
      * @return Returns the smith waterman similarity between Strings s1 and s2.
      */
    override def score(s1: String, s2: String,
                       gapAndWindowSize: (Gap, Int) = (LinearGap(gapValue = 1), Integer.MAX_VALUE)): Double =
      smithWaterman(s1, s2, gapAndWindowSize._1, gapAndWindowSize._2)
  }

  /**
    * Implicit definition of smith waterman gotoh score for [[SmithWatermanGotohAlgorithm]].
    */
  implicit object SmithWatermanGotohScore extends SmithWatermanImpl
    with WeightedScoringAlgorithm[SmithWatermanGotohAlgorithm, ConstantGap] {
    /**
      * The score method takes two strings and returns smith waterman similarity between them.
      *
      * @param s1 The 1st String.
      * @param s2 The 2nd String.
      * @return Returns the smith waterman gotoh similarity between Strings s1 and s2.
      */
    override def score(s1: String, s2: String, gap: ConstantGap = ConstantGap()): Double =
      smithWatermanGotoh(s1, s2, gap)
  }

  /**
    * Implicit definition of soundex score for [[SoundexAlgorithm]].
    */
  implicit object SoundexScore extends SoundexImpl with SoundScoringAlgorithm[SoundexAlgorithm] {
    /**
      * The score method takes two strings and returns whether they sound alike.
      *
      * @param s1 The 1st String.
      * @param s2 The 2nd String.
      * @return Returns true or false if String s1 sounds like string s2.
      */
    override def score(s1: String, s2: String): Boolean = soundex(s1, s2)
  }

  /**
    * Implicit definition of tversky score for [[TverskyAlgorithm]].
    */
  implicit object TverskyScore extends JaccardImpl with WeightedScoringAlgorithm[TverskyAlgorithm, Double] {
    /**
      * The score method takes two strings and returns tversky score between them.
      *
      * @param s1 The 1st String.
      * @param s2 The 2nd String.
      * @return Returns the tversky score between Strings s1 and s2.
      */
    override def score(s1: String, s2: String, n: Double = 1): Double = tversky(s1, s2, n)
  }
}
