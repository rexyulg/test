package algorithm.sort;

import algorithm.utils.In;
import algorithm.utils.StdIn;
import algorithm.utils.StdOut;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2021/3/3 2:39 下午
 */
public class Example {

    public static void sort(Comparable[] a) {

    }

    /**
     * 对元素进行比较
     *
     * @param v
     * @param w
     * @return
     */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = new In(args[0]).readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
