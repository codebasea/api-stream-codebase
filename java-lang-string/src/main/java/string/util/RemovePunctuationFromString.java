package string.util;

public class RemovePunctuationFromString {

    public static void main(String[] args) {
        removePunct();
    }

    private static void removePunct(){
        String str = "?This String $% Contains$$ punctuation !!";
        str = str.replaceAll("\\p{Punct}","");
        System.out.println(str);
    }
}
