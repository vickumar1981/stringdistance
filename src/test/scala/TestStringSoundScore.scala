import com.github.vickumar1981.stringdistance.StringConverter._
import fixtures.TestSoundCases.testCases
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class TestStringSoundScore extends AnyFlatSpec with Matchers {
  "The Metaphone Score" should "match for all test cases" in {
    testCases.filter(_.metaphone.isDefined).map(t => {
      val metaphone = t.s1.metaphone(t.s2)
      metaphone should be (t.metaphone.get)
    })
  }

  "The Soundex Score" should "match for all test cases" in {
    testCases.filter(_.soundex.isDefined).map(t => {
      val soundex = t.s1.soundex(t.s2)
      soundex should be (t.soundex.get)
    })
  }
}

