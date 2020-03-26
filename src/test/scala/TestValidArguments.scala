import com.github.vickumar1981.stringdistance.StringDistance._
import org.scalatest.flatspec.AnyFlatSpec

class TestValidArguments extends AnyFlatSpec {
  "All distances" should "be greater than zero for non-like strings" in {
    assert(Damerau.distance("martha", "marhta") > 0)
    assert(Hamming.distance("martha", "marhta") > 0)
    assert(Levenshtein.distance("martha", "marhta") > 0)
    assert(LongestCommonSeq.distance("martha", "marhta") > 0)
    assert(NGram.distance("karolin", "kathrin") > 0)
    assert(NGram.distance("karolin", "kathrin", 2) > 0)
  }

  "All distances" should "be 0 for two empty strings" in {
    assert(Damerau.distance("", "") == 0)
    assert(Hamming.distance("", "") == 0)
    assert(Levenshtein.distance("", "") == 0)
    assert(LongestCommonSeq.distance("", "") == 0)
    assert(NGram.distance("", "") == 0)
    assert(NGram.distance("", "", 2) == 0)
  }

  "All scores" should "be less than one for non-like strings" in {
    assert(Cosine.score("hello", "chello") < 1)
    assert(Damerau.score("martha", "marhta") < 1)
    assert(DiceCoefficient.score("martha", "marhta") < 1)
    assert(Hamming.score("martha", "marhta") < 1)
    assert(Jaccard.score("karolin", "kathrin") < 1)
    assert(Jaro.score("martha", "marhta") < 1)
    assert(JaroWinkler.score("martha", "marhta") < 1)
    assert(Levenshtein.score("martha", "marhta") < 1)
    assert(NeedlemanWunsch.score("martha", "marhta") < 1)
    assert(NGram.score("karolin", "kathrin") < 1)
    assert(NGram.score("karolin", "kathrin", 2) < 1)
    assert(Overlap.score("karolin", "kathrin") < 1)
    assert(Overlap.score("karolin", "kathrin", 2) < 1)
    assert(SmithWaterman.score("martha", "marhta") < 1)
    assert(SmithWatermanGotoh.score("martha", "marhta") < 1)
    assert(Tversky.score("karolin", "kathrin") < 1)
  }

  "All scores" should "be 1 for two empty strings" in {
    assert(Cosine.score("", "") == 1)
    assert(Damerau.score("", "") == 1)
    assert(DiceCoefficient.score("", "") == 1)
    assert(Hamming.score("", "") == 1)
    assert(Jaccard.score("", "") == 1)
    assert(Jaro.score("", "") == 1)
    assert(JaroWinkler.score("", "") == 1)
    assert(Levenshtein.score("", "") == 1)
    assert(NeedlemanWunsch.score("", "") == 1)
    assert(NGram.score("", "") == 1)
    assert(NGram.score("", "", 2) == 1)
    assert(Overlap.score("", "") == 1)
    assert(Overlap.score("", "", 2) == 1)
    assert(SmithWaterman.score("", "") == 1)
    assert(SmithWatermanGotoh.score("", "") == 1)
    assert(Tversky.score("", "") == 1)
  }

}
