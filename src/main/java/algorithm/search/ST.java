package algorithm.search;

import algorithm.utils.StdIn;
import algorithm.utils.StdOut;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2021/3/5 2:48 下午
 */
public class ST<Key extends Comparable<Key>, Value> {

    public ST() {
    }

    void delete(Key key) {
        put(key, null);
    }

    boolean contains(Key key) {
        return get(key) != null;
    }

    Value get(Key key) {
        return null;
    }

    boolean isEmpty() {
        return size() == 0;
    }

    int size() {

        return 0;
    }

    /**
     * [lo..hi]之间键的数量
     * @param lo
     * @param hi
     * @return
     */
    int size(Key lo, Key hi) {
        if (hi.compareTo(lo) < 0) {
            return 0;
        } else if (contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        } else {
            return rank(hi) - rank(lo);
        }
    }

    void put(Key key, Value val) {

    }

    Iterable<Key> keys() {
        return keys(min(), max());
    }

    /**
     * [lo..hi]之间的所有键，已排序
     * @param lo
     * @param hi
     * @return
     */
    Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    /**
     * min key
     * @return
     */
    Key min() {
        return null;
    }

    /**
     * max key
     * @return
     */
    Key max() {
        return null;
    }

    /**
     * 小于等于key的最大键，类似向下取整
     * @param key
     * @return
     */
    Key floor(Key key) {
        return null;
    }

    /**
     * 大于等于key的最小键，类似于向上取整
     * @param key
     * @return
     */
    Key ceiling(Key key) {
        return null;
    }

    /**
     * 小于key的键的数量
     * @param key
     * @return
     */
    int rank(Key key) {
        return -1;
    }

    /**
     * 排名为k的键
     * @param k
     * @return
     */
    Key select(int k) {
        return null;
    }

    void deleteMin() {
        delete(min());
    }

    void deleteMax() {
        delete(max());
    }

    public static void main(String[] args) {
        ST<String, Integer> st = new ST<>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s: st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }
    }
}
