package stream;

import java.util.stream.IntStream;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2019/12/23 10:42 下午
 */
public class Prime {

    public boolean isPrime(int candidate) {
        return IntStream.range(2, candidate).noneMatch(i -> candidate % i == 0);
    }

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
