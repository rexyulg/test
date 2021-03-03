package stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2019/12/1 2:21 下午
 */
public class StreamCreation {
    public static void main(String[] args) {
        Stream<String> emptyStream = Stream.empty();
        emptyStream.forEach(System.out::println);

        Stream<String> stringStream = Stream.of("Java 8", "Lambdas", "In", "Action");
        stringStream.map(String::toUpperCase).forEach(System.out::println);

        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get("/Users/dzj/workspace/learning/java/test/src/main/java/stream/Iterator.java"), Charset.defaultCharset())){
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
            System.out.printf(String.valueOf(uniqueWords));
        } catch(IOException e){
            e.printStackTrace();
        }

        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
