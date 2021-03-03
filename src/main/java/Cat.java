package main.java;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2019/9/4 11:25 上午
 */
public class Cat implements Animal {
    @Override
    public void run(String name) {
        System.out.println(String.format("cat %s is running", name));
    }
}
