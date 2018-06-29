package org.stringdistance.util;

import org.stringdistance.StringDistance$;
import org.stringdistance.algo.LevenshteinDistance;

public class StringDistance {
    private static JaroDistance jaro = new JaroDistance();
    private static Hamming hamming = new Hamming();
    private static DiceCoefficient dice = new DiceCoefficient();
    private static LevenshteinDistance levenshtein = new LevenschteinDistance();


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
        return levenshtein.levenschtein(s1, s2);
    }
}
