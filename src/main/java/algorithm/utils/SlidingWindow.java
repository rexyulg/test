package algorithm.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2021/3/12 4:26 下午
 */
public class SlidingWindow {

    /**
     * 滑动窗口算法框架
     *
     * @param s
     * @param t
     */
    void slidingWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int lo = 0, hi = 0;
        int valid = 0;
        while (hi < s.length()) {
            // c是将移入窗口的字符
            char c = s.charAt(hi);
            //又移窗口
            hi++;
            //进行窗口内数据的一系列更新
            //1....

            /* debug输出的位置 */
            System.out.printf("window: [%d, %d)\n%n", lo, hi);

            //判断左侧窗口是否要搜索
            while(/*2.window needs shrink*/true) {
                //d是将移除窗口的字符
                char d = s.charAt(lo);
                //左移窗口
                lo++;
                //进行窗口内数据的一系列更新
                //3....
            }
        }
    }
}
