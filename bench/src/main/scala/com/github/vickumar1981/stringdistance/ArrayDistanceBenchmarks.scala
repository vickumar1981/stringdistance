package com.github.vickumar1981.stringdistance

import org.openjdk.jmh.annotations.Benchmark
import ArrayDistanceBenchmarks._

class ArrayDistanceBenchmarks {
  @Benchmark
  def smallDiffCosineTest(): Unit = smallDiffArrTest(ArrayDistance.Cosine)
  @Benchmark
  def smallSameCosineTest(): Unit = smallSameArrTest(ArrayDistance.Cosine)
  @Benchmark
  def largeDiffCosineTest(): Unit = largeDiffArrTest(ArrayDistance.Cosine)
  @Benchmark
  def largeSameCosineTest(): Unit = largeSameArrTest(ArrayDistance.Cosine)

  @Benchmark
  def smallDiffDamerauTest(): Unit = smallDiffArrTest(ArrayDistance.Damerau)
  @Benchmark
  def smallSameDamerauTest(): Unit = smallSameArrTest(ArrayDistance.Damerau)
  @Benchmark
  def largeDiffDamerauTest(): Unit = largeDiffArrTest(ArrayDistance.Damerau)
  @Benchmark
  def largeSameDamerauTest(): Unit = largeSameArrTest(ArrayDistance.Damerau)

  @Benchmark
  def smallDiffDiceCoefficientTest(): Unit = smallDiffArrTest(ArrayDistance.DiceCoefficient)
  @Benchmark
  def smallSameDiceCoefficientTest(): Unit = smallSameArrTest(ArrayDistance.DiceCoefficient)
  @Benchmark
  def largeDiffDiceCoefficientTest(): Unit = largeDiffArrTest(ArrayDistance.DiceCoefficient)
  @Benchmark
  def largeSameDiceCoefficientTest(): Unit = largeSameArrTest(ArrayDistance.DiceCoefficient)

  @Benchmark
  def smallDiffHammingTest(): Unit = smallDiffArrTest(ArrayDistance.Hamming)
  @Benchmark
  def smallSameHammingTest(): Unit = smallSameArrTest(ArrayDistance.Hamming)
  @Benchmark
  def largeDiffHammingTest(): Unit = largeDiffArrTest(ArrayDistance.Hamming)
  @Benchmark
  def largeSameHammingTest(): Unit = largeSameArrTest(ArrayDistance.Hamming)

  @Benchmark
  def smallDiffJaccardTest(): Unit = smallDiffArrTest(ArrayDistance.Jaccard)
  @Benchmark
  def smallSameJaccardTest(): Unit = smallSameArrTest(ArrayDistance.Jaccard)
  @Benchmark
  def largeDiffJaccardTest(): Unit = largeDiffArrTest(ArrayDistance.Jaccard)
  @Benchmark
  def largeSameJaccardTest(): Unit = largeSameArrTest(ArrayDistance.Jaccard)

  @Benchmark
  def smallDiffJaroTest(): Unit = smallDiffArrTest(ArrayDistance.Jaro)
  @Benchmark
  def smallSameJaroTest(): Unit = smallSameArrTest(ArrayDistance.Jaro)
  @Benchmark
  def largeDiffJaroTest(): Unit = largeDiffArrTest(ArrayDistance.Jaro)
  @Benchmark
  def largeSameJaroTest(): Unit = largeSameArrTest(ArrayDistance.Jaro)

  @Benchmark
  def smallDiffJaroWinklerTest(): Unit = smallDiffArrTest(ArrayDistance.JaroWinkler)
  @Benchmark
  def smallSameJaroWinklerTest(): Unit = smallSameArrTest(ArrayDistance.JaroWinkler)
  @Benchmark
  def largeDiffJaroWinklerTest(): Unit = largeDiffArrTest(ArrayDistance.JaroWinkler)
  @Benchmark
  def largeSameJaroWinklerTest(): Unit = largeSameArrTest(ArrayDistance.JaroWinkler)

