package readability.ScoreIndex;

public class CLIScore implements ScoreType {
    @Override
    public double computeScore(int words, int sentences, int letters, int[] syllables, double[] avg) {
        return (0.0588 * avg[0] - 0.296 * avg[1] - 15.8);
    }
}
