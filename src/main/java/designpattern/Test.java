package main.java.designpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2020/12/24 下午2:01
 */
public class Test {

    public static void main(String[] args) {
        List<Long> test = new ArrayList<>();
        test.add(456L);
        test.add(123L);
        test.add(789L);
        System.out.println(test);
        System.out.println(test);

    }
}
