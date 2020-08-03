package readability.elements;

public enum AgeGroups {
    KINDER(1, "6"),
    FIRST(2, "7"),
    THIRD(3, "9"),
    FOURTH(4, "10"),
    FIFTH(5, "11"),
    SIXTH(6, "12"),
    SEVENTH(7, "13"),
    EIGHTH(8, "14"),
    NINTH(9, "15"),
    TENTH(10, "16"),
    ELEVENTH(11, "17"),
    TWELFTH(12, "18"),
    COLLEGE(13, "24"),
    PROFESSOR(14, "24+");

    private final int value1;
    private final String value2;

    private AgeGroups(final int n, final String s) {
        this.value1 = n;
        this.value2 = s;

    }

    public int getScore() {
        return this.value1;
    }

    public String getAge() {
        return this.value2;
    }
}
