package main.java.algorithm;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2021/3/3 10:28 上午
 */
public class WeightedQuickUnionUF {

    //父链接数组（由触点索引）
    private int[] id;
    //（由触点索引的）各个根结点所对应的分量的大小
    private int[] sz;
    //连通分量的数量
    private int cnt;

    public WeightedQuickUnionUF(int N) {
        cnt = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) {
            return;
        }
        //将小树的根结点连接到大树的根结点
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        cnt--;
    }

    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    /**
     * 如果p和q存在于同一个分量中，则返回true
     *
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