  @Benchmark
  def smallDiffLevenshteinTest(): Unit = smallDiffArrTest(ArrayDistance.Levenshtein)
  @Benchmark
  def smallSameLevenshteinTest(): Unit = smallSameArrTest(ArrayDistance.Levenshtein)
  @Benchmark
  def largeDiffLevenshteinTest(): Unit = largeDiffArrTest(ArrayDistance.Levenshtein)
  @Benchmark
  def largeSameLevenshteinTest(): Unit = largeSameArrTest(ArrayDistance.Levenshtein)

  @Benchmark
  def smallDiffLongestCommonSeqTest(): Unit = smallDiffArrTest(ArrayDistance.LongestCommonSeq)
  @Benchmark
  def smallSameLongestCommonSeqTest(): Unit = smallSameArrTest(ArrayDistance.LongestCommonSeq)
  /*@Benchmark
  def largeDiffLongestCommonSeqTest(): Unit = largeDiffArrTest(ArrayDistance.LongestCommonSeq)
  @Benchmark
  def largeSameLongestCommonSeqTest(): Unit = largeSameArrTest(ArrayDistance.LongestCommonSeq)*/

  @Benchmark
  def smallDiffNeedlemanWunschTest(): Unit = smallDiffArrTest(ArrayDistance.NeedlemanWunsch)
  @Benchmark
  def smallSameNeedlemanWunschTest(): Unit = smallSameArrTest(ArrayDistance.NeedlemanWunsch)
  @Benchmark
  def largeDiffNeedlemanWunschTest(): Unit = largeDiffArrTest(ArrayDistance.NeedlemanWunsch)
  @Benchmark
  def largeSameNeedlemanWunschTest(): Unit = largeSameArrTest(ArrayDistance.NeedlemanWunsch)

  @Benchmark
  def smallDiffNGramDistTest(): Unit = smallDiffArrTest[ArrayDistance.WeightedDistanceMetric[Int]](ArrayDistance.NGram)
  @Benchmark
  def smallSameNGramDistTest(): Unit = smallSameArrTest[ArrayDistance.WeightedDistanceMetric[Int]](ArrayDistance.NGram)
  @Benchmark
  def largeDiffNGramDistTest(): Unit = largeDiffArrTest[ArrayDistance.WeightedDistanceMetric[Int]](ArrayDistance.NGram)
  @Benchmark
  def largeSameNGramDistTest(): Unit = largeSameArrTest[ArrayDistance.WeightedDistanceMetric[Int]](ArrayDistance.NGram)

  @Benchmark
  def smallDiffNGramScoreTest(): Unit = smallDiffArrTest[ArrayDistance.WeightedScoreMetric[Int]](ArrayDistance.NGram)
  @Benchmark
  def smallSameNGramScoreTest(): Unit = smallSameArrTest[ArrayDistance.WeightedScoreMetric[Int]](ArrayDistance.NGram)
  @Benchmark
  def largeDiffNGramScoreTest(): Unit = largeDiffArrTest[ArrayDistance.WeightedScoreMetric[Int]](ArrayDistance.NGram)
  @Benchmark
  def largeSameNGramScoreTest(): Unit = largeSameArrTest[ArrayDistance.WeightedScoreMetric[Int]](ArrayDistance.NGram)

  @Benchmark
  def smallDiffOverlapTest(): Unit = smallDiffArrTest(ArrayDistance.Overlap)
  @Benchmark
  def smallSameOverlapTest(): Unit = smallSameArrTest(ArrayDistance.Overlap)
  @Benchmark
  def largeDiffOverlapTest(): Unit = largeDiffArrTest(ArrayDistance.Overlap)
  @Benchmark
  def largeSameOverlapTest(): Unit = largeSameArrTest(ArrayDistance.Overlap)
  
