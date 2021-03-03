package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2020/5/28 5:33 下午
 */
public class Test {

    public static void main(String[] args) {
        String s = "abc";
        char[] chars = s.toCharArray();
        char[] charArr = new char[s.length()];
        System.out.println(s.length());
        for (int i = 0; i < s.length(); i++) {
            charArr[i] = s.charAt(i);
        }

        Map<Integer, Character> map = new HashMap<>();
        StringBuilder s1 = new StringBuilder();
        for(char i : charArr) {
            s1.append(i);
        }
        System.out.println(s1.toString());
    }
}
