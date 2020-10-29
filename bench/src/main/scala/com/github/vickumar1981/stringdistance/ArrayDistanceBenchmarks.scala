package com.github.vickumar1981.stringdistance

import org.openjdk.jmh.annotations.Benchmark
import ArrayDistanceBenchmarks._

class ArrayDistanceBenchmarks {
  @Benchmark
  def emptyCosineTest(): Unit = emptyArrScoreTest(ArrayDistance.Cosine)
  @Benchmark
  def smallDiffCosineTest(): Unit = smallDiffArrScoreTest(ArrayDistance.Cosine)
  @Benchmark
  def smallSameCosineTest(): Unit = smallSameArrScoreTest(ArrayDistance.Cosine)
  @Benchmark
  def largeDiffCosineTest(): Unit = largeDiffArrScoreTest(ArrayDistance.Cosine)
  @Benchmark
  def largeSameCosineTest(): Unit = largeSameArrScoreTest(ArrayDistance.Cosine)

  // Missing: Damerau

  @Benchmark
  def emptyDiceCoefficientTest(): Unit = emptyArrScoreTest(ArrayDistance.DiceCoefficient)
  @Benchmark
  def smallDiffDiceCoefficientTest(): Unit = smallDiffArrScoreTest(ArrayDistance.DiceCoefficient)
  @Benchmark
  def smallSameDiceCoefficientTest(): Unit = smallSameArrScoreTest(ArrayDistance.DiceCoefficient)
  @Benchmark
  def largeDiffDiceCoefficientTest(): Unit = largeDiffArrScoreTest(ArrayDistance.DiceCoefficient)
  @Benchmark
  def largeSameDiceCoefficientTest(): Unit = largeSameArrScoreTest(ArrayDistance.DiceCoefficient)

  // Missing: Hamming

  // Missing: Jaccard

  @Benchmark
  def emptyJaroTest(): Unit = emptyArrScoreTest(ArrayDistance.Jaro)
  @Benchmark
  def smallDiffJaroTest(): Unit = smallDiffArrScoreTest(ArrayDistance.Jaro)
  @Benchmark
  def smallSameJaroTest(): Unit = smallSameArrScoreTest(ArrayDistance.Jaro)
  @Benchmark
  def largeDiffJaroTest(): Unit = largeDiffArrScoreTest(ArrayDistance.Jaro)
  @Benchmark
  def largeSameJaroTest(): Unit = largeSameArrScoreTest(ArrayDistance.Jaro)

  @Benchmark
  def emptyLongestCommonSeqTest(): Unit = emptyArrDistanceTest(ArrayDistance.LongestCommonSeq)
  @Benchmark
  def smallDiffLongestCommonSeqTest(): Unit = smallDiffArrDistanceTest(ArrayDistance.LongestCommonSeq)
  @Benchmark
  def smallSameLongestCommonSeqTest(): Unit = smallSameArrDistanceTest(ArrayDistance.LongestCommonSeq)
  /*@Benchmark
  def largeDiffLongestCommonSeqTest(): Unit = largeDiffArrDistanceTest(ArrayDistance.LongestCommonSeq)
  @Benchmark
  def largeSameLongestCommonSeqTest(): Unit = largeSameArrDistanceTest(ArrayDistance.LongestCommonSeq)*/

  // Missing: NeedlemanWunsch

  // Missing: NGram
  
  // Missing: Overlap
  
  // Missing: SmithWaterman
  
  // Missing: SmithWatermanGotoh
  
  // Missing: Tversy
}

object ArrayDistanceBenchmarks {
  def testScoreMetric[T](
    arr1: Array[T],
    arr2: Array[T]
  )(scoreMetric: ArrayDistance.ScoreMetric): Unit =
    scoreMetric.score(arr1, arr2)

  def testDistanceMetric[T](
    arr1: Array[T],
    arr2: Array[T]
  )(distanceMetric: ArrayDistance.DistanceMetric): Unit =
    distanceMetric.distance(arr1, arr2)

  val emptyArrScoreTest = testScoreMetric(Array.empty[Int], Array.empty[Int]) _
  val smallDiffArrScoreTest = testScoreMetric(
    Array.fill(10)('a'),
    Array.fill(10)('b')) _
  val smallSameArrScoreTest = testScoreMetric(
    Array.fill(10)('a'),
    Array.fill(10)('a')) _
  val largeDiffArrScoreTest = testScoreMetric(
    Array.fill(50)('a'),
    Array.fill(50)('b')) _
  val largeSameArrScoreTest = testScoreMetric(
    Array.fill(50)('a'),
    Array.fill(50)('a')) _

  val emptyArrDistanceTest = testDistanceMetric(Array.empty[Int], Array.empty[Int]) _
  val smallDiffArrDistanceTest = testDistanceMetric(
    Array.fill(10)('a'),
    Array.fill(10)('b')) _
  val smallSameArrDistanceTest = testDistanceMetric(
    Array.fill(10)('a'),
    Array.fill(10)('a')) _
  val largeDiffArrDistanceTest = testDistanceMetric(
    Array.fill(50)('a'),
    Array.fill(50)('b')) _
  val largeSameArrDistanceTest = testDistanceMetric(
    Array.fill(50)('a'),
    Array.fill(50)('a')) _
}
