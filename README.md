# StringDistance

[![Build Status](https://api.travis-ci.org/vickumar1981/stringdistance.svg?branch=master)](https://travis-ci.org/vickumar1981/stringdistance/builds) [![Coverage](https://s3.amazonaws.com/assets.coveralls.io/badges/coveralls_100.png)](https://coveralls.io/github/vickumar1981/stringdistance) [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

A String distance library for Scala and Java that includes Levenshtein distance, Jaro distance, Jaro-Winkler distance, Dice coefficient, N-Gram similarity, and Hamming distance.

### Scala Usage

Example:
```
// Scala example
import com.github.vickumar1981.stringdistance._

// Dice Coefficient
val diceCoefficient = DiceCoefficient.score("MARTHA", "MARHTA")
val diceCoefficientWeighted = DiceCoefficient.score("MARTHA", "MARHTA", 0.2)

// Jaro and Jaro Winkler
val jaro = Jaro.score("MARTHA", "MARHTA")
val jaroWinkler = JaroWinkler.score("MARTHA", "MARHTA")
val hamming = Hamming.distance("MARTHA", "MARHTA")

val levenshtein = Levenshtein.distance("MARTHA", "MARHTA")
val ngramSimilarity = Ngram.score("karolin", "kathrin")
val bigramSimilarity = Ngram.score("karolin", "kathrin", 2)
```

### Use with Implicits
  -  To use implicits and extend the String class:  `import com.github.vickumar1981.stringdistance.StringConverter._`

Example
```
// Scala example using implicits
import com.github.vickumar1981.stringdistance.StringConverter._

val jaro = "MARTHA".jaro("MARHTA")
val jaroWinkler = "MARTHA".jaroWinkler("MARHTA")
val hamming = "MARTHA".hammingDist("MARHTA")
val diceCoefficient = "MARTHA".diceCoefficient("MARHTA")
val diceCoefficientWeighted = "MARTHA".diceCoefficient("MARHTA", 0.2)
val levenshtein = "MARTHA".levenshteinDist("MARHTA")
val ngramSimilarity = "karolin".ngram("kathrin")
val bigramSimilarity = "karolin".ngram("kathrin", 2)
...

```

### Java Usage
  -  To use in Java:  `import com.github.vickumar1981.stringdistance.util.StringDistance`

Example
```
// Java example
import com.github.vickumar1981.stringdistance.util.StringDistance;

Double jaro = StringDistance.jaro("MARTHA", "MARHTA");
Double jaroWinkler = StringDistance.jaroWinkler("MARTHA", "MARHTA");
Integer hamming = StringDistance.hammingDist("MARTHA", "MARHTA");
Double diceCoefficient = StringDistance.diceCoefficient("MARTHA", "MARHTA");
Double diceCoefficientWeighted = StringDistance.diceCoefficient("MARTHA", "MARHTA", 0.2);
Integer levenshtein = StringDistance.levenshteinDist("MARTHA", "MARHTA");
Double ngramSimilarity = StringDistance.ngram("karolin", "kathrin");
Double bigramSimilarity = StringDistance.ngram("karolin", "kathrin", 2);
```

