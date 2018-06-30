import org.scalatest._
import org.stringdistance.StringConverter._
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

  "The Levenschtein distance" should "match for all test cases" in {
    testCases.filter(_.levenshtein.isDefined).map(t => {
      val levenschtein = t.s1.levenshtein(t.s2)
      levenschtein should be (t.levenshtein.get)
    })
  }

  "The Dice Coefficient" should "match for all test cases" in {
    testCases.filter(_.diceCoefficient.isDefined).map(t => {
      val diceCoefficient = t.s1.diceCoefficient(t.s2)
      roundToPrecision(diceCoefficient) should be (t.diceCoefficient.get)
    })
  }

  "The Hamming Distance" should "match for all test cases" in {
    testCases.filter(_.hamming.isDefined).map(t => {
      val hamming = t.s1.hamming(t.s2)
      hamming should be (t.hamming.get)
    })
  }

}

