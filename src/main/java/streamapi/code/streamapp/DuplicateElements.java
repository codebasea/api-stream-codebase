package streamapi.code.streamapp;

import java.util.*;
import java.util.stream.*;

public class DuplicateElements {
    public static void main(String args[]) {
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15,20,20);
        Set<Integer> set = new HashSet();
        Set<Integer> set1 = new HashSet();
        set1 = myList.stream()
                .filter(n -> !set.add(n))
                .collect(Collectors.toSet());
        System.out.println(set1);
    }
}
