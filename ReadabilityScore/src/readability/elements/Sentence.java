package readability.elements;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private static int count = 0;
    private String sentence;
    private int wordCount;
    private List<Word> words = new ArrayList<>();
    private double letterAvg;
    private final String EMPTY_STRING = "";

    public String getSentence() {
        return sentence;
    }

    public double getLetterAvg() {
        return letterAvg;
    }

    public int getWordCount() {
        return wordCount;
    }

    public static int getSentenceCount() {
        return count;
    }

    private void setLetterAvg() {
        double sum = 0;
        for (Word singleWord : words) {
            sum += singleWord.getCount();
        }
        letterAvg = sum / words.size();
    }

    private void setWordCount(){
        wordCount = words.size();
    }

    public static void incrementSentenceCount() {
        count += 1;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
        String[] wordString = this.sentence.split("( |, |; |: |:\n)");
        for (String wordSingle : wordString) {
            if (!wordSingle.equals(EMPTY_STRING)) {
                Word wordObj = new Word();
                wordObj.setWord(wordSingle);
                words.add(wordObj);
                Word.incrementWordCount();
            }
        }
        this.setLetterAvg();
        this.setWordCount();
    }

}

