package com.github.vickumar1981.stringdistance

import org.openjdk.jmh.annotations.Benchmark
import ArrayDistanceBenchmarks._

class ArrayDistanceBenchmarks {
  @Benchmark
  def emptyCosineTest(): Unit = emptyArrTest(ArrayDistance.Cosine)
  @Benchmark
  def smallDiffCosineTest(): Unit = smallDiffArrTest(ArrayDistance.Cosine)
  @Benchmark
  def smallSameCosineTest(): Unit = smallSameArrTest(ArrayDistance.Cosine)
  @Benchmark
  def largeDiffCosineTest(): Unit = largeDiffArrTest(ArrayDistance.Cosine)
  @Benchmark
  def largeSameCosineTest(): Unit = largeSameArrTest(ArrayDistance.Cosine)

  // Missing: Damerau

  @Benchmark
  def emptyDiceCoefficientTest(): Unit = emptyArrTest(ArrayDistance.DiceCoefficient)
  @Benchmark
  def smallDiffDiceCoefficientTest(): Unit = smallDiffArrTest(ArrayDistance.DiceCoefficient)
  @Benchmark
  def smallSameDiceCoefficientTest(): Unit = smallSameArrTest(ArrayDistance.DiceCoefficient)
  @Benchmark
  def largeDiffDiceCoefficientTest(): Unit = largeDiffArrTest(ArrayDistance.DiceCoefficient)
  @Benchmark
  def largeSameDiceCoefficientTest(): Unit = largeSameArrTest(ArrayDistance.DiceCoefficient)

  // Missing: Hamming

  // Missing: Jaccard

  @Benchmark
  def emptyJaroTest(): Unit = emptyArrTest(ArrayDistance.Jaro)
  @Benchmark
  def smallDiffJaroTest(): Unit = smallDiffArrTest(ArrayDistance.Jaro)
  @Benchmark
  def smallSameJaroTest(): Unit = smallSameArrTest(ArrayDistance.Jaro)
  @Benchmark
  def largeDiffJaroTest(): Unit = largeDiffArrTest(ArrayDistance.Jaro)
  @Benchmark
  def largeSameJaroTest(): Unit = largeSameArrTest(ArrayDistance.Jaro)

  @Benchmark
  def emptyLongestCommonSeqTest(): Unit = emptyArrTest(ArrayDistance.LongestCommonSeq)
  @Benchmark
  def smallDiffLongestCommonSeqTest(): Unit = smallDiffArrTest(ArrayDistance.LongestCommonSeq)
  @Benchmark
  def smallSameLongestCommonSeqTest(): Unit = smallSameArrTest(ArrayDistance.LongestCommonSeq)
  /*@Benchmark
  def largeDiffLongestCommonSeqTest(): Unit = largeDiffArrTest(ArrayDistance.LongestCommonSeq)
  @Benchmark
  def largeSameLongestCommonSeqTest(): Unit = largeSameArrTest(ArrayDistance.LongestCommonSeq)*/

  // Missing: NeedlemanWunsch

  // Missing: NGram
  
  // Missing: Overlap
  
  // Missing: SmithWaterman
  
  // Missing: SmithWatermanGotoh
  
  // Missing: Tversy
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

  def emptyArrTest[T: Bench](metric: T) =
    Bench[T].benchmark(Array.empty[Int], Array.empty[Int], metric)
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
