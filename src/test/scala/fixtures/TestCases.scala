package fixtures

case class TestCase (s1: String,
                     s2: String,
                     jaro: Option[Double] = None,
                     jaroWinkler: Option[Double] = None,
                     levenshtein: Option[Int] = None,
                     diceCoefficient: Option[Double] = None,
                     hamming: Option[Int] = None,
                     ngram: Option[Double] = None)

object TestCases {
  lazy val testCases: List[TestCase] = List(
    TestCase("MARTHA", "MARHTA", Some(0.944), Some(0.961), Some(2), Some(0.4), ngram = Some(0d)),
    TestCase("DWAYNE", "DUANE", Some(0.822), Some(0.840), Some(2), Some(0.222)),
    TestCase("DIXON", "DICKSONX", Some(0.767), Some(0.813), Some(4), Some(0.364)),
    TestCase("karolin", "kathrin", hamming = Some(3), ngram = Some(0.286)),
    TestCase("karolin", "kerstin", hamming = Some(3)),
    TestCase("ABC", "ABCD", hamming = Some(-1)),
    TestCase("A", "B", jaro = Some(0d), jaroWinkler = Some(0d)),
    TestCase("night", "nact", Some(0.633), Some(0.67), Some(3), ngram = Some(0.6)),
    TestCase("", "abc", ngram = Some(0d)),
    TestCase("abc", "abc", Some(1), Some(1), Some(0), Some(1), Some(0), ngram = Some(1d))
  )

  lazy val precision = 3
}
