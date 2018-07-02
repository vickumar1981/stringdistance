import org.scalatest._
import com.github.vickumar1981.stringdistance.StringConverter._
import scala.math.BigDecimal
import fixtures.TestCases.{precision, testCases}

class TestStringDistance extends FlatSpec with Matchers {
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
}

