package com.github.vickumar1981.stringdistance.util;

import com.github.vickumar1981.stringdistance.impl.ConstantGap;
import com.github.vickumar1981.stringdistance.impl.Gap;
import com.github.vickumar1981.stringdistance.impl.LinearGap;

import java.util.List;


public class ArrayDistance {
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

    private static <T> Double scoreFromDistance(T[] s1, T[] s2, Integer distance) {
        int maxLen = Math.max(s1.length, s2.length);
        int minLen = maxLen - distance;
        if (minLen < 0 || minLen > maxLen) {
            minLen = 0;
        }
        return minLen * 1.0 / maxLen;
    }
    
    public static <T> Double cosine(T[] s1, T[] s2) {
        return cosine.cosSimilarity(s1, s2);
    }

    public static <T> Double damerau(T[] s1, T[] s2) {
        return scoreFromDistance(s1, s2, damerauDist(s1, s2));
    }

    public static <T> Integer damerauDist(T[] s1, T[] s2) {
        return levenshtein.damerauLevenshtein(s1, s2);
    }

    public static <T> Double diceCoefficient(T[] s1, T[] s2) {
        return dice.diceCoefficient(s1, s2);
    }

    public static <T> Double hamming(T[] s1, T[] s2) {
        return scoreFromDistance(s1, s2, hammingDist(s1, s2));
    }

    public static <T> Integer hammingDist(T[] s1, T[] s2) {
        return hamming.hamming(s1, s2);
    }

    public static <T> Double jaccard(T[] s1, T[] s2) { return jaccard(s1, s2, 1); }

    public static <T> Double jaccard(T[] s1, T[] s2, Integer n) {
        return jaccard.jaccard(s1, s2, n);
    }

    public static <T> Double jaroWinkler(T[] s1, T[] s2) {
        return jaroWinkler(s1, s2, 0.1);
    }

    public static <T> Double jaroWinkler(T[] s1, T[] s2, Double weight) {
        return jaro.jaroWinkler(s1, s2, weight);
    }

    public static <T> Double jaro(T[] s1, T[] s2) {
        return jaro.jaro(s1, s2);
    }

    public static <T> Double levenshtein(T[] s1, T[] s2) {
        return scoreFromDistance(s1, s2, levenshteinDist(s1, s2));
    }

    public static <T> Integer levenshteinDist(T[] s1, T[] s2) {
        return levenshtein.levenshtein(s1, s2);
    }

    public static <T> Integer longestCommonSeq(T[] s1, T[] s2) {
        return longestCommonSeq.longestCommonSeq(s1, s2);
    }

    public static <T> Double needlemanWunsch(T[] s1, T[] s2) {
        return needlemanWunsch(s1, s2, new ConstantGap(1d, -1d, 0d));
    }

    public static <T> Double needlemanWunsch(T[] s1, T[] s2, ConstantGap gap) {
            return needlemanWunsch.needleman(s1, s2, gap);
    }

    public static <T> Integer nGramDist(T[] s1, T[] s2) { return nGramDist(s1, s2, 1); }

    public static <T> Integer nGramDist(T[] s1, T[] s2, Integer n) {
        return ngram.nGramDist(s1, s2, n);
    }

    public static <T> Double nGram(T[] s1, T[] s2) { return nGram(s1, s2, 1); }

    public static <T> Double nGram(T[] s1, T[] s2, Integer n) {
        return ngram.nGram(s1, s2, n);
    }

    public static <T> List<List<T>> nGramTokens(T[] s1, Integer n) {
        return ngram.tokensAsJava(s1, n);
    }

    public static <T> Double overlap(T[] s1, T[] s2) { return overlap(s1, s2, 1); }

    public static <T> Double overlap(T[] s1, T[] s2, Integer n) {
        return overLap.overlap(s1, s2, n);
    }

    public static <T> Double smithWaterman(T[] s1, T[] s2) {
        return smithWaterman(s1, s2, new LinearGap(1d, -1d, -1d));
    }

    public static <T> Double smithWaterman(T[] s1, T[] s2, Gap gap) {
        return smithWaterman.smithWaterman(s1, s2, gap, Integer.MAX_VALUE);
    }

    public static <T> Double smithWaterman(T[] s1, T[] s2, Gap gap, Integer windowSize) {
        return smithWaterman.smithWaterman(s1, s2, gap, windowSize);
    }

    public static <T> Double smithWatermanGotoh(T[] s1, T[] s2) {
        return smithWatermanGotoh(s1, s2, new ConstantGap(1d, -1d, -1d));
    }

    public static <T> Double smithWatermanGotoh(T[] s1, T[] s2, ConstantGap gap) {
        return smithWaterman.smithWatermanGotoh(s1, s2, gap);
    }

    public static <T> Double tversky(T[] s1, T[] s2) { return tversky(s1, s2, 1d); }

    public static <T> Double tversky(T[] s1, T[] s2, Double n) {
        return jaccard.tversky(s1, s2, n);
    }
}
