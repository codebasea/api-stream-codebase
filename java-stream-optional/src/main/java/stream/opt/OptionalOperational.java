package stream.opt;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Slf4j
public class OptionalOperational {
    public static void main(String[] args) {
        String str = getNameNotNull();
        System.out.println(str);

        str = getNameNull();
        System.out.println(str);

        str = getNameStringNull();
        System.out.println(str);

        str = getNameStringOrElse();
        System.out.println(str);

//        str = getException();
        System.out.println(str);

        optionalOrElseGetExample();

    }

    public static String getNameNotNull(){
        String name = "baeldung";
       return Optional.of(name)
                .orElseGet(()->getRandomName());
    }

    public static String getNameNull(){
        String name = null;
        return Optional.ofNullable(name)
                .orElseGet(()->getRandomName());
    }

    public static String getNameStringNull(){
        String name = null;
        return Optional.ofNullable(name)
                .orElseGet(()->new String("Hi"));
    }

    public static String getNameStringOrElse(){
        String name = null;
        return Optional.ofNullable(name)
                .orElse(new String("Hi"));
    }

    public static String getException(){
        String name = null;
        return Optional.ofNullable(name)
                .orElseThrow(() -> new RuntimeException("Error in Application"));
    }


    public static String getRandomName() {
        List<String> names = List.of("Ram", "Shyam","Jack", "Joe","Hari");

        Random random = new Random();
        int index = random.nextInt(5);

        return names.get(index);
    }


    private static void optionalOrElseGetExample(){
        System.out.println("-------------optionalOrElseGetExample-----");
        Optional<Integer> optional1 = Optional.of(1);
        System.out.println("Optional1 : " + optional1);
        Integer val =  optional1.orElseGet(()-> 10);
        System.out.println("Value at Optional1 is : " + val);

        Optional<Integer> optional2 = Optional.empty();
        Optional<String> optional3 = Optional.empty();
        System.out.println("\nOptional2 : " + optional2);
        System.out.println("\nString :" + optional3+"#");
        val =  optional2.orElseGet(()-> 10);
        System.out.println("Value at Optional2 is : " + val);
    }




}
