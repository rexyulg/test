package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2019/11/25 3:37 下午
 */
public class Iterator {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "rexyu", "hello", "Hello", "wangwu");
        List<String> collect = words.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println(collect);
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> first = someNumbers.stream().filter(x -> x * x % 3 == 0).findFirst();
        first.ifPresent(System.out::println);
        System.out.println("=================");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer sum = numbers.stream().reduce(3, Integer::sum);
        System.out.println(sum);
    }
}
