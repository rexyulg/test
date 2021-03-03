package lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2019/10/28 10:53 下午
 */
public class BufferedReaderProcessorTest {

    public static String processFile(BufferedReaderProcessor processor) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/dzj/workspace/learning/java/test/src/main/java/Apple.java"))){
            return processor.process(br);
        }
    }

    public static void main(String[] args) throws IOException {
        String oneLine = processFile((BufferedReader br) -> br.readLine());
        System.out.println(oneLine);
        String threeLines = processFile((BufferedReader br) -> br.readLine() + br.readLine() + br.readLine());
        System.out.println(threeLines);
    }
}
