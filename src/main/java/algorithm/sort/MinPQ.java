package algorithm.sort;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2021/3/4 8:29 下午
 */
public class MinPQ<Key extends Comparable<Key>> {

    //小顶堆
    private Key[] pq;
    private int N;

    MinPQ() {
        this(1);
    }

    /**
     * 创建初始容量为max的邮箱队列
     *
     * @param max
     */
    MinPQ(int max) {
        pq = (Key[]) new Comparable[max + 1];
    }

    MinPQ(Key[] a) {
        N = a.length;
        pq = (Key[]) new Comparable[N + 1];
        for (int i = 0; i < N; i++) {
            pq[i + 1] = a[i];
        }
        for (int k = N / 2; k >= 1; k--) {
            sink(k);
        }
    }

    /**
     * 向优先队列中插入一个元素
     */
    void insert(Key v) {
        if (N == pq.length - 1) {
            resize(2 * pq.length);
        }
        pq[++N] = v;
        swim(N);
    }

    private void resize(int capacity) {
        Key[] tmp = (Key[]) new Comparable[capacity];
        for (int i = 1; i <= N; i++) {
            tmp[i] = pq[i];
        }
        pq = tmp;
    }

    /**
     * 返回最小元素
     */
    Key min() {
        return pq[1];
    }

    /**
     * 删除并返回最小元素
     */
    Key delMin() {
        Key min = min();
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        if (N > 0 && N == (pq.length - 1) / 4) {
            resize(pq.length / 2);
        }
        return min;
    }

    boolean isEmpty() {
        return N == 0;
    }

    int size() {
        return N;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    /**
     * 由下至上的堆有序化（上浮）
     */
    private void swim(int k) {
        while (k > 1 && less(k, k / 2)) {
            exch(k / 2, k);
            k /= 2;
        }
    }

    /**
     * 由上至下的堆有序化（下沉）
     */
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j + 1, j)) {
                j++;
            }
            if (less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }
}
