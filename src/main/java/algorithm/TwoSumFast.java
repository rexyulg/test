package main.java.algorithm;

import java.util.Arrays;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2021/3/2 2:29 下午
 */
public class TwoSumFast {

    /**
     * 计算和为0的整数对的数目
     * @param a
     * @return
     */
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (BinarySearch.rank(-a[i], a) > i) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        StdOut.println(count(a));
    }
}
