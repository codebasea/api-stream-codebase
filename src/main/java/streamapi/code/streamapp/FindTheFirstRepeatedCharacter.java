package streamapi.code.streamapp;

import org.apache.logging.log4j.util.Strings;

import java.util.Map;
import java.util.function.Function;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class FindTheFirstRepeatedCharacter {
    private static boolean isEmpty(Character c){
        if(Character.isSpaceChar(c) || Character.isWhitespace(c)){
            return false;
        }
        return true;
    }

    public static void main(String args[]) {
        String input = "Java articles are Awesome";

        Map<Character,Long> c= input.chars() // Stream of String
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase
                .filter(FindTheFirstRepeatedCharacter::isEmpty)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(c);

        Character result = input.chars() // Stream of String
//                .mapToObj(s -> (Character.valueOf((char) s))) // First convert to Character object and then to lowercase
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) //Store the chars in map with count
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1L)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
        System.out.println(result);

    }
}
