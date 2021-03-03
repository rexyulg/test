package main.java.algorithm;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2021/2/22 11:14 上午
 */
public class BasicAlgorithm {

    /**
     * 求p,q最大公约数
     * @param p
     * @param q
     * @return
     */
    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }
}
