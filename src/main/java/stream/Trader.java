package main.java.stream;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2019/11/27 10:08 下午
 */
public class Trader {

    private final String name;

    private final String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader: " + this.name + " in " + this.city;
    }
}
