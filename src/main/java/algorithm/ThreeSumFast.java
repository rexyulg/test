package main.java.algorithm;

import java.util.Arrays;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2021/3/2 2:44 下午
 */
public class ThreeSumFast {

    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (BinarySearch.rank(-a[i] - a[j], a) > j) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        StdOut.println(count(a));
    }
}
