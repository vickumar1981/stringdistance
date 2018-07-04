package fixtures

// scalastyle:off
case class TestSoundCase (s1: String, s2: String,
                          metaphone: Option[Boolean] = None,
                          soundex: Option[Boolean] = None)

object TestSoundCases {
  lazy val testCases: List[TestSoundCase] = List(
    TestSoundCase("merci", "mercy", Some(true), Some(true)),
    TestSoundCase("dumb", "gum", Some(false), Some(false)),
    TestSoundCase("", "abc", Some(false), Some(false)),
    TestSoundCase("robert", "rupert", Some(false), Some(true)),
    TestSoundCase("robert", "rubin", Some(false), Some(false))
  )
}
