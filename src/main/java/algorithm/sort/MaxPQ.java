package algorithm.sort;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2021/3/4 8:01 下午
 */
public class MaxPQ<Key extends Comparable<Key>> {

    //大顶堆
    private Key[] pq;
    private int N = 0;

    MaxPQ() {
        this(1);
    }

    MaxPQ(int max) {
        //pq[0]不使用
        pq = (Key[]) new Comparable[max + 1];
    }

    MaxPQ(Key[] a) {
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
     * 返回最大元素
     */
    Key max() {
        return pq[1];
    }

    /**
     * 删除并返回最大元素
     */
    Key delMax() {
        //从根结点得到最大元素
        Key max = max();
        //将其和最后一个节点交换
        exch(1, N--);
        pq[N + 1] = null;//防止对象游离
        sink(1);//恢复堆的有序性
        if (N > 0 && N == (pq.length - 1) / 4) {
            resize(pq.length / 2);
        }
        return max;
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
        while (k > 1 && less(k / 2, k)) {
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
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }
}
