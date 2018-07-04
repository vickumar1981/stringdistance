import com.github.vickumar1981.stringdistance.StringConverter._
import fixtures.TestSoundCases.testCases
import org.scalatest._


class TestStringSoundScore extends FlatSpec with Matchers {
  "The Metaphone Score" should "match for all test cases" in {
    testCases.filter(_.metaphone.isDefined).map(t => {
      val metaphone = t.s1.metaphone(t.s2)
      metaphone should be (t.metaphone.get)
    })
  }
}

