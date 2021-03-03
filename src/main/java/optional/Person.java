package main.java.optional;

import java.util.Optional;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2020/1/9 10:57 上午
 */
public class Person {

    private Car car;

    public Optional<Car> getCarAsOptional() {
        return Optional.ofNullable(car);
    }
}