  @Benchmark
  def smallDiffSmithWatermanTest(): Unit = smallDiffArrTest(ArrayDistance.SmithWaterman)
  @Benchmark
  def smallSameSmithWatermanTest(): Unit = smallSameArrTest(ArrayDistance.SmithWaterman)
  @Benchmark
  def largeDiffSmithWatermanTest(): Unit = largeDiffArrTest(ArrayDistance.SmithWaterman)
  @Benchmark
  def largeSameSmithWatermanTest(): Unit = largeSameArrTest(ArrayDistance.SmithWaterman)
  
  @Benchmark
  def smallDiffSmithWatermanGotohTest(): Unit = smallDiffArrTest(ArrayDistance.SmithWatermanGotoh)
  @Benchmark
  def smallSameSmithWatermanGotohTest(): Unit = smallSameArrTest(ArrayDistance.SmithWatermanGotoh)
  @Benchmark
  def largeDiffSmithWatermanGotohTest(): Unit = largeDiffArrTest(ArrayDistance.SmithWatermanGotoh)
  @Benchmark
  def largeSameSmithWatermanGotohTest(): Unit = largeSameArrTest(ArrayDistance.SmithWatermanGotoh)
  
  @Benchmark
  def smallDiffTverskyTest(): Unit = smallDiffArrTest(ArrayDistance.Tversky)
  @Benchmark
  def smallSameTverskyTest(): Unit = smallSameArrTest(ArrayDistance.Tversky)
  @Benchmark
  def largeDiffTverskyTest(): Unit = largeDiffArrTest(ArrayDistance.Tversky)
  @Benchmark
  def largeSameTverskyTest(): Unit = largeSameArrTest(ArrayDistance.Tversky)
}

object ArrayDistanceBenchmarks {

  trait Bench[T] {
    def benchmark[U](arr1: Array[U], arr2: Array[U], metric: T): Unit
  }

  object Bench {
    def apply[T](implicit bench: Bench[T]): Bench[T] = bench
  }

  implicit def scoreMetricBenchmarkable[T <: ArrayDistance.ScoreMetric] = new Bench[T] {
    def benchmark[U](arr1: Array[U], arr2: Array[U], metric: T): Unit =
      metric.score(arr1, arr2)
  }

  implicit def distanceMetricBenchmarkable[T <: ArrayDistance.DistanceMetric] = new Bench[T] {
    def benchmark[U](arr1: Array[U], arr2: Array[U], metric: T): Unit =
      metric.distance(arr1, arr2)
  }

  implicit def weightedScoreMetricBenchmarkable[T <: ArrayDistance.WeightedScoreMetric[_]] = new Bench[T] {
    def benchmark[U](arr1: Array[U], arr2: Array[U], metric: T): Unit =
      metric.score(arr1, arr2)
  }

  implicit def weightedDistanceMetricBenchmarkable[T <: ArrayDistance.WeightedDistanceMetric[_]] = new Bench[T] {
    def benchmark[U](arr1: Array[U], arr2: Array[U], metric: T): Unit =
      metric.distance(arr1, arr2)
  }

  implicit def scoreFromDistanceMetricBenchmarkable[T <: ArrayDistance.ScoreFromDistanceMetric] = new Bench[T] {
    def benchmark[U](arr1: Array[U], arr2: Array[U], metric: T): Unit =
      metric.distance(arr1, arr2)
  }

  def smallDiffArrTest[T: Bench](metric: T) = Bench[T].benchmark(
    Array.fill(10)('a'),
    Array.fill(10)('b'),
    metric)
  def smallSameArrTest[T: Bench](metric: T) = Bench[T].benchmark(
    Array.fill(10)('a'),
    Array.fill(10)('a'),
    metric)
  def largeDiffArrTest[T: Bench](metric: T) = Bench[T].benchmark(
    Array.fill(50)('a'),
    Array.fill(50)('b'),
    metric)
  def largeSameArrTest[T: Bench](metric: T) = Bench[T].benchmark(
    Array.fill(50)('a'),
    Array.fill(50)('a'),
    metric)
}
