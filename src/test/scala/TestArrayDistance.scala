import com.github.vickumar1981.stringdistance.ArrayDistance._
import com.github.vickumar1981.stringdistance.impl.{ConstantGap, LinearGap}
import fixtures.TestArrayMetric
import fixtures.TestCases.{precision, testCases}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.math.BigDecimal

class TestArrayDistance extends AnyFlatSpec with Matchers with TestArrayMetric {

  private def roundToPrecision(v: Double) =
    BigDecimal(v).setScale(precision, BigDecimal.RoundingMode.HALF_UP).toDouble

  "The Jaro Score" should "match for all test cases" in {
    testCases.filter(_.jaro.isDefined).map(t => {
      val jaro = Jaro.score(t.s1, t.s2)
      roundToPrecision(jaro) should be (t.jaro.get)
    })
  }

  "The Jaro-Winkler Score" should "match for all test cases" in {
    testCases.filter(_.jaroWinkler.isDefined).map(t => {
      val jaroWinkler = JaroWinkler.score(t.s1, t.s2)
      roundToPrecision(jaroWinkler) should be (t.jaroWinkler.get)
    })
  }

  "The Levenschtein Distance" should "match for all test cases" in {
    testCases.filter(_.levenshteinDist.isDefined).map(t => {
      val levenschteinDist = Levenshtein.distance(t.s1, t.s2)
      levenschteinDist should be (t.levenshteinDist.get)
    })
  }

  "The Levenschtein Score" should "match for all test cases" in {
    testCases.filter(_.levenshtein.isDefined).map(t => {
      val levenschtein = Levenshtein.score(t.s1, t.s2)
      roundToPrecision(levenschtein) should be (t.levenshtein.get)
    })
  }

  "The Damerau-Levenschtein Distance" should "match for all test cases" in {
    testCases.filter(_.damerauDist.isDefined).map(t => {
      val damerauDist = Damerau.distance(t.s1, t.s2)
      damerauDist should be (t.damerauDist.get)
    })
  }

  "The Damerau-Levenschtein Score" should "match for all test cases" in {
    testCases.filter(_.damerau.isDefined).map(t => {
      val damerau = Damerau.score(t.s1, t.s2)
      roundToPrecision(damerau) should be (t.damerau.get)
    })
  }

  "The Dice Coefficient" should "match for all test cases" in {
    testCases.filter(_.diceCoefficient.isDefined).map(t => {
      val diceCoefficient = DiceCoefficient.score(t.s1, t.s2)
      roundToPrecision(diceCoefficient) should be (t.diceCoefficient.get)
    })
  }

  "The Hamming Distance" should "match for all test cases" in {
    testCases.filter(_.hammingDist.isDefined).map(t => {
      val hammingDist = Hamming.distance(t.s1, t.s2)
      hammingDist should be (t.hammingDist.get)
    })
  }

  "The Hamming Score" should "match for all test cases" in {
    testCases.filter(_.hamming.isDefined).map(t => {
      val hamming = Hamming.score(t.s1, t.s2)
      roundToPrecision(hamming) should be (t.hamming.get)
    })
  }

  "The N-Gram Distance" should "match for all test cases" in {
    testCases.filter(_.nGramDist.isDefined).map(t => {
      val nGramDist = NGram.distance(t.s1, t.s2)
      roundToPrecision(nGramDist) should be (t.nGramDist.get)
    })
  }

  "The N-Gram Similarity" should "match for all test cases" in {
    testCases.filter(_.ngram.isDefined).map(t => {
      val nGram = NGram.score(t.s1, t.s2)
      roundToPrecision(nGram) should be (t.ngram.get)
    })
  }

  "The N-Gram bigrams" should "return a list of length equal to the string's length minus 1" in {
    testCases.filter(_.ngram.isDefined).filter(_.s1.nonEmpty).map(t => {
      val tokens = NGram.tokens(t.s1, 2)
      tokens.size should be (t.s1.length - 1)
    })
  }

  "The Cosine Similarity" should "match for all test cases" in {
    testCases.filter(_.cosine.isDefined).map(t => {
      val cosine = Cosine.score(t.s1, t.s2)
      roundToPrecision(cosine) should be (t.cosine.get)
    })
  }

