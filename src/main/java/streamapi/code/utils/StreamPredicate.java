package streamapi.code.utils;

import java.util.Objects;
import java.util.function.Predicate;

public class StreamPredicate {
    public static void main(String[] args) {
        Predicate<String> isNullOrEmpty = StreamPredicate.<String>isNull().and(isEmpty());
        System.out.println(isNullOrEmpty.test(null));   // true
        System.out.println(isNullOrEmpty.test(""));     // true
        System.out.println(isNullOrEmpty.test("Foo"));  // false
    }
    private static <T> Predicate<T> isNull(){
        return Objects::nonNull;
    }
    private static Predicate<String> isEmpty(){
        return string -> !string.isEmpty();
    }
}
