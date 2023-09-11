package streamapi.code.streamapp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortValuesInDescending {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

        myList.stream()
                .sorted(Collections.reverseOrder())
                .forEach(System.out::println);

        System.out.println("Given a list of integers, sort all the values present in it using Stream functions");
        myList.stream()
                .sorted()
                .forEach(System.out::println);


    }
}
