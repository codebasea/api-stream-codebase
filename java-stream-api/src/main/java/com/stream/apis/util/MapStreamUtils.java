package com.stream.apis.util;

import com.stream.apis.domain.Person;

import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

public class MapStreamUtils {

    public static List<Person> populatePerson(){
        ArrayList<Person> members = new ArrayList<>();

        members.add(new Person("Fred", IsoChronology.INSTANCE.date(1980, 6, 20),  "fred@example.com"));
        members.add(new Person("Jane", IsoChronology.INSTANCE.date(1990, 7, 15),  "jane@example.com"));
        members.add(new Person("Mark", IsoChronology.INSTANCE.date(1990, 7, 15),  "mark@example.com"));
        members.add(new Person("George", IsoChronology.INSTANCE.date(1991, 8, 13),  "george@example.com"));
        members.add(new Person("Bob", IsoChronology.INSTANCE.date(2000, 9, 12),  "bob@example.com"));
        members.add(new Person("Praveen", IsoChronology.INSTANCE.date(2022, 7, 8),  "bob@example.com"));


        return members;
    }
}
