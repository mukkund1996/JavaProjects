package readability.ScoreIndex;

public interface ScoreType {
    public double computeScore(int words, int sentences, int letters, int[] syllables, double[] avg);
}
