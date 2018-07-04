package com.github.vickumar1981.stringdistance.util;

public class StringSound {
    private final static MetaphoneImpl metaphone = new MetaphoneImpl();
    private final static SoundexImpl soundex = new SoundexImpl();

    public static Boolean metaphone(String s1, String s2) {
        return metaphone.metaphone(s1, s2);
    }

    public static Boolean soundex(String s1, String s2) {
        return soundex.soundex(s1, s2);
    }
}
