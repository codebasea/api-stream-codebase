package com.stream.apis.domain;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;


@ToString
public class Person {
    String name;
    String mail;
    LocalDate birthday;
//


    String emailAddress;

    public Person(String name, LocalDate birthday, String mail) {
        this.name=name;
        this.birthday=birthday;
        this.mail=mail;
    }

    public int getAge() {
        return birthday.until(IsoChronology.INSTANCE.dateNow()).getYears();
    }

    public String getName() {
        return name;
    }
}
