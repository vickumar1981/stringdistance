package org.stringdistance.util;

import org.stringdistance.StringDistance$;

public class StringDistance {
    private static StringDistance$ stringDistance = StringDistance$.MODULE$;

    public static Double jaroWinkler(String s1, String s2) {
        return stringDistance.jaroWinkler(s1, s2, 0.1);
    }

    public static Double jaroWinkler(String s1, String s2, Double weight) {
        return stringDistance.jaroWinkler(s1, s2, weight);
    }

    public static Double jaro(String s1, String s2) {
        return stringDistance.jaro(s1, s2);
    }

    public static Double diceCoefficient(String s1, String s2) {
        return stringDistance.diceCoefficient(s1, s2, 0.1);
    }

    public static Double diceCoefficient(String s1, String s2, Double weight) {
        return stringDistance.diceCoefficient(s1, s2, weight);
    }

    public static Integer hamming(String s1, String s2) {
        return stringDistance.hamming(s1, s2);
    }

    public static Integer levenshtein(String s1, String s2) {
        return stringDistance.levenschtein(s1, s2);
    }
}
