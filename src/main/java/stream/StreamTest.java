package main.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2019/11/25 3:26 下午
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> stream = title.stream();
        stream.forEach(System.out::println);
        //stream.forEach(System.out::println);
    }
}
