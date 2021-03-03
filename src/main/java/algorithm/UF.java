package main.java.algorithm;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2021/3/2 8:51 下午
 */
public class UF {

    private int[] id;
    private int cnt;

    public UF(int N) {
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
        int pid = find(p);
        int qid = find(q);
        if (pid == qid) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
        cnt--;
    }

    /**
     * p(0~N-1)所在分量的标识符
     * @param p
     * @return
     */
    public int find(int p) {
        return id[p];
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
