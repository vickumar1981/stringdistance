![Logo](logo.png)

# Contributing to StringDistance  

Thanks for taking the time to contribute!

---
### 1. Initial setup

__Install Java 8:__

[Download Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

__Clone the repository:__

```
git clone https://github.com/vickumar1981/stringdistance.git
```

__Update dependencies:__

```
# From project root directory
./sbt update
```

__Compile the project:__

```
# From project root directory
./sbt compile
```
---

### 2. Pull Requests and Bugs

-  Please submit pull requests against the latest `SNAPSHOT` branch.

-  Please feel free to report any bugs or issues to the [Github issues page](https://github.com/vickumar1981/stringdistance/issues).

---
### 3. Running tests

__Running unit tests:__

```
# From project root directory
./sbt test
```

__Run linter, unit tests, & code coverage:__

```
# From project root directory
./test.sh
```

---
### 4. Testing with a local Java/Scala project

To test local changes against a java project, it is sometimes useful to publish the
artifact locally, and then bring those changes into your `gradle` or `sbt` project. 

__To publish locally:__

```
# From project root directory
./sbt publishLocal
```

---
### 5. Updating the Documentation

To test/view changes to the documentation, simply use `sbt`.

__Generate API documentation:__

```
# From project root directory
./sbt clean doc
```

The `index.html` page of the documentation should be located in your project root
directory, under `target/scala-2.13/api`.