package me.kazury.portableenka.util;

public class RawRating {
    private final double sum;
    private final double maxPoints;
    private final double percentage;

    public RawRating(final double sum, final double maxPoints, final double percentage) {
        this.sum = sum;
        this.maxPoints = maxPoints;
        this.percentage = percentage;
    }

    public double getSum() {
        return this.sum;
    }

    public double getMaxPoints() {
        return this.maxPoints;
    }

    public double getPercentage() {
        return this.percentage;
    }
}
