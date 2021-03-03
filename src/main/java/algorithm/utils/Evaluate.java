package algorithm.utils;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2021/2/25 10:06 下午
 */
public class Evaluate {

    public static void main(String[] args) {
        Stack<String> opts = new Stack<>();
        Stack<Double> vals = new Stack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("(")) {

            } else if (s.equals("+")) {
                opts.push(s);
            } else if (s.equals("-")) {
                opts.push(s);
            } else if (s.equals("*")) {
                opts.push(s);
            } else if (s.equals("/")) {
                opts.push(s);
            } else if (s.equals("sqrt")) {
                opts.push(s);
            } else if (s.equals(")")) {
                String op = opts.pop();
                double v = vals.pop();
                if (op.equals("+")) {
                    v = vals.pop() + v;
                } else if (op.equals("-")) {
                    v = vals.pop() - v;
                } else if (op.equals("*")) {
                    v = vals.pop() * v;
                } else if (op.equals("/")) {
                    v = vals.pop() / v;
                } else if (op.equals("sqrt")) {
                    v = Math.sqrt(v);
                }
                vals.push(v);
            } else {
                vals.push(Double.parseDouble(s));
            }
        }
        StdOut.println(vals.pop());
    }
}
