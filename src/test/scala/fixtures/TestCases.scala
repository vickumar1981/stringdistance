package fixtures

// scalastyle:off
case class TestCase (s1: String,
                     s2: String,
                     jaro: Option[Double] = None,
                     jaroWinkler: Option[Double] = None,
                     levenshtein: Option[Double] = None,
                     levenshteinDist: Option[Int] = None,
                     diceCoefficient: Option[Double] = None,
                     hamming: Option[Double] = None,
                     hammingDist: Option[Int] = None,
                     ngram: Option[Double] = None,
                     cosine: Option[Double] = None,
                     jaccard: Option[Double] = None,
                     longestCommonSeq: Option[Int] = None,
                     overlap: Option[Double] = None,
                     nGramDist: Option[Int] = None,
                     damerau: Option[Double] = None,
                     damerauDist: Option[Int] = None)

object TestCases {
  lazy val testCases: List[TestCase] = List(
    TestCase("MARTHA", "MARHTA", Some(0.944), Some(0.961), Some(0.667), Some(2), Some(0.4),
      ngram = Some(0),
      longestCommonSeq = Some(5), overlap = Some(0),
      damerau = Some(0.833),
      damerauDist = Some(1)),
    TestCase("DWAYNE", "DUANE", Some(0.822), Some(0.840), Some(0.667), Some(2), Some(0.222),
      damerau = Some(0.667), damerauDist = Some(2)),
    TestCase("DIXON", "DICKSONX", Some(0.767), Some(0.813), Some(0.5), Some(4), Some(0.364)),
    TestCase("karolin", "kathrin", hamming = Some(0.571), hammingDist = Some(3),
      ngram = Some(0.286), overlap = Some(0.286), nGramDist = Some(5)),
    TestCase("karolin", "kerstin", hamming = Some(0.571), hammingDist = Some(3)),
    TestCase("ABC", "ABCD", hamming = Some(0), hammingDist = Some(-1)),
    TestCase("A", "B", jaro = Some(0), jaroWinkler = Some(0)),
    TestCase("night", "nact", Some(0.633), Some(0.67), Some(0.4), Some(3), ngram = Some(0.6),
      jaccard = Some(0.286), overlap = Some(0.5), nGramDist = Some(2)),
    TestCase("", "abc", ngram = Some(0), jaccard = Some(0), overlap = Some(0),
      nGramDist = Some(0), levenshteinDist = Some(3), damerauDist = Some(3), levenshtein = Some(0), damerau = Some(0)),
    TestCase("abc", "abc", Some(1), Some(1), Some(1), Some(0), Some(1), Some(1), Some(0), Some(1), jaccard = Some(1),
      nGramDist = Some(3)),
    TestCase("hello", "chello", cosine = Some(0.935)),
    TestCase("hello", "hell", cosine = Some(0.926)),
    TestCase("hello", "hellhole", cosine = Some(0.980)),
    TestCase("hello", "hello", cosine = Some(1), overlap = Some(1)),
    TestCase("ABCDGH", "AEDFHR", longestCommonSeq = Some(3)),
    TestCase("AGGTAB", "GXTXAYB", longestCommonSeq = Some(4))
  )

  lazy val precision = 3
}
