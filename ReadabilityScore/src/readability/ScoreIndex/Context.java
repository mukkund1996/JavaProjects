package readability.ScoreIndex;

import readability.elements.AgeGroups;
import readability.elements.Paragraph;

public class Context {
    private ScoreType scoreType;
    private Paragraph para;
    private double score;
    private String age;

    public double getScore() {
        return score;
    }

    public String getAge() {
        return age;
    }

    public Context(ScoreType scoreType, Paragraph para) {
        this.scoreType = scoreType;
        this.para = para;
        this.setScore();
        this.setAge();
    }

    public void setScore() {
        int words = para.getWordCount();
        int sentences = para.getSentenceCount();
        int letters = para.getCharacterCount();
        double[] avg = para.getAverage();
        int[] syllable = para.getSyllables();
        score = scoreType.computeScore(words, sentences, letters, syllable, avg);
    }

    public void setAge() {
        int score = (int) Math.round(this.score);
        AgeGroups[] ageGroup = AgeGroups.values();

        for (AgeGroups age : ageGroup) {
            if (score == age.getScore())
                this.age = age.getAge();
        }
    }
}
