import com.github.vickumar1981.stringdistance.StringConverter._
import com.github.vickumar1981.stringdistance.impl.{ConstantGap, LinearGap}

import scala.math.BigDecimal
import fixtures.TestCases.{precision, testCases}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TestStringDistance extends AnyFlatSpec with Matchers {
  private def roundToPrecision(v: Double) =
    BigDecimal(v).setScale(precision, BigDecimal.RoundingMode.HALF_UP).toDouble

  "The Jaro Score" should "match for all test cases" in {
    testCases.filter(_.jaro.isDefined).map(t => {
      val jaro = t.s1.jaro(t.s2)
      roundToPrecision(jaro) should be (t.jaro.get)
    })
  }

  "The Jaro-Winkler Score" should "match for all test cases" in {
    testCases.filter(_.jaroWinkler.isDefined).map(t => {
      val jaroWinkler = t.s1.jaroWinkler(t.s2)
      roundToPrecision(jaroWinkler) should be (t.jaroWinkler.get)
    })
  }

  "The Levenschtein Distance" should "match for all test cases" in {
    testCases.filter(_.levenshteinDist.isDefined).map(t => {
      val levenschteinDist = t.s1.levenshteinDist(t.s2)
      levenschteinDist should be (t.levenshteinDist.get)
    })
  }

  "The Levenschtein Score" should "match for all test cases" in {
    testCases.filter(_.levenshtein.isDefined).map(t => {
      val levenschtein = t.s1.levenshtein(t.s2)
      roundToPrecision(levenschtein) should be (t.levenshtein.get)
    })
  }

  "The Damerau-Levenschtein Distance" should "match for all test cases" in {
    testCases.filter(_.damerauDist.isDefined).map(t => {
      val damerauDist = t.s1.damerauDist(t.s2)
      damerauDist should be (t.damerauDist.get)
    })
  }

  "The Damerau-Levenschtein Score" should "match for all test cases" in {
    testCases.filter(_.damerau.isDefined).map(t => {
      val damerau = t.s1.damerau(t.s2)
      roundToPrecision(damerau) should be (t.damerau.get)
    })
  }

  "The Dice Coefficient" should "match for all test cases" in {
    testCases.filter(_.diceCoefficient.isDefined).map(t => {
      val diceCoefficient = t.s1.diceCoefficient(t.s2)
      roundToPrecision(diceCoefficient) should be (t.diceCoefficient.get)
    })
  }

  "The Hamming Distance" should "match for all test cases" in {
    testCases.filter(_.hammingDist.isDefined).map(t => {
      val hammingDist = t.s1.hammingDist(t.s2)
      hammingDist should be (t.hammingDist.get)
    })
  }

  "The Hamming Score" should "match for all test cases" in {
    testCases.filter(_.hamming.isDefined).map(t => {
      val hamming = t.s1.hamming(t.s2)
      roundToPrecision(hamming) should be (t.hamming.get)
    })
  }

  "The N-Gram Distance" should "match for all test cases" in {
    testCases.filter(_.nGramDist.isDefined).map(t => {
      val nGramDist = t.s1.nGramDist(t.s2)
      roundToPrecision(nGramDist) should be (t.nGramDist.get)
    })
  }

  "The N-Gram Similarity" should "match for all test cases" in {
    testCases.filter(_.ngram.isDefined).map(t => {
      val nGram = t.s1.nGram(t.s2)
      roundToPrecision(nGram) should be (t.ngram.get)
    })
  }

  "The Cosine Similarity" should "match for all test cases" in {
    testCases.filter(_.cosine.isDefined).map(t => {
      val cosine = t.s1.cosine(t.s2)
      roundToPrecision(cosine) should be (t.cosine.get)
    })
  }

  "The Jaccard Similarity" should "match for all test cases" in {
    testCases.filter(_.jaccard.isDefined).map(t => {
      val jaccard = t.s1.jaccard(t.s2)
      roundToPrecision(jaccard) should be (t.jaccard.get)
    })
  }

  "The Longest Common Subsequence" should "match for all test cases" in {
    testCases.filter(_.longestCommonSeq.isDefined).map(t => {
      val longestCommonSeq = t.s1.longestCommonSeq(t.s2)
      roundToPrecision(longestCommonSeq) should be (t.longestCommonSeq.get)
    })
  }

  "The Overlap Score" should "match for all test cases" in {
    testCases.filter(_.overlap.isDefined).map(t => {
      val overlap = t.s1.overlap(t.s2)
      roundToPrecision(overlap) should be (t.overlap.get)
    })
  }

  "The Tversky Score with weight 0.5" should "match the dice coefficient" in {
    testCases.filter(_.diceCoefficient.isDefined).map(t => {
      val tversky = t.s1 tversky (t.s2, 0.5)
      roundToPrecision(tversky) should be (t.diceCoefficient.get)
    })
  }

  "The Tversky Score with weight 2.0" should "match the jaccard score using bigrams" in {
    testCases.filter(_.jaccard.isDefined).map(t => {
      val tversky = t.s1 tversky t.s2
      val jaccard = t.s1 jaccard (t.s2, 2)
      roundToPrecision(tversky) should be (roundToPrecision(jaccard))
    })
  }

  "The Needleman-Wunsch Score with a ConstantGap(1, -1, 0)" should "match the damerau score when strings have same length" in {
    testCases.filter(t => t.s1.length == t.s2.length && t.damerau.isDefined).map(t => {
      val needlemanWunsch = t.s1.needlemanWunsch(
        t.s2,
        ConstantGap(misMatchValue = -1)
      )
      val damerau = t.s1.damerau(t.s2)
      roundToPrecision(needlemanWunsch) should be (roundToPrecision(damerau))
    })
  }

  "The Needleman-Wunsch Score with a ConstantGap(1, -1, -1)" should "match the levenshtein score when strings have same length" in {
    testCases.filter(t => t.s1.length == t.s2.length && t.levenshtein.isDefined).map(t => {
      val needlemanWunsch = t.s1.needlemanWunsch(
        t.s2,
        ConstantGap(
          misMatchValue = -1,
          gapValue = -1
        ))
      val levenshtein = t.s1.levenshtein(t.s2)
      roundToPrecision(needlemanWunsch) should be (roundToPrecision(levenshtein))
    })
  }

  "The Needleman-Wunsch Score" should "score symmetrically when either string is empty" in {
    testCases.filter(_.s1.isEmpty).map(t => {
      val needlemanWunsch1 = t.s1.needlemanWunsch(t.s2)
      val needlemanWunsch2 = t.s2.needlemanWunsch(t.s1)
      roundToPrecision(needlemanWunsch1) should be (roundToPrecision(needlemanWunsch2))
    })
  }

  "The Smith Waterman Score with an LinearGap(1, -1, -1)" should "match the damerau score when strings have same length" in {
    testCases.filter(t => t.s1.length == t.s2.length && t.levenshtein.isDefined).map(t => {
      val smithWaterman = t.s1.smithWaterman(
        t.s2,
        LinearGap(
          misMatchValue = -1,
          gapValue = -1
        ))
      val damerau= t.s1.damerau(t.s2)
      roundToPrecision(smithWaterman) should be (roundToPrecision(damerau))
    })
  }

  "The Smith Waterman Score" should "be 0 if only one string is empty" in {
    "".smithWaterman("abc") should be (0)
  }

  "The Smith Waterman Gotoh Score" should "match for all test cases" in {
    testCases.filter(_.smithWatermanGotoh.isDefined).map(t => {
      val smithWatermanGotoh = t.s1.smithWatermanGotoh(t.s2)
      roundToPrecision(smithWatermanGotoh) should be (t.smithWatermanGotoh.get)
    })
  }

  "The Smith Waterman Gotoh Score" should "be 0 if only one string is empty" in {
    "".smithWatermanGotoh("abc") should be (0)
  }
}

