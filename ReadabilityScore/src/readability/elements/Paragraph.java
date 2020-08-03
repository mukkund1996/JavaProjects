package readability.elements;

import java.util.ArrayList;
import java.util.List;

public class Paragraph {
    private String para;
    private List<Sentence> sentences = new ArrayList<>();
    private List<Character> characters = new ArrayList<>();
    private double[] average = new double[2];
    private int[] syllables = new int[2];

    public double[] getAverage() {
        return average;
    }

    public int[] getSyllables() {
        return syllables;
    }

    public int getSentenceCount() {
        return Sentence.getSentenceCount();
    }

    public int getWordCount() {
        return Word.getWordCount();
    }

    public int getCharacterCount() {
        return Character.getCharacterCount();
    }

    public void setSyllables() {
        this.syllables = new int[]{Word.getVowels(), Word.getPolysyllable()};
    }

    public void setPara(String para) {
        this.para = para;
        String[] sentences = para.split("[.?!]");
        for (String single : sentences) {
            Sentence sentenceObj = new Sentence();
            sentenceObj.setSentence(single);
            this.sentences.add(sentenceObj);
            Sentence.incrementSentenceCount();
        }

        String[] characters = para.split("");
        for (String singleChar : characters) {
            if (singleChar.matches("[^\n ]"))
                Character.incrementLetterCount();
        }
        computeAvg();
        setSyllables();
    }

    private void computeAvg() {
        double sumLetter = 0;
        double sumWord = 0;
        for (Sentence singleSent : sentences) {
            sumLetter += singleSent.getLetterAvg();
            sumWord += singleSent.getWordCount();
        }
        average[0] = (sumLetter / sentences.size()) * 100;
        average[1] = (sumWord / sentences.size()) * 100;
    }

    public void displayCounts() {
        System.out.println("Words: " + Word.getWordCount());
        System.out.println("Sentences: " + Sentence.getSentenceCount());
        System.out.println("Characters: " + Character.getCharacterCount());
        System.out.println("Syllables: " + syllables[0]);
        System.out.println("Polysyllables: " + syllables[1]);
    }

}
