package fixtures

// scalastyle:off
case class TestSoundCase (s1: String, s2: String, metaphone: Option[Boolean] = None)

object TestSoundCases {
  lazy val testCases: List[TestSoundCase] = List(
    TestSoundCase("merci", "mercy", Some(true)),
    TestSoundCase("dumb", "gum", Some(false)),
    TestSoundCase("", "abc", Some(false))
  )
}
