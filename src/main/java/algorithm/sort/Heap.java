package algorithm.sort;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2021/3/5 10:58 上午
 */
public class Heap {

    //升序排列
    public static void sort(Comparable[] a) {
        int N = a.length;
        //1.堆的构造
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }
        //2.下沉排序
        while (N > 1) {
            //取栈顶最大数，放到数组最后，栈去除该数
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    private static void sink(Comparable[] pq, int k, int n) {
        while (k * 2 <= n) {
            int j = 2 * k;
            if (j < n && less(pq, j, j + 1)) {
                j++;
            }
            if (!less(pq, k, j)) {
                break;
            }
            exch(pq, k, j);
            k = j;
        }
    }

    private static void exch(Comparable[] pq, int i, int j) {
        Comparable tmp = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = tmp;
    }

    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i - 1].compareTo(pq[j - 1]) < 0;
    }
}
