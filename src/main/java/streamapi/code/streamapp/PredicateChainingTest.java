package streamapi.code.streamapp;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateChainingTest {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("John", "Jacky", "Jason", "Barry", "Frank");
        System.out.print("\nDisplay All names : ");
        process(names, c -> true);

        System.out.print("\nDisplay No names : ");
        process(names, c -> false);

        System.out.print("\nDisplay names which startswith 'J' : ");
        process(names, c -> c.startsWith("J"));

        System.out.print("\nDisplay names which ends with 'n' : ");
        process(names, c -> c.endsWith("n"));

        System.out.print("\nDisplay names which are longer than 4 character : ");
        process(names, c -> c.length() > 4);

        // Another way to apply Predicate on each element of collection
        // Stream's filter() method also accepts a Prediicate object
        // You can use filter() to creat another Collection or List with
        // elements, which satisfy Predicate conditions

        List hasR = names.stream()
                .filter(c -> c.contains("r"))
                .collect(Collectors.toList());
        System.out.print("\nList with words contains 'r' : " + hasR);

        List startsWithB = names.stream()
                .filter(c -> c.startsWith("B"))
                .collect(Collectors.toList());
        System.out.print("\nList with words starts with 'B' : " + startsWithB);

        // We can even combine Predicate using and(), or() And xor() logical functions
        // for example to find names, which starts with J and four letters long, you
        // can pass combination of two Predicate

        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
        List<Predicate> predicateList = List.of(startsWithJ, fourLetterLong);

        names.stream()
                .filter(startsWithJ.and(fourLetterLong))
                .forEach((n) -> System.out.print("\nName, which starts with 'J' and four letter long is : " + n));

        // You can even negate a Predicate before passing to method
        names.stream()
                .filter(startsWithJ.negate())
                .forEach(n -> System.out.print("\nNames which doesn't starts with 'J' : "
                        + n));

        // Combining two Predicates using OR condition in Java 8
        names.stream()
                .filter(startsWithJ.or(fourLetterLong.negate()))
                .forEach(n -> System.out.print("\nNames which either    starts with 'J' or their length !=4 : " + n));
    }

    public static void process(Collection<String> names, Predicate<String> condition) {
        for (String name : names) {
            if (condition.test(name)) {
                System.out.printf("%s, ", name);
            }
        }
    }

}
