package streamapi.code.streamapp;

import java.util.Arrays;

public class FindMaxElement {
    public static void main(String[] args) {
        int [] ints = {12,19,20,88,00,9};
        findMaxElement(ints);
        System.out.println(findMaxElement(ints));
    }

    public static int findMaxElement(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }

}
