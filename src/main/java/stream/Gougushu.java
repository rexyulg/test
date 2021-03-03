package main.java.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2019/12/1 1:52 下午
 */
public class Gougushu {
    public static void main(String[] args) {
        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed().flatMap(a ->
                IntStream.rangeClosed(a, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
        pythagoreanTriples.limit(5).forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }
}
