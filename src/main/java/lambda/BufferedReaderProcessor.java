package lambda;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2019/10/28 10:51 下午
 */
@FunctionalInterface
public interface BufferedReaderProcessor {

    String process(BufferedReader b) throws IOException;
}
