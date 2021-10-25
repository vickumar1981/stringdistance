package com.github.vickumar1981.stringdistance

import org.openjdk.jmh.annotations.{Benchmark, Scope, State, Param}

@State(Scope.Benchmark)
class ArrayDistanceBenchmarks {

  val smallArr1: Array[Char] = Array.fill(10)('a')
  val smallArr2: Array[Char] = Array.fill(10)('b')
  val largeArr1: Array[Char] = Array.fill(50)('a')
  val largeArr2: Array[Char] = Array.fill(50)('b')

  @Param(Array(
    "ArrayDistance.Cosine",
    "ArrayDistance.Damerau",
    "ArrayDistance.DiceCoefficient",
    "ArrayDistance.Hamming",
    "ArrayDistance.Jaccard",
    "ArrayDistance.Jaro",
    "ArrayDistance.JaroWinkler",
    "ArrayDistance.Levenshtein",
    "ArrayDistance.LongestCommonSeq",
    "ArrayDistance.NeedlemanWunsch",
    "ArrayDistance.NGram.score",
    "ArrayDistance.NGram.distance",
    "ArrayDistance.Overlap",
    "ArrayDistance.SmithWaterman",
    "ArrayDistance.SmithWatermanGotoh",
    "ArrayDistance.Tversky",
  ))
  var testFunName: String = _

  def testFun: (Array[Char], Array[Char]) => Any = testFunName match {
    case "ArrayDistance.Cosine" => ArrayDistance.Cosine.score[Char]
    case "ArrayDistance.Damerau" => ArrayDistance.Damerau.distance[Char]
    case "ArrayDistance.DiceCoefficient" => ArrayDistance.DiceCoefficient.score[Char]
    case "ArrayDistance.Hamming" => ArrayDistance.Hamming.distance[Char]
    case "ArrayDistance.Jaccard" => ArrayDistance.Jaccard.score[Char]
    case "ArrayDistance.Jaro" => ArrayDistance.Jaro.score[Char]
    case "ArrayDistance.JaroWinkler" => ArrayDistance.JaroWinkler.score[Char]
    case "ArrayDistance.Levenshtein" => ArrayDistance.Levenshtein.distance[Char]
    case "ArrayDistance.LongestCommonSeq" => ArrayDistance.LongestCommonSeq.distance[Char]
    case "ArrayDistance.NeedlemanWunsch" => ArrayDistance.NeedlemanWunsch.score[Char]
    case "ArrayDistance.NGram.score" => ArrayDistance.NGram.score[Char]
    case "ArrayDistance.NGram.distance" => ArrayDistance.NGram.distance[Char]
    case "ArrayDistance.Overlap" => ArrayDistance.Overlap.score[Char]
    case "ArrayDistance.SmithWaterman" => ArrayDistance.SmithWaterman.score[Char]
    case "ArrayDistance.SmithWatermanGotoh" => ArrayDistance.SmithWatermanGotoh.score[Char]
    case "ArrayDistance.Tversky" => ArrayDistance.Tversky.score[Char]
  }

  @Benchmark
  def smallDiffArrTest(): Unit =
    testFun(smallArr1, smallArr2)
  @Benchmark
  def smallSameArrTest(): Unit =
    testFun(smallArr1, smallArr1)
  @Benchmark
  def largeDiffArrTest(): Unit =
    testFun(largeArr1, largeArr2)
  @Benchmark
  def largeSameArrTest(): Unit =
    testFun(largeArr1, largeArr1)
}
