# StringDistance

[![Build Status](https://api.travis-ci.org/vickumar1981/stringdistance.svg?branch=master)](https://travis-ci.org/vickumar1981/stringdistance/builds) [![Coverage](https://s3.amazonaws.com/assets.coveralls.io/badges/coveralls_100.png)](https://coveralls.io/github/vickumar1981/stringdistance) [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

A String distance library for Scala and Java that includes Levenshtein distance, Jaro distance, Jaro-Winkler distance, Dice coefficient, N-Gram similarity, Cosine similarity, Jaccard similarity, Longest common subsequence, and Hamming distance.

### Adding it to your project using...

__sbt:__

`build.sbt`
```scala
resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
libraryDependencies += "com.github.vickumar1981" %% "stringdistance" % "1.0.0-SNAPSHOT"
```

---

__gradle:__

`build.gradle`
```groovy
apply plugin: 'java'
apply plugin: 'maven'

repositories {
    maven {
        url "https://oss.sonatype.org/content/groups/public"
    }
}

dependencies {
    compile 'com.github.vickumar1981:stringdistance_2.12:1.0.0-SNAPSHOT'
}
```

---

__Maven:__

`settings.xml`
```xml
<repositories>
  <repository>
    <id>sonatypeSnapshots</id>
    <name>Sonatype Snapshots</name>
    <releases>
      <enabled>false</enabled>
    </releases>
    <snapshots>
      <enabled>true</enabled>
    </snapshots>
    <url>https://oss.sonatype.org/content/repositories/snapshots</url>
  </repository>
</repositories>
```
`pom.xml`:
```xml
<dependency>
	<groupId>com.github.vickumar1981</groupId>
	<artifactId>stringdistance_2.12</artifactId>
	<version>1.0.0-SNAPSHOT</version>
</dependency>
```

### Scala Usage

Example:
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
```

### Use with Implicits
  -  To use implicits and extend the String class:  `import com.github.vickumar1981.stringdistance.StringConverter._`

Example
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

// Distances between two strings
val hammingDist: Int = "martha".hammingDist("marhta")
val levenshteinDist: Int = "martha".levenshteinDist("marhta")
val longestCommonSeq: Int = "martha".longestCommonSeq("marhta")
```

### Java Usage
  -  To use in Java:  `import com.github.vickumar1981.stringdistance.util.StringDistance`

Example
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

// Distances between two strings
Integer hammingDist = StringDistance.hammingDist("martha", "marhta");
Integer levenshteinDist = StringDistance.levenshteinDist("martha", "marhta");
Integer longestCommonSeq = StringDistance.longestCommonSeq("martha", "marhta");
```

