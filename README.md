# StringDistance

[![Build Status](https://api.travis-ci.org/vickumar1981/stringdistance.svg?branch=master)](https://travis-ci.org/vickumar1981/stringdistance/builds) [![Coverage](https://s3.amazonaws.com/assets.coveralls.io/badges/coveralls_100.png)](https://coveralls.io/github/vickumar1981/stringdistance) [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

A String distance library for Scala and Java that includes Levenshtein distance, Jaro distance, Jaro-Winkler distance, Dice coefficient, N-Gram similarity, and Hamming distance.

### Scala Usage

Example:
```
// Scala example
import com.github.vickumar1981.stringdistance.StringDistance._

// Dice Coefficient
val diceCoefficient: Double = DiceCoefficient.score("MARTHA", "MARHTA")
val diceCoefficientWeighted: Double = DiceCoefficient.score("MARTHA", "MARHTA", 0.2)

// Hamming Distance
val hammingDist: Int = Hamming.distance("MARTHA", "MARHTA")
val hamming: Double = Hamming.score("MARTHA", "MARHTA")

// Jaro and Jaro Winkler
val jaro: Double = Jaro.score("MARTHA", "MARHTA")
val jaroWinkler: Double = JaroWinkler.score("MARTHA", "MARHTA")

// Levenshtein Distance
val levenshteinDist: Int = Levenshtein.distance("MARTHA", "MARHTA")
val levenshtein: Double = Levenshtein.score("MARTHA", "MARHTA")

// N-Gram Similarity
val ngramSimilarity: Double = Ngram.score("karolin", "kathrin")
val bigramSimilarity: Double = Ngram.score("karolin", "kathrin", 2)
```

### Use with Implicits
  -  To use implicits and extend the String class:  `import com.github.vickumar1981.stringdistance.StringConverter._`

Example
```
// Scala example using implicits
import com.github.vickumar1981.stringdistance.StringConverter._

// Scores between two strings
val diceCoefficient: Double = "MARTHA".diceCoefficient("MARHTA")
val diceCoefficientWeighted: Double = "MARTHA".diceCoefficient("MARHTA", 0.2)
val hamming: Double = "MARTHA".hamming("MARHTA")
val jaro: Double = "MARTHA".jaro("MARHTA")
val jaroWinkler: Double = "MARTHA".jaroWinkler("MARHTA")
val levenshtein: Double = "MARTHA".levenshtein("MARHTA")
val ngramSimilarity: Double = "karolin".ngram("kathrin")
val bigramSimilarity: Double = "karolin".ngram("kathrin", 2)

// Distances between two strings
val hammingDist: Int = "MARTHA".hammingDist("MARHTA")
val levenshteinDist: Int = "MARTHA".levenshteinDist("MARHTA")

```

### Java Usage
  -  To use in Java:  `import com.github.vickumar1981.stringdistance.util.StringDistance`

Example
```
// Java example
import com.github.vickumar1981.stringdistance.util.StringDistance;

// Scores between two strings
Double diceCoefficient = StringDistance.diceCoefficient("MARTHA", "MARHTA");
Double diceCoefficientWeighted = StringDistance.diceCoefficient("MARTHA", "MARHTA", 0.2);
Double hamming = StringDistance.hamming("MARTHA", "MARHTA");
Double jaro = StringDistance.jaro("MARTHA", "MARHTA");
Double jaroWinkler = StringDistance.jaroWinkler("MARTHA", "MARHTA");
Double levenshtein = StringDistance.levenshtein("MARTHA", "MARHTA");
Double ngramSimilarity = StringDistance.ngram("karolin", "kathrin");
Double bigramSimilarity = StringDistance.ngram("karolin", "kathrin", 2);

// Distances between two strings
Integer hammingDist = StringDistance.hammingDist("MARTHA", "MARHTA");
Integer levenshteinDist = StringDistance.levenshteinDist("MARTHA", "MARHTA");
```

