package optional;

import java.util.Optional;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2020/1/9 10:44 上午
 */
public class OptionalTest {

    public static void main(String[] args) {
//        OptionalTest test = new OptionalTest();
//        System.out.println(test.getCarInsuranceName(new Person()));
        Optional<Insurance> optionalInsurance = Optional.ofNullable(null);
        optionalInsurance.filter(i -> "CambridgeInsurance".equals(i.getName())).ifPresent(x -> System.out.println("ok"));
    }

    public String getCarInsuranceName(Person person) {
        return Optional.ofNullable(person)
                .flatMap(Person::getCarAsOptional)
                .flatMap(Car::getInsuranceAsOptional)
                .map(Insurance::getName)
                .orElse("Unknown");
    }

    public Insurance findCheapestInsurance(Person person, Car car) {
        return new Insurance();
    }
}
