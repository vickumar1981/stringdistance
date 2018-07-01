package com.github.vickumar1981.stringdistance.util;

public class StringDistance {
    private static JaroImpl jaro = new JaroImpl();
    private static HammingImpl hamming = new HammingImpl();
    private static DiceCoefficientImpl dice = new DiceCoefficientImpl();
    private static LevenshteinDistanceImpl levenshtein = new LevenshteinDistanceImpl();
    private static NGramImpl ngram = new NGramImpl();


    public static Double diceCoefficient(String s1, String s2) {
        return dice.diceCoefficient(s1, s2, 0.1);
    }

    public static Double diceCoefficient(String s1, String s2, Double weight) {
        return dice.diceCoefficient(s1, s2, weight);
    }

    public static Integer hammingDist(String s1, String s2) {
        return hamming.hamming(s1, s2);
    }

    public static Double jaroWinkler(String s1, String s2) {
        return jaro.jaroWinkler(s1, s2, 0.1);
    }

    public static Double jaroWinkler(String s1, String s2, Double weight) {
        return jaro.jaroWinkler(s1, s2, weight);
    }

    public static Double jaro(String s1, String s2) {
        return jaro.jaro(s1, s2);
    }

    public static Integer levenshteinDist(String s1, String s2) {
        return levenshtein.levenshtein(s1, s2);
    }

    public static Double nGram(String s1, String s2) { return ngram.nGram(s1, s2, 1); }

    public static Double nGram(String s1, String s2, Integer n) { return ngram.nGram(s1, s2, n); }
}
