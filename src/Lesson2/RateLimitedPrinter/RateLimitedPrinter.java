package Lesson2.RateLimitedPrinter;

import java.io.PrintStream;

public class RateLimitedPrinter {

    private final long interval;
    private final PrintStream out;
    private long lastTime;
    public RateLimitedPrinter(int interval, PrintStream out) {
        if (interval < 0) throw new IllegalArgumentException("interval >= 0");
        this.interval = interval;
        this.out = out;
        lastTime = -1;
    }

    public RateLimitedPrinter(int interval) {
        this(interval, System.out);
    }

    public static void main(String[] args) {
        RateLimitedPrinter rateLimitedPrinter = new RateLimitedPrinter(100);
        for (int i = 0; i < 1_000_000_000; i++) {
            rateLimitedPrinter.print(String.valueOf(i));
        }
        long currentTime = System.currentTimeMillis();

    }

    public void print(String message) {
        if (System.currentTimeMillis() - lastTime <= interval) {
            lastTime = System.currentTimeMillis();
            out.print(message);
        }
    }
}
