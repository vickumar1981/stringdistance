package com.github.vickumar1981.stringdistance.impl

import com.github.vickumar1981.stringdistance.Strategy

class CosSimilarityImpl {
  private def termFrequencyMap(terms: Seq[String]): Map[String, Int] = {
    val retMap = scala.collection.mutable.Map[String, Int]()
    terms.foreach {
      t => {
        val n = retMap.getOrElse(t, 0)
        retMap += ((t, n + 1))
      }
    }
    retMap.toMap
  }

  def cosSimilarity(s1: String, s2: String, splitOn: String = Strategy.splitWord): Double = {
    val s1TermFreqs = termFrequencyMap(s1.split(splitOn))
    val s2TermFreqs = termFrequencyMap(s2.split(splitOn))
    val intersection = (s1TermFreqs.keySet intersect s2TermFreqs.keySet).toList
    val dotProduct = intersection.map { i => s1TermFreqs(i) * s2TermFreqs(i)}.sum
    val magnitudeS1 = s1TermFreqs.values.map { i => i * i }.sum
    val magnitudeS2 = s2TermFreqs.values.map { i => i * i }.sum
    dotProduct/ Math.sqrt(magnitudeS1 * magnitudeS2)
  }
}
