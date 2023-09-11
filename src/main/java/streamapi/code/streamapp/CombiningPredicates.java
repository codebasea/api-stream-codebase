package streamapi.code.streamapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CombiningPredicates {
    public static void main(String[] args) {

        whenFilterListWithCollectionOfPredicatesUsingAnd_thenSuccess();
        whenFilterListWithCollectionOfPredicatesUsingOr_thenSuccess();


        Predicate<String> predicate1 = str -> str.startsWith("A");
        Predicate<String> predicate2 =  str -> str.length() < 5;



        List<String> names = Arrays.asList("Adam", "Alexander", "Aohn", "Tom");
        List<String> result = names.stream()
                .filter(predicate1.and(predicate2))
                .collect(Collectors.toList());

        System.out.println(result);

        result = names.stream()
                .filter(predicate1.or(predicate2))
                .collect(Collectors.toList());

        System.out.println(result);

        result = names.stream()
                .filter(predicate1.or(predicate2.negate()))
                .collect(Collectors.toList());

        System.out.println(result);

        result = names.stream()
                .filter(predicate2.negate())
                .collect(Collectors.toList());

        System.out.println(result);
    }

    public static void whenFilterListWithCollectionOfPredicatesUsingAnd_thenSuccess(){
        System.out.println("====================whenFilterListWithCollectionOfPredicatesUsingAnd_thenSuccess====");
        List<String> names = Arrays.asList("Adam", "Alexander", "Aohn", "Tom");

        List<Predicate<String>> allPredicates = new ArrayList<Predicate<String>>();

        allPredicates.add(str -> str.startsWith("A"));
        allPredicates.add(str -> str.contains("d"));
        allPredicates.add(str -> str.length() > 4);

        List<String> result = names.stream()
                .filter(allPredicates.stream().reduce(x->true, Predicate::and))
                .collect(Collectors.toList());
        System.out.println(result);
        System.out.println("====================whenFilterListWithCollectionOfPredicatesUsingAnd_thenSuccess====");

    }

    public static void whenFilterListWithCollectionOfPredicatesUsingOr_thenSuccess(){
        System.out.println("====================whenFilterListWithCollectionOfPredicatesUsingOr_thenSuccess====");
        List<String> names = Arrays.asList("Adam", "Alexander", "Aohn", "Tom");
        List<Predicate<String>> allPredicates = new ArrayList<Predicate<String>>();

        List<String> result = names.stream()
                .filter(allPredicates.stream().reduce(x->false, Predicate::or))
                .collect(Collectors.toList());
        System.out.println(result);
        System.out.println("====================whenFilterListWithCollectionOfPredicatesUsingOr_thenSuccess====");

    }
}
