package readability.ScoreIndex;

public class FKRScore implements ScoreType {
    @Override
    public double computeScore(int words, int sentences, int letters, int[] syllables, double[] avg) {
        return ((0.39 * words / sentences) + (11.8 * syllables[0] / words) - 15.59);
    }
}
