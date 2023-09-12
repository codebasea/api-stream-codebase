package streamapi.code.streamapp;

import streamapi.code.model.Notes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OptionalFunctionalImpl {
    public static void main(String[] args) {
        printOptionalElements();
    }

    public static void printOptionalElements(){
        List<Notes> noteLst = new ArrayList<>();
        noteLst.add(new Notes(1, "note1", 11,"Nokia"));
        noteLst.add(new Notes(2, "note2", 22, "Sony"));
        noteLst.add(new Notes(3, "note3", 33, "Bat"));
        noteLst.add(new Notes(4, "note4", 33, null));
        noteLst.add(new Notes(4, "note4", 55, "Lava"));
        noteLst.add(new Notes(4, "note4", 5, "Moto"));
        noteLst.add(new Notes(4, "note4", 7, "Poco"));
        noteLst.add(new Notes(5, "note5", 55, "Lenovo"));

        noteLst.add(new Notes(6, "note4", 33, "Asus"));

        Optional.ofNullable(noteLst)
                .orElseGet(Collections::emptyList) // creates empty immutable list: [] in case noteLst is null
                .stream()
                .filter(Objects::nonNull) //loop throgh each object and consider non null objects
                .map(Notes::getTagName) // method reference, consider only tag name
                .forEach(System.out::println); // it will print tag names

    }
}
