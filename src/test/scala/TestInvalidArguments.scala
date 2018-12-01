import org.scalatest.{FlatSpec, Matchers}
import com.github.vickumar1981.stringdistance.StringConverter._
import com.github.vickumar1981.stringdistance.impl.ConstantGap

class TestInvalidArguments extends FlatSpec with Matchers {
  "Jaccard score" should "only accept a positive number for n-gram size" in {
    assertThrows[IllegalArgumentException] { "abc".jaccard("abc", -1) }
  }

  "Tversky score" should "only accept a weight between 0 and 1" in {
    assertThrows[IllegalArgumentException] { "abc".tversky("abc", -1) }
  }

  "Jaro-Winkler score" should "only accept a weight between 0 and 1" in {
    assertThrows[IllegalArgumentException] { "abc".jaroWinkler("abc", -1) }
  }

  "Needleman Wunsch score" should "only accept a match value > 0" in {
    assertThrows[IllegalArgumentException] { "abc".needlemanWunsch("abc", ConstantGap(-1, -1, 0)) }
  }

  "Needleman Wunsch score" should "only accept a mismatch value < 0" in {
    assertThrows[IllegalArgumentException] { "abc".needlemanWunsch("abc", ConstantGap(1, 1, 0)) }
  }

  "Needleman Wunsch score" should "only accept a gap value <= 0" in {
    assertThrows[IllegalArgumentException] { "abc".needlemanWunsch("abc", ConstantGap(1, -1, 1)) }
  }

  "NGram score" should "only accept a positive number for n-gram size" in {
    assertThrows[IllegalArgumentException] { "abc".nGram("abc", -1) }
  }

  "NGram distance" should "only accept a positive number for n-gram size" in {
    assertThrows[IllegalArgumentException] { "abc".nGramDist("abc", -1) }
  }

  "Overlap score" should "only accept a positive number for n-gram size" in {
    assertThrows[IllegalArgumentException] { "abc".overlap("abc", -1) }
  }

  "Smith Waterman score" should "only accept a match value > 0" in {
    assertThrows[IllegalArgumentException] { "abc".smithWaterman("abc", ConstantGap(-1, -1, 0)) }
  }

  "Smith Waterman score" should "only accept a mismatch value < 0" in {
    assertThrows[IllegalArgumentException] { "abc".smithWaterman("abc", ConstantGap(1, 1, 0)) }
  }

  "Smith Waterman score" should "only accept a window size > 0" in {
    assertThrows[IllegalArgumentException] { "abc".smithWaterman("abc", ConstantGap(1, -1, 0), -1) }
  }

  "Smith Waterman Gotoh score" should "only accept a match value > 0" in {
    assertThrows[IllegalArgumentException] { "abc".smithWatermanGotoh("abc", ConstantGap(-1, -1, 0)) }
  }

  "Smith Waterman Gotoh score" should "only accept a mismatch value < 0" in {
    assertThrows[IllegalArgumentException] { "abc".smithWatermanGotoh("abc", ConstantGap(1, 1, 0)) }
  }
}
