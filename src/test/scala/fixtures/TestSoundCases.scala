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
    TestSoundCase("robert", "rubin", Some(false), Some(false)),
    TestSoundCase("night", "knight", Some(true), Some(false)),
    TestSoundCase("isle", "aisle", Some(false), Some(false)),
    TestSoundCase("pair", "pear", Some(true), Some(true)),
    TestSoundCase("site", "cite", Some(true), Some(false)),
    TestSoundCase("sight", "cite", Some(false), Some(false)),
    TestSoundCase("science", "seance", Some(true), Some(true)),
    TestSoundCase("wretch", "retch", Some(true), Some(false)),
    TestSoundCase("bathhouses", "bathowses", Some(true), Some(true)),
    TestSoundCase("box", "balks", Some(false), Some(false)),
    TestSoundCase("eve", "eave", Some(true), Some(true)),
    TestSoundCase("does", "doze", Some(true), Some(true)),
    TestSoundCase("oh", "owe", Some(false), Some(true)),
    TestSoundCase("washhouse", "watchhouse", Some(true), Some(false)),
    TestSoundCase("aha", "haha", Some(false), Some(false)),
    TestSoundCase("hodge", "hoge", Some(false), Some(false)),
    TestSoundCase("xanax", "zanax", Some(true), Some(false)),
    TestSoundCase("whirl", "wiril", Some(true), Some(true)),
    TestSoundCase("squirrel", "skwerl", Some(false), Some(true)),
    TestSoundCase("lackey", "lakie", Some(true), Some(true))
  )
}
