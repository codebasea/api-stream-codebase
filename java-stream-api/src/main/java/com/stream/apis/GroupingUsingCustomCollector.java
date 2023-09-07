package com.stream.apis;


import com.stream.apis.domain.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.stream.apis.util.MapStreamUtils.populatePerson;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class GroupingUsingCustomCollector {

    public static void main(String[] args) {
        GroupingUsingCustomCollector groupingUsingCustomCollector = new GroupingUsingCustomCollector();
        groupingUsingCustomCollector.groupBykeyWithPersons();
    }

    private List<Person> groupingOfPersonWithMap() {
        return populatePerson();
    }

    private Map<Integer, List<Person>> groupingByAgeWithMap() {
        List<Person> members = groupingOfPersonWithMap();
        members.stream().forEach(System.out::println);
        return members.stream().collect(groupingBy(Person::getAge));
    }

    private void groupBykeyWithPersons(){
        Map<Integer, List<Person>> collect = groupingByAgeWithMap();
        collect.entrySet().stream().forEach(System.out::println);

        Map<Integer, List<String>> result = new HashMap<>();

        collect.keySet().forEach(key -> {
            result.put(key, collect.get(key).stream().map(Person::getName).collect(toList()));
        });
        System.out.println("\ngroupBykeyWithPersons # Members \n#"+result);
    }
}
