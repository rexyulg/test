package stream;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2019/11/27 10:15 下午
 */
public class TradeTest {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        System.out.println("Result 1:");
        transactions.stream().filter(t -> t.getYear() == 2011).sorted(comparing(Transaction::getValue))
                .forEach(System.out::println);

        System.out.println("Result 2:");
        transactions.stream().map(t -> t.getTrader().getCity()).distinct().forEach(System.out::println);
        Set<String> cities = transactions.stream().map(t -> t.getTrader().getCity()).collect(Collectors.toSet());
        System.out.println(cities);

        List<Trader> traders = transactions.stream().map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity())).distinct().sorted(comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println("Result 3: " + traders);

        String tradersStr = transactions.stream().map(t -> t.getTrader().getName()).distinct().sorted()
                .reduce("", (n1, n2) -> n1 + n2);
        System.out.println("Result 4: " + tradersStr);

        String tradersStr2 = transactions.stream().map(t -> t.getTrader().getName()).distinct().sorted()
                .collect(Collectors.joining());
        System.out.println(tradersStr2);

        boolean milanBased = transactions.stream().anyMatch(t -> "Milan".equals(t.getTrader().getCity()));
        System.out.println("Result 5: " + milanBased);

        transactions.stream().filter(t -> "Cambridge".equals(t.getTrader().getCity())).map(Transaction::getValue)
                .forEach(System.out::println);

        System.out.println("Question 7: ");
        Optional<Integer> topValue = transactions.stream().map(Transaction::getValue).max(Integer::compareTo);
        Optional<Integer> topValue2 = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
        topValue.ifPresent(System.out::println);
        topValue2.ifPresent(System.out::println);

        System.out.println("Question 8: ");
        Optional<Transaction> minTransaction = transactions.stream().min(comparing(Transaction::getValue));
        Optional<Transaction> smallestTransaction = transactions.stream()
                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        minTransaction.ifPresent(System.out::println);
        smallestTransaction.ifPresent(System.out::println);

    }
}
