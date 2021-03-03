import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yulg
 * @E-mail yulg@dazhuanjia.com
 * @date 2019/9/4 11:19 上午
 */
public class Test {
    public static void main(String[] args) {
        //String s = "11101100.1230";
        //System.out.println((int)Float.parseFloat(s));
        int portNumber = 1337;
        Runnable r = () -> System.out.println(portNumber);
        //portNumber = 31337;
        List<String> list2 = new ArrayList<>();
        list2.add("rexyu");
        list2.add("蒋解");

        List<String> list = new ArrayList<>();
        list.add("rexyu");
        list.add("蒋解");
        list.add("liguo");
        List<String> list3 = list.stream().filter(a -> list2.contains(a)).collect(Collectors.toList());
        list2.add("liguo");
        System.out.println(list2);
        System.out.println(list3);

    }
}