  "The Jaccard Similarity" should "match for all test cases" in {
    testCases.filter(_.jaccard.isDefined).map(t => {
      val jaccard = Jaccard.score(t.s1, t.s2)
      roundToPrecision(jaccard) should be (t.jaccard.get)
    })
  }

  "The Longest Common Subsequence" should "match for all test cases" in {
    testCases.filter(_.longestCommonSeq.isDefined).map(t => {
      val longestCommonSeq = LongestCommonSeq.distance(t.s1, t.s2)
      roundToPrecision(longestCommonSeq) should be (t.longestCommonSeq.get)
    })
  }

  "The Overlap Score" should "match for all test cases" in {
    testCases.filter(_.overlap.isDefined).map(t => {
      val overlap = Overlap.score(t.s1, t.s2)
      roundToPrecision(overlap) should be (t.overlap.get)
    })
  }

  "The Tversky Score with weight 0.5" should "match the dice coefficient" in {
    testCases.filter(_.diceCoefficient.isDefined).map(t => {
      val tversky = Tversky.score(t.s1, t.s2, 0.5)
      roundToPrecision(tversky) should be (t.diceCoefficient.get)
    })
  }

  "The Tversky Score with weight 2.0" should "match the jaccard score using bigrams" in {
    testCases.filter(_.jaccard.isDefined).map(t => {
      val tversky = Tversky.score(t.s1, t.s2)
      val jaccard = Jaccard.score(t.s1, t.s2, 2)
      roundToPrecision(tversky) should be (roundToPrecision(jaccard))
    })
  }

  "The Needleman-Wunsch Score with a ConstantGap(1, -1, 0)" should "match the damerau score when strings have same length" in {
    testCases.filter(t => t.s1.length == t.s2.length && t.damerau.isDefined).map(t => {
      val needlemanWunsch = NeedlemanWunsch.score(t.s1,
        t.s2,
        ConstantGap(misMatchValue = -1)
      )
      val damerau = Damerau.score(t.s1, t.s2)
      roundToPrecision(needlemanWunsch) should be (roundToPrecision(damerau))
    })
  }

  "The Needleman-Wunsch Score with a ConstantGap(1, -1, -1)" should "match the levenshtein score when strings have same length" in {
    testCases.filter(t => t.s1.length == t.s2.length && t.levenshtein.isDefined).map(t => {
      val needlemanWunsch = NeedlemanWunsch.score(t.s1,
        t.s2,
        ConstantGap(
          misMatchValue = -1,
          gapValue = -1
        ))
      val levenshtein = Levenshtein.score(t.s1, t.s2)
      roundToPrecision(needlemanWunsch) should be (roundToPrecision(levenshtein))
    })
  }

  "The Needleman-Wunsch Score" should "score symmetrically when either string is empty" in {
    testCases.filter(_.s1.isEmpty).map(t => {
      val needlemanWunsch1 = NeedlemanWunsch.score(t.s1, t.s2)
      val needlemanWunsch2 = NeedlemanWunsch.score(t.s2, t.s1)
      roundToPrecision(needlemanWunsch1) should be (roundToPrecision(needlemanWunsch2))
    })
  }

  "The Smith Waterman Score with an LinearGap(1, -1, -1)" should "match the damerau score when strings have same length" in {
    testCases.filter(t => t.s1.length == t.s2.length && t.levenshtein.isDefined).map(t => {
      val smithWaterman = SmithWaterman.score(t.s1,
        t.s2,
        LinearGap(
          misMatchValue = -1,
          gapValue = -1
        ))
      val damerau = Damerau.score(t.s1, t.s2)
      roundToPrecision(smithWaterman) should be (roundToPrecision(damerau))
    })
  }

  "The Smith Waterman Score" should "be 0 if only one string is empty" in {
    SmithWaterman.score("", "abc") should be (0)
  }

  "The Smith Waterman Gotoh Score" should "match for all test cases" in {
    testCases.filter(_.smithWatermanGotoh.isDefined).map(t => {
      val smithWatermanGotoh = SmithWatermanGotoh.score(t.s1, t.s2)
      roundToPrecision(smithWatermanGotoh) should be (t.smithWatermanGotoh.get)
    })
  }

  "The Smith Waterman Gotoh Score" should "be 0 if only one string is empty" in {
    SmithWaterman.score("", "abc") should be (0)
  }
}

