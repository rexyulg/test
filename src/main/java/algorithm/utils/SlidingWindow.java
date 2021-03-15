package algorithm.utils;

import java.util.*;

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
        //needs 和 window 相当于计数器，分别记录 T 中字符出现次数和「窗口」中的相应字符的出现次数
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int lo = 0, hi = 0;
        //valid 变量表示窗口中满足 need 条件的字符个数，如果 valid 和 need.size 的大小相同，则说明窗口已满足条件，已经完全覆盖了串 T
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        //0 int start = 0, len = Integer.MAX_VALUE;
        while (hi < s.length()) {
            // c是将移入窗口的字符
            char c = s.charAt(hi);
            //又移窗口
            hi++;
            //进行窗口内数据的一系列更新
            //1....

            /* debug输出的位置 */
            //System.out.printf("window: [%d, %d)\n%n", lo, hi);

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

    public static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int lo = 0, hi = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (hi < s.length()) {
            char c = s.charAt(hi);
            hi++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            System.out.printf("window: [%d, %d)\n%n", lo, hi);
            if (lo == 6 && hi == 12) {
                System.out.println(124);
            }
            while (valid == need.size()) {
                if (hi - lo < len) {
                    len = hi - lo;
                    start = lo;
                }
                char d = s.charAt(lo);
                lo++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        //System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        for (int i = 1; i < 1000; i++) {
            System.out.println(Math.abs(new Random().nextInt()) % 100);
        }
    }
}
