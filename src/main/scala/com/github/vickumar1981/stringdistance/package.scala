package com.github.vickumar1981

import com.github.vickumar1981.stringdistance.impl._

package object stringdistance {

  /**
    * A marker interface for the string distance algorithm.
    */
  trait StringDistanceAlgorithm

  /**
    * A marker interface for the dice coefficient algorithm.
    */
  trait DiceCoefficientAlgorithm extends StringDistanceAlgorithm

  /**
    * A marker interface for the hamming distance algorithm.
    */
  trait HammingAlgorithm extends StringDistanceAlgorithm

  /**
    * A marker interface for a jaccard similarity algorithm.
    */
  trait JaccardAlgorithm extends StringDistanceAlgorithm

  /**
    * A marker interface for the jaro similarity algorithm.
    */
  trait JaroAlgorithm extends StringDistanceAlgorithm

  /**
    * A marker interface for the jaro winkler algorithm.
    */
  trait JaroWinklerAlgorithm extends StringDistanceAlgorithm

  /**
    * A marker interface for the levenshtein distance algorithm.
    */
  trait LevenshteinAlgorithm extends StringDistanceAlgorithm

  /**
    * A marker interface for the longest common subsequence algorithm.
    */
  trait LongestCommonSeqAlorithm extends StringDistanceAlgorithm

  /**
    * A marker interface for the n-gram similarity algorithm.
    */
  trait NGramAlgorithm extends StringDistanceAlgorithm

  /**
    * A marker interface for the cosine similarity algorithm.
    */
  trait CosineAlgorithm extends StringDistanceAlgorithm

  /**
    * The Strategy object has two strategies(reg ex) expressions on which to split input.
    * [[Strategy.splitWord]] splits a word into a sequence of characters.
    * [[Strategy.splitSentence]] splits a sentence into a sequence of words.
    */
  object Strategy {
    final lazy val splitWord = "(?!^)"
    final lazy val splitSentence = "\\W+"
  }

  /**
    * A type class to extend a distance method to [[StringDistanceAlgorithm]].
    */
  trait DistanceAlgorithm[+T <: StringDistanceAlgorithm] {

    /**
      * The distance method takes two strings and returns a distance between them.
      *
      * @param s1 The 1st String.
      * @param s2 The 2nd String.
      * @return Returns the distance between Strings s1 and s2.
      */
    def distance(s1: String, s2: String): Int
  }

  /**
    * A type class to extend a score method to [[StringDistanceAlgorithm]].
    */
  trait ScoringAlgorithm[+T <: StringDistanceAlgorithm] {
    /**
      * The score method takes two strings and returns a fuzzy score (0-1) between them.
      *
      * @param s1 The 1st String.
      * @param s2 The 2nd String.
      * @return Returns the fuzzy score between Strings s1 and s2.
      */
    def score(s1: String, s2: String): Double
  }

  /**
    * A type class to extend a score method with a 2nd typed parameter
    * to [[StringDistanceAlgorithm]].
    */
  trait WeightedScoringAlgorithm[+A <: StringDistanceAlgorithm, B] {
    /**
      * The score method takes two strings and returns a fuzzy score (0-1) between them.
      *
      * @param s1 The 1st String.
      * @param s2 The 2nd String.
      * @return Returns the fuzzy score between Strings s1 and s2.
      */
    def score(s1: String, s2: String, weight: B): Double
  }

  /**
    * A mix-in trait to extend a score method using the distance method
    * to [[StringDistanceAlgorithm]].
    */
  trait ScorableFromDistance[+T <: StringDistanceAlgorithm] extends ScoringAlgorithm[T] { self: DistanceAlgorithm[T] =>
    /**
      * The score method takes two strings and returns a fuzzy score (0-1) between them.
      * This mix-in implements the fuzzy score based on the distance.
      * Score = (l - distance) / l, where l is the maximum length of strings s1 and s2.
      *
      * @param s1 The 1st String.
      * @param s2 The 2nd String.
      * @return Returns the fuzzy score between Strings s1 and s2.
      */
    def score(s1: String, s2: String): Double = {
      val maxLen = Math.max(s1.length, s2.length)
      val minLen = maxLen - distance(s1, s2)
      (if (minLen < 0 || minLen > maxLen) 0d else minLen * 1d) / maxLen
    }
  }

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
    * Implicit definition of dice coefficient score for [[DiceCoefficientAlgorithm]].
    */
  implicit object DiceCoefficientScore extends DiceCoefficientImpl
    with WeightedScoringAlgorithm[DiceCoefficientAlgorithm, Double] {
    /**
      * The score method takes two strings and returns the dice coefficient score between them.
      *
      * @param s1 The 1st String.
      * @param s2 The 2nd String.
      * @return Returns the dice coefficient score between Strings s1 and s2.
      */
    override def score(s1: String, s2: String, weight: Double = 0.1): Double = diceCoefficient(s1, s2, weight)
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
    * Defines implementation for [[StringDistanceAlgorithm]] by adding
    * implicit definitions from [[DistanceAlgorithm]], [[ScoringAlgorithm]] or [[WeightedScoringAlgorithm]]
    */
  trait StringDistanceImpl[A <: StringDistanceAlgorithm] {
    def distance(s1: String, s2: String)
                (implicit algo: DistanceAlgorithm[A]): Int = algo.distance(s1, s2)
    def score(s1: String, s2: String)
             (implicit algo: ScoringAlgorithm[A]): Double = algo.score(s1, s2)
    def score[B](s1: String, s2: String, weight: B)
             (implicit algo: WeightedScoringAlgorithm[A, B]): Double = algo.score(s1, s2, weight)
  }

  /**
    * Object to extend operations to the String class.
    *
    * {{{
    * import com.github.vickumar1981.stringdistance.StringConverter._
    *
    * val cosSimilarity: Double = "hello".cosine("chello")
    * val diceCoefficient: Double = "martha".diceCoefficient("marhta")
    * val diceCoefficientWeighted: Double = "martha".diceCoefficient("marhta", 0.2)
    * val hamming: Double = "martha".hamming("marhta")
    * val jaccard: Double = "karolin".jaccard("kathrin")
    * val jaro: Double = "martha".jaro("marhta")
    * val jaroWinkler: Double = "martha".jaroWinkler("marhta")
    * val levenshtein: Double = "martha".levenshtein("marhta")
    * val ngramSimilarity: Double = "karolin".nGram("kathrin")
    * val bigramSimilarity: Double = "karolin".nGram("kathrin", 2)
    * val hammingDist: Int = "martha".hammingDist("marhta")
    * val levenshteinDist: Int = "martha".levenshteinDist("marhta")
    * val longestCommonSeq: Int = "martha".longestCommonSeq("marhta")
    * }}}
    */
  object StringConverter {
    import StringDistance._
    implicit class StringToStringDistanceConverter(s1: String) {
      def cosine(s2: String, splitOn: String = Strategy.splitWord): Double = Cosine.score(s1, s2, splitOn)
      def diceCoefficient(s2: String, weight: Double = 0.1): Double = DiceCoefficient.score(s1, s2, weight)
      def hamming(s2: String): Double = Hamming.score(s1, s2)
      def hammingDist(s2: String): Int = Hamming.distance(s1, s2)
      def jaccard(s2: String, nGram: Int = 1): Double = Jaccard.score(s1, s2, nGram)
      def jaro(s2: String): Double = Jaro.score(s1, s2)
      def jaroWinkler(s2: String, weight: Double = 0.1): Double =
        JaroWinkler.score(s1, s2, weight)
      def levenshtein(s2: String): Double = Levenshtein.score(s1, s2)
      def levenshteinDist(s2: String): Int = Levenshtein.distance(s1, s2)
      def longestCommonSeq(s2: String): Int = LongestCommonSeq.distance(s1, s2)
      def nGram(s2: String, nGram: Int = 1): Double = NGram.score(s1, s2, nGram)
    }
  }
}
