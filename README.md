# StringDistance

[![Build Status](https://api.travis-ci.org/vickumar1981/stringdistance.svg?branch=master)](https://travis-ci.org/vickumar1981/stringdistance/builds) [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

A String distance library for Scala and Java that includes Levenshtein distance, Jaro distance, Jaro-Winkler distance, Dice coefficient, and Hamming distance.

### Scala Usage

Example:
```
// Scala example
import org.stringdistance.StringDistance

val jaro = StringDistance.jaro("MARTHA", "MARHTA")
val jaroWinkler = StringDistance.jaroWinkler("MARTHA", "MARHTA")
val hamming = StringDistance.hamming("MARTHA", "MARHTA")
val diceCoefficient = StringDistance.diceCoefficient("MARTHA", "MARHTA")
val diceCoefficientWeighted = StringDistance.diceCoefficient("MARTHA", "MARHTA", 0.2)
val levenshtein = StringDistance.levenshtein("MARTHA", "MARHTA")
```

### Use with Implicits
  -  To use implicits and extend the String class:  `import org.stringdistance.StringConverter._`

Example
```
// Scala example using implicits
import org.stringdistance.StringConverter._

val jaro = "MARTHA".jaro("MARHTA")
val jaroWinkler = "MARTHA".jaroWinkler("MARHTA")
```

### Java Usage
  -  To use in Java:  `import org.stringdistance.util.StringDistance`

Example
```
// Java example
import org.stringdistance.util.StringDistance;

Double jaro = StringDistance.jaro("MARTHA", "MARHTA");
Double jaroWinkler = StringDistance.jaroWinkler("MARTHA", "MARHTA");
Integer hamming = StringDistance.hamming("MARTHA", "MARHTA");
Double diceCoefficient = StringDistance.diceCoefficient("MARTHA", "MARHTA");
Double diceCoefficientWeighted = StringDistance.diceCoefficient("MARTHA", "MARHTA", 0.2);
Integer levenshtein = StringDistance.levenshtein("MARTHA", "MARHTA");
```

