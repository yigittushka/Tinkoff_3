package Lesson2.StatsAccumulator;

import static com.sun.tools.javac.util.Context.checkState;
import static java.lang.Float.NaN;
import static java.lang.Float.isFinite;

public class StatsAccumulatorimpl  implements  StatsAccumulator{

    public static void main(String[] args) {
        StatsAccumulatorimpl statsAccumulator = new StatsAccumulatorimpl();
        statsAccumulator.add(12);
        statsAccumulator.add(3);
        statsAccumulator.add(1);
        statsAccumulator.add(10);
        statsAccumulator.getMin();
        System.out.println(statsAccumulator);
    }

    private int value;
    int count;
    int min;
    int max;
    double mean;

    double sumOfSquaresOfDeltas;
    @Override
    public void add(int value) {

        if (count == 0) {
            count = 1;
            mean = value;
            min = value;
            max = value;
            if (!isFinite(value)) {
                sumOfSquaresOfDeltas = NaN;
            }
        } else {
            count++;
            if (isFinite(value) && isFinite((float) mean)) {

                double delta = value - mean;
                mean += delta / count;
                sumOfSquaresOfDeltas += delta * (value - mean);
            } else {
                mean = calculateNewMeanNonFinite(mean, value);
                sumOfSquaresOfDeltas = NaN;
            }
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
    }

    @Override
    public int getMin() {

        checkState(count != 0);
        return min;
    }

    @Override
    public int getMax() {
        checkState(count != 0);
        return max;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Double getAvg() {
        checkState(count != 0);
        return mean;
    }

    @Override
    public String toString() {
        return "" + this.value;
    }
}
