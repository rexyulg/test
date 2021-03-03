package main.java.algorithm;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2021/3/3 9:57 上午
 */
public class QuickUnionUF {

    private int[] id;
    private int cnt;

    public QuickUnionUF(int N) {
        cnt = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     * 在p和q之间添加一条连线
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        id[pRoot] = qRoot;
        cnt--;
    }

    /**
     * p(0~N-1)所在分量的跟标识符
     * @param p
     * @return
     */
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    /**
     * 如果p和q存在于同一个分量中，则返回true
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return cnt;
    }
}
