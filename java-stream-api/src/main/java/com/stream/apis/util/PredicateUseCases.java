package com.stream.apis.util;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateUseCases {
    public static void main(String[] args) {
//        checkRangeInNumbers();
//        List<String> animals = List.of("cat", "leopard", "dog", "lion", "horse");
//        Set<String> filterCat = animals.stream()
//                .filter(Predicate.not("dog"::equals).and(Predicate.not("horse"::equals)))
//                .collect(Collectors.toSet());
//        System.out.println(filterCat);

        pred(10, (i) -> i > 7);
    }

    private void testString(){
        Predicate<String> notDog = a -> !a.equals("dog");
        Predicate<String> notHorse =  a -> !a.equals("horse");
        Predicate<String> cats = notDog.and(notHorse); // !a && !b
        Predicate<String> i  = Predicate.isEqual("asdf");
    }

    private static void checkRangeInNumbers(){
        int ten = 10;
        int twenty = 20;
        int fifteen = 15;

        // Creating predicate
        Predicate<Integer> lesserthan = i -> (i < 18);

        // Calling Predicate method
        System.out.println("lesserthan 10 :"+lesserthan.test(10));



        Predicate<Integer> greaterThanTen = (i) -> i > ten;

        // Creating predicate
        Predicate<Integer> lowerThanTwenty = (i) -> i < twenty;
        boolean result = greaterThanTen.and(lowerThanTwenty).test(fifteen);
        System.out.println(result);

        // Calling Predicate method
        boolean result2 = greaterThanTen.and(lowerThanTwenty).negate().test(15);
        System.out.println(result2);
    }

    static void pred(int number, Predicate<Integer> predicate)
    {
        if (predicate.test(number)) {
            System.out.println("predicate.test(number) " + predicate.test(number));
            System.out.println("Number " + number);
        }
    }

}
