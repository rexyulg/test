package main.java.stream;

import java.util.function.LongUnaryOperator;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2019/12/24 10:40 下午
 */
public class ParallelStreamTest {

    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
    }

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n).reduce(0L, Long::sum);
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n).parallel().reduce(0L, Long::sum);
    }

    public static long measureSumPerf(LongUnaryOperator adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.applyAsLong(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

    static class Accumulator {
        public long total = 0;

        public void add(long value) {
            total += value;
        }
    }

    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }

    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

    public static void main(String[] args) {
//        System.out.println("Iterative sum done in: " + measureSumPerf(ParallelStreamTest::iterativeSum, 20_000_000) + " msecs");
//        System.out.println("sequential sum done in: " + measureSumPerf(ParallelStreamTest::sequentialSum, 20_000_000) + " msecs");
//        System.out.println("ranged sum done in: " + measureSumPerf(ParallelStreamTest::rangedSum, 20_000_000) + " msecs");
//        System.out.println("parallel sum done in: " + measureSumPerf(ParallelStreamTest::parallelSum, 20_000_000) + " msecs");
//        System.out.println("parallelRanged sum done in: " + measureSumPerf(ParallelStreamTest::parallelRangedSum, 20_000_000) + " msecs");
          System.out.println("sideEffect sum done in: " + measureSumPerf(ParallelStreamTest::sideEffectSum, 10_000_000) + " msecs");
          System.out.println("sideEffectParallel sum done in: " + measureSumPerf(ParallelStreamTest::sideEffectParallelSum, 10_000_000) + " msecs");
    }

}
