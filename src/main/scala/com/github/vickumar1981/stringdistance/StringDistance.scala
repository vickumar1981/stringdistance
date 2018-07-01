package com.github.vickumar1981.stringdistance

import com.github.vickumar1981.stringdistance.algo._

object StringDistance extends JaroDistance with NGram
  with LevenshteinDistance with DiceCoefficient with Hamming

class JaroDistanceWrapper extends JaroDistance
class LevenshteinDistanceWrapper extends LevenshteinDistance
class DiceCoefficientWrapper extends DiceCoefficient
class HammingWrapper extends Hamming
class NGramWrapper extends NGram