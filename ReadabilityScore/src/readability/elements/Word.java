package readability.elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word {
    private static int count = 0;
    private String word;
    private int letterCount;
    private static int vowels = 0;
    private static int polysyllable;


    public static int getWordCount() {
        return count;
    }

    public static int getVowels() {
        return vowels;
    }

    public static int getPolysyllable() {
        return polysyllable;
    }

    public int getCount(){
        return letterCount;
    }

    private void setLetterCount(){
        letterCount = word.length();
    }

    private void countVowels() {
        String pattern = "[aeiouy]+[^$e]";
        int syllable = 0;
        Pattern vowelPattern = Pattern.compile(pattern);
        Matcher vowelMatcher = vowelPattern.matcher(word);
        while (vowelMatcher.find()) {
            syllable++;
        }
        if (syllable == 0) syllable++;
        vowels+=syllable;
        if (syllable > 2) polysyllable++;
    }


    private void setVowels() {
        this.countVowels();
    }

    public void setWord(String word) {
        this.word = word;
        this.setLetterCount();
        this.setVowels();
    }

    public static void incrementWordCount() {
        count += 1;
    }
}
