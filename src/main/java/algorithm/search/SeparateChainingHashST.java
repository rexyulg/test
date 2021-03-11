package algorithm.search;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2021/3/11 2:53 下午
 */
public class SeparateChainingHashST<Key, Value> {

    //键值对总数
    private int N;
    //散列表的大小
    private int M;
    //存放链表对象的数组
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int M) {
        //创建M条链表
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<>();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    public void put(Key key, Value val) {
        st[hash(key)].put(key, val);
    }
}
