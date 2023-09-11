package streamapi.code.streamapp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SortAnArray {
    public static void main(String[] args) {
        int arr[] = { 99, 55, 203, 99, 4, 91 };
        Arrays.parallelSort(arr);
        // Sorted the Array using parallelSort()

        Arrays.stream(arr).forEach(System.out::println);
        /* Converted it into Stream and then
           printed using forEach */

        performCubeOnListElementsAndFilterNumbers();
        concatTwoStream();

    }
    public static void concatTwoStream(){
        System.out.println("=========concatTwoStream===========");
        List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "programs");

        Stream<String> concatStream = Stream.concat(list1.stream(), list2.stream());

        // Concatenated the list1 and list2 by converting them into Stream

        concatStream.forEach(System.out::println);
    }
    public static void performCubeOnListElementsAndFilterNumbers(){
        System.out.println("=========performCubeOnListElementsAndFilterNumbers===========");
        List<Integer> integerList = Arrays.asList(4,5,6,7,1,2,3);
        integerList.stream()
                .map(i -> i*i*i)
                .filter(i -> i>200)
                .forEach(System.out::println);


    }
}
