package com.github.vickumar1981.stringdistance.impl

trait CosSimilarityImpl[T] {
  private def termFrequencyMap(terms: Array[Array[T]]): Map[Array[T], Int] = {
    val retMap = scala.collection.mutable.Map[Array[T], Int]()
    terms.foreach {
      t => {
        val n = retMap.getOrElse(t, 0)
        retMap += ((t, n + 1))
      }
    }
    retMap.toMap
  }

  protected def cosSimilarity(s1: Array[T], s2: Array[T]): Double = {
    val s1TermFreqs = termFrequencyMap(s1.map(e => Array(e)))
    val s2TermFreqs = termFrequencyMap(s2.map(e => Array(e)))
    val intersection = (s1TermFreqs.keySet intersect s2TermFreqs.keySet).toList
    val dotProduct = intersection.map { i => s1TermFreqs(i) * s2TermFreqs(i)}.sum
    val magnitudeS1 = s1TermFreqs.values.map { i => i * i }.sum
    val magnitudeS2 = s2TermFreqs.values.map { i => i * i }.sum
    dotProduct/ math.sqrt(magnitudeS1 * magnitudeS2)
  }
}
