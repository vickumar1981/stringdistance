package com.github.vickumar1981.stringdistance.util;

import com.github.vickumar1981.stringdistance.impl.ConstantGap;
import com.github.vickumar1981.stringdistance.impl.Gap;
import com.github.vickumar1981.stringdistance.impl.LinearGap;

public class StringDistance {
    private final static CosSimilarityImpl cosine = new CosSimilarityImpl();
    private final static JaccardImpl jaccard = new JaccardImpl();
    private final static JaroImpl jaro = new JaroImpl();
    private final static HammingImpl hamming = new HammingImpl();
    private final static DiceCoefficientImpl dice = new DiceCoefficientImpl();
    private final static LevenshteinDistanceImpl levenshtein = new LevenshteinDistanceImpl();
    private final static LongestCommonSeqImpl longestCommonSeq = new LongestCommonSeqImpl();
    private final static NeedlemanWunschImpl needlemanWunsch = new NeedlemanWunschImpl();
    private final static NGramImpl ngram = new NGramImpl();
    private final static OverlapImpl overLap = new OverlapImpl();
    private final static SmithWatermanImpl smithWaterman = new SmithWatermanImpl();

    private final static String splitOnWord = "(?!^)";
    private final static String splitOnSentence = "\\W+";

    private static Double scoreFromDistance(String s1, String s2, Integer distance) {
        int maxLen = Math.max(s1.length(), s2.length());
        int minLen = maxLen - distance;
        if (minLen < 0 || minLen > maxLen) {
            minLen = 0;
        }
        return minLen * 1.0 / maxLen;
    }

    public static Double cosine(String s1, String s2) {
        return cosine(s1, s2, splitOnWord);
    }

    public static Double cosine(String s1, String s2, String splitOn) {
        return cosine.cosSimilarity(s1, s2, splitOn);
    }

    public static Double damerau(String s1, String s2) {
        return scoreFromDistance(s1, s2, damerauDist(s1, s2));
    }

    public static Integer damerauDist(String s1, String s2) {
        return levenshtein.damerauLevenshtein(s1, s2);
    }

    public static Double diceCoefficient(String s1, String s2) {
        return dice.diceCoefficient(s1, s2);
    }

    public static Double hamming(String s1, String s2) {
        return scoreFromDistance(s1, s2, hammingDist(s1, s2));
    }

    public static Integer hammingDist(String s1, String s2) {
        return hamming.hamming(s1, s2);
    }

    public static Double jaccard(String s1, String s2) { return jaccard(s1, s2, 1); }

    public static Double jaccard(String s1, String s2, Integer n) { return jaccard.jaccard(s1, s2, n); }

    public static Double jaroWinkler(String s1, String s2) {
        return jaroWinkler(s1, s2, 0.1);
    }

    public static Double jaroWinkler(String s1, String s2, Double weight) {
        return jaro.jaroWinkler(s1, s2, weight);
    }

    public static Double jaro(String s1, String s2) {
        return jaro.jaro(s1, s2);
    }

    public static Double levenshtein(String s1, String s2) {
        return scoreFromDistance(s1, s2, levenshteinDist(s1, s2));
    }

    public static Integer levenshteinDist(String s1, String s2) {
        return levenshtein.levenshtein(s1, s2);
    }

    public static Integer longestCommonSeq(String s1, String s2) {
        return longestCommonSeq.longestCommonSeq(s1, s2);
    }

    public static Double needlemanWunsch(String s1, String s2) {
        return needlemanWunsch(s1, s2, new ConstantGap(1d, -1d, 0d));
    }

    public static Double needlemanWunsch(String s1, String s2, ConstantGap gap) {
            return needlemanWunsch.needleman(s1, s2, gap);
    }

    public static Integer nGramDist(String s1, String s2) { return nGramDist(s1, s2, 1); }

    public static Integer nGramDist(String s1, String s2, Integer n) { return ngram.nGramDist(s1, s2, n); }

    public static Double nGram(String s1, String s2) { return nGram(s1, s2, 1); }

    public static Double nGram(String s1, String s2, Integer n) { return ngram.nGram(s1, s2, n); }

    public static Double overlap(String s1, String s2) { return overlap(s1, s2, 1); }

    public static Double overlap(String s1, String s2, Integer n) { return overLap.overlap(s1, s2, n); }

    public static Double smithWaterman(String s1, String s2) {
        return smithWaterman(s1, s2, new LinearGap(1d, -1d, -1d));
    }

    public static Double smithWaterman(String s1, String s2, Gap gap) {
        return smithWaterman.smithWaterman(s1, s2, gap, Integer.MAX_VALUE);
    }

    public static Double smithWaterman(String s1, String s2, Gap gap, Integer windowSize) {
        return smithWaterman.smithWaterman(s1, s2, gap, windowSize);
    }

    public static Double smithWatermanGotoh(String s1, String s2) {
        return smithWatermanGotoh(s1, s2, new ConstantGap(1d, -1d, -1d));
    }

    public static Double smithWatermanGotoh(String s1, String s2, ConstantGap gap) {
        return smithWaterman.smithWatermanGotoh(s1, s2, gap);
    }

    public static Double tversky(String s1, String s2) { return tversky(s1, s2, 1d); }

    public static Double tversky(String s1, String s2, Double n) { return jaccard.tversky(s1, s2, n); }
}
