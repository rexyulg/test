package algorithm.search;

import algorithm.utils.Queue;
import algorithm.utils.StdOut;

import java.util.NoSuchElementException;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2021/3/9 3:28 下午
 */
public class BST<Key extends Comparable<Key>, Value> {
    //二叉查找树的根结点
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        //以该结点为跟的子树中的结点总数
        private int N;

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            N = N;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.N;
        }
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        //以x为根结点的子树中查找并返回key所对应的值，如果找不到则返回null
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.val;
        }
    }

    public void put(Key key, Value val) {
        //查找key，找到则更新它，否则为它创建一个新的结点
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        //如果key存在于以x为根结点的子树中则更新它的值，否则将key和val为键值对的新节点插入到该子树中
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val = val;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        if (isEmpty()) {
            throw new NoSuchElementException("calls min() with empty symbol table");
        }
        return min(root).key;
    }

    private boolean isEmpty() {
        return size() == 0;
    }


    private Node min(Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }

    /**
     * 小于等于key的最大键，类似向下取整
     *
     * @return
     */
    public Key floor(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to floor() is null");
        }
        if (isEmpty()) {
            throw new NoSuchElementException("calls floor() with empty symbol table");
        }
        Node x = floor(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            return floor(x.left, key);
        }
        //如果给定的键值key大于二叉查找树的根结点，那么只有当根结点右子树存在小于等于key的结点时，小于等于key的最大键才会出现在右子树中，
        //否则根结点就是小于等于key的最大键
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    /**
     * 返回排名为k的结点
     *
     * @param x
     * @param k
     * @return
     */
    private Node select(Node x, int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if (t > k) {
            return select(x.left, k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    /**
     * 返回以x为根结点的子树中小于x.key的键的数量
     *
     * @param key
     * @param x
     * @return
     */
    private int rank(Key key, Node x) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            rank(key, x.left);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rank(key, x.right);
        } else {
            size(x.left);
        }
        return 0;
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table underflow");
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    private void print(Node x) {
        if (x == null) {
            return;
        }
        print(x.left);
        StdOut.print(x.key);
        print(x.right);
    }

    public Iterable<Key> keys(){
        return keys(min(), max());
    }

    /**
     * 范围查找
     * @param lo
     * @param hi
     * @return
     */
    private Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) {
            return;
        }
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) {
            keys(x.left, queue, lo, hi);
        }
        if (cmplo <= 0 & cmphi >=0) {
            queue.enqueue(x.key);
        }
        if (cmphi > 0) {
            keys(x.right, queue, lo, hi);
        }
    }

    private Key max() {
        if (isEmpty()) {
            throw new NoSuchElementException("calls max() with empty symbol table");
        }
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }
}
