package main.java;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2019/9/4 11:21 上午
 */
public class Dog implements Animal {
    @Override
    public void run(String name) {
        System.out.println(String.format("dog %s is running", name));
    }
}
