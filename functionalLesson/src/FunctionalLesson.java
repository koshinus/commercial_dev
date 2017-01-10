import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by vadim on 13.12.16.
 */
public class FunctionalLesson
{

    public static boolean isPrime(int num)
    {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }

    public static myPair<Integer, Integer> firstAndLast(int num)
    {
        myPair<Integer, Integer> fas =
                new myPair<>(1, num % 10);
        while(num > 10) num /= 10;
        fas.fst = num;
        return fas;
    }

    public static Integer statistic(String str, char symb)
    {
        Integer n = 0;
        char[] ar = str.toCharArray();
        for (char c: ar)
            if (symb == c) n++;
        return n;
    }

    public static Map<Character, Integer> allStatistics(String str)
    {
        Map<Character, Integer> map = new HashMap<>();
        for (char c = 'a'; c < 'z'; c++)
            map.put(c, statistic(str, c));
        return map;
    }

    public static void main(String[] args)
    {
        List<String>  lst1 = Arrays.asList("sjdkhfdkjsf", "qwiuehrfioewjr", "otlichnik tvoy i ego teorema", "dermishe polnoe domoy bomji");
        List<Integer> lst2 = Arrays.asList(1, 2, 3);
        List<Integer> lst3 = Arrays.asList(10, 23, 3083, 17*23*29+1);

        int summ = lst2.stream()
                        .mapToInt(n -> n*n)
                        .sum();
        lst3.stream()
                .filter(FunctionalLesson::isPrime)
                .map(FunctionalLesson::firstAndLast)
                .forEach(s -> System.out.println(
                        s.fst.toString() + "->" + s.snd.toString()));
        System.out.println("==================================================================");

        String symbols =
                lst1.stream()
                        .map(String::toLowerCase)
                        .reduce("", (a, b) -> a+b);

        Map<Character, Integer> map = allStatistics(symbols);

        map.entrySet().stream()
                .sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                .forEach(s -> System.out.println(
                        s.getKey() + "->" + s.getValue()
                ));

        System.out.println("===============================================================");
        lst1.stream()
                .map(s -> s.toLowerCase().split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(k -> k))
                .values()
                .stream()
                .sorted((l, r)-> r.size()-l.size())
                .forEach(s -> System.out.println(s.get(0)));

        System.out.println("===============================================================");
        System.out.println(summ);

        /*for(AbstractMap.SimpleImmutableEntry<Integer, Integer> el : xyz)
            System.out.println(el.getKey().toString() + "->" + el.getValue().toString() );*/
    }
}
