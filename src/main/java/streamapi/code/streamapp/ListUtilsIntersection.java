package streamapi.code.streamapp;

import org.apache.commons.collections4.ListUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListUtilsIntersection {
    public static void main(String[] args) {
        retainAllTest();
        retainAllTestV2();
        retainAllTestV3();
        retainAllTestV4();
    }

    private static void retainAllTestV4() {
        System.out.println("retainAllTestV4");
        List<String> result = ListUtils.intersection(getList1(), getList2());
        result.forEach(System.out::println);
    }
    private static void retainAllTestV3() {
        System.out.println("retainAllTestV3");
        List<String> result = getList1 ().stream()
                .filter(f -> getList2 ().contains(f))
                .toList();
        result.forEach(System.out::println);
    }
    private static List<String> getList2(){
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("D");
        list2.add("B");
        list2.add("C");
        return list2;
    }
    private static List<String> getList1(){
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        return list1;
    }
    private static void retainAllTestV2() {
        System.out.println("retainAllTestV2");
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("D");
        list2.add("B");
        list2.add("C");
        ArrayList<String> returnArrayList = new ArrayList<String>();
        for (String test : list1) {
            if (!returnArrayList.contains(test)) {
                if (list2.contains(test)) {
                    returnArrayList.add(test);
                }
            }
        }
        returnArrayList.forEach(System.out::print);
    }

    private static void retainAllTest() {
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("D");
        list2.add("B");
        list2.add("C");
        ArrayList<String> intersection = new ArrayList<String>(list1);
        intersection.forEach(System.out::println);
        System.out.println("intersection.retainAll(list2)");
        intersection.retainAll(list2);
        intersection.forEach(System.out::println);

    }
}
