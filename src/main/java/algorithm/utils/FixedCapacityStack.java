package algorithm.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2021/2/26 11:07 下午
 */
public class FixedCapacityStack<T> implements Iterable<T>{

    private T[] a;  // holds the items
    private int N; //number of items in stack

    // create an empty stack with given capacity
    public FixedCapacityStack(int capacity) {
        a = (T[]) new Object[capacity];
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean isFull() {
        return N == a.length;
    }

    public void push(T item) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N++] = item;
    }

    public T pop() {
        T item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    public T peek() {
        return a[N - 1];
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }


    public class ReverseArrayIterator implements Iterator<T> {
        private int i = N - 1;

        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return a[i--];
        }
    }

    private void resize(int max) {
        T[] tmp = (T[]) new Object[max];
        for (int i = 0; i < N; i++) {
            tmp[i] = a[i];
        }
        a = tmp;
    }
}
