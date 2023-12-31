package streamapi.code.streamapp;

import streamapi.code.model.Notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * find only duplicate elements with its count from the String
 * Collections.frequency(List, x)>1)
 */
public class MapUtility {
    public static void main(String[] args) {


        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String, Long> namesCount = names.stream()
                .filter(x -> Collections.frequency(names, x) > 1)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(namesCount);

//        countEachElement();
        convertAListOfObjectsIntoAMap();

    }

    /**
     * How to count each element/word from the String ArrayList in Java8?
     */
    public static void convertAListOfObjectsIntoAMap() {
        List<Notes> noteLst = new ArrayList<>();
        noteLst.add(new Notes(1, "note1", 11, "Nokia"));
        noteLst.add(new Notes(2, "note2", 22, "Sony"));
        noteLst.add(new Notes(3, "note3", 33, "Bat"));
        noteLst.add(new Notes(4, "note4", 33, null));
        noteLst.add(new Notes(4, "note4", 55, "Lava"));
        noteLst.add(new Notes(4, "note4", 5, "Moto"));
        noteLst.add(new Notes(4, "note4", 7, "Poco"));
        noteLst.add(new Notes(5, "note5", 55, "Asus"));


//        mapByTagIdWithCounting(noteLst);
//        mapByTagIdWithNotesWithNonDuplicate(noteLst);
//        mapByTagIdWithUniqueNotes(noteLst);
        mapByTagIdWithUniqueNotesV0(noteLst);
//        mapByTagIdWithUniqueNotesV1(noteLst);
//        mapByTagIdWithUniqueNotesV2(noteLst);


    }

    private static void mapByTagIdWithUniqueNotesV0(List<Notes> noteLst) {
        Map<String, Notes> notesRecords_V0 = noteLst.stream()
                .collect(Collectors.toMap
                        (Notes::getTagName, Function.identity(), (first, second) -> null != first.getBrand() ? first : second));
//        System.out.println("notesRecords_V3 : " + notesRecords_V0);
        notesRecords_V0.entrySet().forEach(System.out::println);
    }

    private static BinaryOperator<Notes> fetchNotesNotNull() {
        return (first, second) -> null != first.getBrand() ? first : second;
    }

    private static void mapByTagIdWithUniqueNotesV2(List<Notes> noteLst) {
        Map<String, Notes> notesRecords_V4 = noteLst.stream()
                .collect(Collectors.toMap
                        (Notes::getTagName, Function.identity(), (first, second) -> first, LinkedHashMap::new));
        System.out.println("notesRecords_V4 : " + notesRecords_V4);
    }

    private static void mapByTagIdWithUniqueNotesV1(List<Notes> noteLst) {
        Map<String, Notes> notesRecords_V3 = noteLst.stream()
                .collect(Collectors.toMap
                        (Notes::getTagName, Function.identity(), (first, second) -> first));
        System.out.println("notesRecords_V3 : " + notesRecords_V3);
    }

    private static void mapByTagIdWithUniqueNotes(List<Notes> noteLst) {
        Map<String, Notes> notesRecords_V2 = noteLst.stream()
                .sorted(Comparator
                        .comparingLong(Notes::getTagId)
                        .reversed()) // sorting is based on TagId 55,44,33,22,11
                .collect(Collectors.toMap
                        (Notes::getTagName, Function.identity(), (first, second) -> first));
        System.out.println("notesRecords_V2 : " + notesRecords_V2);
    }

    private static void mapByTagIdWithNotesWithNonDuplicate(List<Notes> noteLst) {
        Map<String, Notes> notesRecords_V1 = noteLst.stream()
                .sorted(Comparator
                        .comparingLong(Notes::getTagId)
                        .reversed()) // sorting is based on TagId 55,44,33,22,11
                .collect(Collectors.toMap
                        (Notes::getTagName, notes -> notes,
                                (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println("notesRecords_V1 : " + notesRecords_V1);
    }

    private static void mapByTagIdWithCounting(List<Notes> noteLst) {
        Map<String, Integer> notesRecords = noteLst.stream()
                .sorted(Comparator
                        .comparingLong(Notes::getTagId)
                        .reversed()) // sorting is based on TagId 55,44,33,22,11
                .collect(Collectors.toMap
                        (Notes::getTagName, Notes::getTagId,
                                (oldValue, newValue) -> oldValue, LinkedHashMap::new));
// consider old value 44 for dupilcate key
// it keeps order
        System.out.println("Notes : " + notesRecords);
    }

    public static void countEachElement() {
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String, Long> namesCount = names
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()
                ));

        System.out.println(namesCount);
    }

}
