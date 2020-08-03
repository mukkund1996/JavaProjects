package readability.ScoreIndex;

public class SMOGScore implements ScoreType {
    @Override
    public double computeScore(int words, int sentences, int letters, int[] syllables, double[] avg) {
        return (1.043 * Math.sqrt((double) syllables[1] * 30 / sentences) + 3.1291);
    }
}
