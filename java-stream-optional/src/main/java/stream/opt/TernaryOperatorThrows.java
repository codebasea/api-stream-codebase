package stream.opt;

import domain.Person;

import java.time.chrono.IsoChronology;
import java.util.Optional;

public class TernaryOperatorThrows {
    public static void main(String[] args) {
        getInstance();
    }
    public static Person getInstance() {
        Person person = new Person("Fred", IsoChronology.INSTANCE.date(1980, 6, 20),
                "fred@example.com");
        Person person2 = null;
        return Optional.ofNullable(person)
                .orElseThrow(() -> new RuntimeException("error"));
    }
}
