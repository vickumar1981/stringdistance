package com.github.vickumar1981.stringdistance.util;

public class StringSound {
    private final static MetaphoneImpl metaphone = new MetaphoneImpl();

    public static Boolean metaphone(String s1, String s2) {
        return metaphone.metaphone(s1, s2);
    }
}
