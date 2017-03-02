import org.scalatest._
import org.stringdistance.StringDistance
import scala.math.BigDecimal

class TestStringDistance extends FlatSpec with Matchers {
  private lazy val precision = 3
  private lazy val data = List(
    ("MARTHA", "MARHTA", 0.944, 0.961),
    ("DWAYNE", "DUANE", 0.822, 0.840),
    ("DIXON", "DICKSONX", 0.767, 0.813)
  )

  private def roundToPrecision(v: Double) =
    BigDecimal(v).setScale(precision, BigDecimal.RoundingMode.HALF_UP).toDouble

  "The Jaro Score" should "match for all test cases" in {
    data.map(d => {
      val jaro = StringDistance.jaro(d._1, d._2)
      roundToPrecision(jaro) should be (d._3)
    })
  }

  "The Jaro-Winkler Score" should "match for all test cases" in {
    data.map(d => {
      val jaroWinkler = StringDistance.jaroWinkler(d._1, d._2)
      roundToPrecision(jaroWinkler) should be (d._4)
    })
  }

}

