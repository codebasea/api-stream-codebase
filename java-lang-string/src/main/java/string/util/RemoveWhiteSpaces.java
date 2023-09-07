package string.util;

public class RemoveWhiteSpaces {
    public static void main(String[] args) {
        removeWhiteSpaces();
    }
    private static void removeWhiteSpaces(){
        String str = "   Studytonight";
        String newStr = str.strip();
        System.out.println("#"+newStr+"#");

    }
}
