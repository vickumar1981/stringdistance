package com.github.vickumar1981.stringdistance.util;

public class StringDistance {
    private static JaroDistance jaro = new JaroDistance();
    private static Hamming hamming = new Hamming();
    private static DiceCoefficient dice = new DiceCoefficient();
    private static LevenshteinDistance levenshtein = new LevenshteinDistance();
    private static NGram ngram = new NGram();


    public static Double jaroWinkler(String s1, String s2) {
        return jaro.jaroWinkler(s1, s2, 0.1);
    }

    public static Double jaroWinkler(String s1, String s2, Double weight) {
        return jaro.jaroWinkler(s1, s2, weight);
    }

    public static Double jaro(String s1, String s2) {
        return jaro.jaro(s1, s2);
    }

    public static Double diceCoefficient(String s1, String s2) {
        return dice.diceCoefficient(s1, s2, 0.1);
    }

    public static Double diceCoefficient(String s1, String s2, Double weight) {
        return dice.diceCoefficient(s1, s2, weight);
    }

    public static Integer hamming(String s1, String s2) {
        return hamming.hamming(s1, s2);
    }

    public static Integer levenshtein(String s1, String s2) {
        return levenshtein.levenshtein(s1, s2);
    }

    public static Double nGram(String s1, String s2) { return ngram.nGram(s1, s2, 1); }

    public static Double nGram(String s1, String s2, Integer n) { return ngram.nGram(s1, s2, n); }
}
