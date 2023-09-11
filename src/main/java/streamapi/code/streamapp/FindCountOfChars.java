package streamapi.code.streamapp;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class FindCountOfChars {

    public static void main(String[] args) {
        String s = "string data to Count each character";
        findCountOfChars(s);
    }

    public static void findCountOfChars(String s) {
        Map<String, Long> map = Arrays.stream(s.split(""))
//                .map(String::toLowerCase)
                .collect(Collectors
                        .groupingBy(str -> str, Collectors.counting()));
        System.out.println(map);
    }
}
