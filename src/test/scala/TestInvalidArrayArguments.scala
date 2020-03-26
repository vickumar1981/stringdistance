import com.github.vickumar1981.stringdistance.ArrayDistance._
import com.github.vickumar1981.stringdistance.impl.ConstantGap
import fixtures.TestArrayMetric
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TestInvalidArrayArguments extends AnyFlatSpec with Matchers with TestArrayMetric {
  "Jaccard score" should "only accept a positive number for n-gram size" in {
    assertThrows[IllegalArgumentException] { Jaccard.score("abc", "abc", -1) }
  }

  "Tversky score" should "only accept a weight between 0 and 1" in {
    assertThrows[IllegalArgumentException] { Tversky.score("abc", "abc", -1) }
  }

  "Jaro-Winkler score" should "only accept a weight between 0 and 1" in {
    assertThrows[IllegalArgumentException] { JaroWinkler.score("abc", "abc", -1) }
  }

  "Needleman Wunsch score" should "only accept a match value > 0" in {
    assertThrows[IllegalArgumentException] { NeedlemanWunsch.score("abc", "abc", ConstantGap(-1, -1, 0)) }
  }

  "Needleman Wunsch score" should "only accept a mismatch value < 0" in {
    assertThrows[IllegalArgumentException] { NeedlemanWunsch.score("abc", "abc", ConstantGap(1, 1, 0)) }
  }

  "Needleman Wunsch score" should "only accept a gap value <= 0" in {
    assertThrows[IllegalArgumentException] { NeedlemanWunsch.score("abc", "abc", ConstantGap(1, -1, 1)) }
  }

  "NGram score" should "only accept a positive number for n-gram size" in {
    assertThrows[IllegalArgumentException] { NGram.score("abc", "abc", -1) }
  }

  "NGram distance" should "only accept a positive number for n-gram size" in {
    assertThrows[IllegalArgumentException] { NGram.distance("abc", "abc", -1) }
  }

  "Overlap score" should "only accept a positive number for n-gram size" in {
    assertThrows[IllegalArgumentException] { Overlap.score("abc", "abc", -1) }
  }

  "Smith Waterman score" should "only accept a match value > 0" in {
    assertThrows[IllegalArgumentException] {
      SmithWaterman.score("abc", "abc", ConstantGap(-1, -1, 0)) }
  }

  "Smith Waterman score" should "only accept a mismatch value < 0" in {
    assertThrows[IllegalArgumentException] {
      SmithWaterman.score("abc", "abc", ConstantGap(1, 1, 0)) }
  }

  "Smith Waterman score" should "only accept a gap value <= 0" in {
    assertThrows[IllegalArgumentException] {
      SmithWaterman.score("abc", "abc", ConstantGap(1, -1, 1)) }
  }

  "Smith Waterman score" should "only accept a window size > 0" in {
    assertThrows[IllegalArgumentException] {
      SmithWaterman.score("abc", "abc", (ConstantGap(1, -1, 0), -1)) }
  }

  "Smith Waterman Gotoh score" should "only accept a match value > 0" in {
    assertThrows[IllegalArgumentException] {
      SmithWatermanGotoh.score("abc", "abc", ConstantGap(-1, -1, 0)) }
  }

  "Smith Waterman Gotoh score" should "only accept a mismatch value < 0" in {
    assertThrows[IllegalArgumentException] {
      SmithWatermanGotoh.score("abc", "abc", ConstantGap(1, 1, 0)) }
  }

  "Smith Waterman Gotoh score" should "only accept a gap value <= 0" in {
    assertThrows[IllegalArgumentException] {
      SmithWatermanGotoh.score("abc", "abc", ConstantGap(1, -1, 1)) }
  }
}
