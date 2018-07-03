# StringDistance

[![Build Status](https://api.travis-ci.org/vickumar1981/stringdistance.svg?branch=master)](https://travis-ci.org/vickumar1981/stringdistance/builds) [![Coverage Status](https://coveralls.io/repos/github/vickumar1981/stringdistance/badge.svg?branch=master)](https://coveralls.io/github/vickumar1981/stringdistance?branch=master) [![Read the Docs](https://img.shields.io/readthedocs/pip.svg)](https://vickumar1981.github.io/stringdistance/api/com/github/vickumar1981/stringdistance/index.html) [![Maven metadata URI](https://img.shields.io/maven-metadata/v/http/central.maven.org/maven2/com/github/vickumar1981/stringdistance_2.12/maven-metadata.xml.svg)](https://mvnrepository.com/artifact/com.github.vickumar1981/stringdistance) [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

A String distance library for Scala and Java that includes Levenshtein distance, Jaro distance, Jaro-Winkler distance, Dice coefficient, N-Gram similarity, Cosine similarity, Jaccard similarity, Longest common subsequence, and Hamming distance.

For more detailed information, please refer to the [API Documentation](https://vickumar1981.github.io/stringdistance/api/com/github/vickumar1981/stringdistance/index.html "API Documentation").

---

### Add it to your project ...

__Using sbt:__

In `build.sbt`:
```scala
libraryDependencies += "com.github.vickumar1981" %% "stringdistance" % "1.0.1"
```

__Using gradle:__

In `build.gradle`:
```groovy
dependencies {
    compile 'com.github.vickumar1981:stringdistance_2.12:1.0.1'
}
```

__Using Maven:__

In `pom.xml`:
```xml
<dependency>
    <groupId>com.github.vickumar1981</groupId>
    <artifactId>stringdistance_2.12</artifactId>
    <version>1.0.1</version>
</dependency>
```
---
### Scala Usage

__Example.scala__:
```scala
// Scala example
import com.github.vickumar1981.stringdistance.StringDistance._

// Cosine Similarity
val cosSimilarity: Double = Cosine.score("hello", "chello")

// Dice Coefficient
val diceCoefficient: Double = DiceCoefficient.score("martha", "marhta")
val diceCoefficientWeighted: Double = DiceCoefficient.score("martha", "marhta", 0.2)

// Hamming Distance
val hammingDist: Int = Hamming.distance("martha", "marhta")
val hamming: Double = Hamming.score("martha", "marhta")

// Jaccard Similarity
val jaccard: Double = Jaccard.score("karolin", "kathrin")

// Jaro and Jaro Winkler
val jaro: Double = Jaro.score("martha", "marhta")
val jaroWinkler: Double = JaroWinkler.score("martha", "marhta")

// Levenshtein Distance
val levenshteinDist: Int = Levenshtein.distance("martha", "marhta")
val levenshtein: Double = Levenshtein.score("martha", "marhta")

// Longest Common Subsequence
val longestCommonSubSeq: Int = LongestCommonSeq.distance("martha", "marhta")

// N-Gram Similarity
val ngramSimilarity: Double = NGram.score("karolin", "kathrin")
val bigramSimilarity: Double = NGram.score("karolin", "kathrin", 2)

// Overlap Similarity
val overlap: Double = Overlap.score("karolin", "kathrin")
val overlapBiGram: Double = Overlap.score("karolin", "kathrin", 2)
```
---

### Scala: Use with Implicits
  -  To use implicits and extend the String class:  `import com.github.vickumar1981.stringdistance.StringConverter._`

__Example.scala__
```scala
// Scala example using implicits
import com.github.vickumar1981.stringdistance.StringConverter._

// Scores between two strings
val cosSimilarity: Double = "hello".cosine("chello")
val diceCoefficient: Double = "martha".diceCoefficient("marhta")
val diceCoefficientWeighted: Double = "martha".diceCoefficient("marhta", 0.2)
val hamming: Double = "martha".hamming("marhta")
val jaccard: Double = "karolin".jaccard("kathrin")
val jaro: Double = "martha".jaro("marhta")
val jaroWinkler: Double = "martha".jaroWinkler("marhta")
val levenshtein: Double = "martha".levenshtein("marhta")
val ngramSimilarity: Double = "karolin".nGram("kathrin")
val bigramSimilarity: Double = "karolin".nGram("kathrin", 2)
val overlap: Double = "karolin".overlap("kathrin")
val overlapBiGram: Double "karolin".overlap("kathrin", 2)

// Distances between two strings
val hammingDist: Int = "martha".hammingDist("marhta")
val levenshteinDist: Int = "martha".levenshteinDist("marhta")
val longestCommonSeq: Int = "martha".longestCommonSeq("marhta")
```
---

### Java Usage
  -  To use in Java:  `import com.github.vickumar1981.stringdistance.util.StringDistance`

__Example.java__
```java
// Java example
import com.github.vickumar1981.stringdistance.util.StringDistance;

// Scores between two strings
Double cosSimilarity = StringDistance.cosine("hello", "chello");
Double diceCoefficient = StringDistance.diceCoefficient("martha", "marhta");
Double diceCoefficientWeighted = StringDistance.diceCoefficient("martha", "marhta", 0.2);
Double hamming = StringDistance.hamming("martha", "marhta");
Double jaro = StringDistance.jaro("martha", "marhta");
Double jaroWinkler = StringDistance.jaroWinkler("martha", "marhta");
Double levenshtein = StringDistance.levenshtein("martha", "marhta");
Double ngramSimilarity = StringDistance.nGram("karolin", "kathrin");
Double bigramSimilarity = StringDistance.nGram("karolin", "kathrin", 2);
Double overlap = StringDistance.overlap("karolin", "kathrin");
Double overlapBiGram = StringDistance.overlap("karolin", "kathrin", 2);

// Distances between two strings
Integer hammingDist = StringDistance.hammingDist("martha", "marhta");
Integer levenshteinDist = StringDistance.levenshteinDist("martha", "marhta");
Integer longestCommonSeq = StringDistance.longestCommonSeq("martha", "marhta");
```

