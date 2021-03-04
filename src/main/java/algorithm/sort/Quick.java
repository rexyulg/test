package algorithm.sort;

import algorithm.utils.StdRandom;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2021/3/4 4:24 下午
 */
public class Quick {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a); //消除对输入的依赖
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int j = partition(a, lo, hi); //切分,j确定了位置
        sort(a, lo, j - 1);//将左半部分a[lo..j-1]排序
        sort(a, j + 1, hi);//将右半部分a[j+1..hi]排序
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        //将数组切分为a[lo..i-1]和,a[i],a[i+1..hi]
        int i = lo, j = hi + 1;//左右扫描指针
        Comparable v = a[lo];//切分元素
        while (true) {
            //扫描左右，检查扫描是否结束并交换元素
            while (less(a[++i], v)) {
                if (i == hi) {//有序
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == lo) {//有序
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j; // a[lo..j-1]<=a[j]<=a[j+1..hi]达成
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
}
