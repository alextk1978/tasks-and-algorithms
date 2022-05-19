package tasks;

import java.util.stream.LongStream;

/**
 * @author Alexey Tkachenko
 */
public class TestParallelStream {

    public static void main(String[] args) {
        long [] longs = new long[] {100, 1_000, 1_000_000, 10_000_000, 100_000_000};
        long l;
        for (long s : longs) {
            l = System.currentTimeMillis();
            System.out.println((sequentialSum(s)) + " для : " + s + " sequential время: "+ (System.currentTimeMillis() - l));

            l = System.currentTimeMillis();
            System.out.println((parallelSum(s))  + " для : " + s + " parallel время: "+  (System.currentTimeMillis() - l));
            System.out.println();
        }
    }

    public static long sequentialSum(long n) {
        return LongStream.rangeClosed(0L, n)
                .reduce(0L, Long::sum);
    }

    public static long parallelSum(long n) {
        return LongStream.rangeClosed(0L, n)
                .parallel()
                .reduce(0L, Long::sum);

    }
}
