import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2019/10/26 10:36 上午
 */
public class FilteringApples {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80.0, "green"),
                new Apple(155.0, "green"),
                new Apple(120.0, "red"));
        //inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
        inventory.sort(Comparator.comparing(Apple::getWeight));
        List<Apple> apples = filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));
        // Consumer<Apple> appleConsumer = (Apple a) -> System.out.println(a.getWeight());
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        list.forEach(e -> {
            if (p.test(e)) {
                result.add(e);
            }
        });
        return result;
    }
}
