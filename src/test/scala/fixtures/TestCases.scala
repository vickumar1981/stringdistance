package fixtures

case class TestCase (s1: String,
                     s2: String,
                     jaro: Option[Double] = None,
                     jaroWinkler: Option[Double] = None,
                     levenshtein: Option[Int] = None,
                     diceCoefficient: Option[Double] = None,
                     hamming: Option[Int] = None)

object TestCases {
  lazy val testCases: List[TestCase] = List(
    TestCase("MARTHA", "MARHTA", Some(0.944), Some(0.961), Some(2), Some(0.4)),
    TestCase("DWAYNE", "DUANE", Some(0.822), Some(0.840), Some(2), Some(0.222)),
    TestCase("DIXON", "DICKSONX", Some(0.767), Some(0.813), Some(4), Some(0.364)),
    TestCase("karolin", "kathrin", hamming = Some(3)),
    TestCase("karolin", "kerstin", hamming = Some(3))
  )

  lazy val precision = 3
}
