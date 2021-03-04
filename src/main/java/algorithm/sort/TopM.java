package algorithm.sort;

import algorithm.utils.Stack;
import algorithm.utils.StdIn;
import algorithm.utils.StdOut;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2021/3/4 8:30 下午
 */
public class TopM {

    public static void main(String[] args) {
        //打印输入流中最大的M行
        int M = Integer.parseInt(args[0]);
        MinPQ<Transaction> pq = new MinPQ<>(M + 1);
        while (StdIn.hasNextLine()) {
            //为下一行输入创建一个元素并放入优先队列中
            pq.insert(new Transaction(StdIn.readLine()));
            if (pq.size() > M) {
                //如果优先队列中存在M+1个元素则删除其中最小的元素
                pq.delMin();
            }
        }
        Stack<Transaction> stack = new Stack<>();
        while (!pq.isEmpty()) {
            stack.push(pq.delMin());
        }
        for (Transaction t: stack) {
            StdOut.println(t);
        }
    }
}
