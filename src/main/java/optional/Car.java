package main.java.optional;

import java.util.Optional;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2020/1/9 10:55 上午
 */
public class Car {

    private Insurance insurance;

    public Optional<Insurance> getInsuranceAsOptional() {
        return Optional.ofNullable(insurance);
    }
}
