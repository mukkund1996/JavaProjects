package readability.ScoreIndex;

public class ARIScore implements ScoreType{
    @Override
    public double computeScore(int words, int sentences, int letters, int[] syllables, double[] avg) {
        return ((4.71 * letters / words) + (0.5 * words / sentences) - 21.43);
    }
}
