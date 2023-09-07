package string.util;

public class JoinString {
    public static void main(String[] args){
        joinText();
    }

    private static void joinText() {

        String str1 = "Mango";
        String str2 = "Orange";
        String str3 = "Apple";
        // Join all strings
        String str = String.join("-", str1, str2, str3);
         System.out.println(str);
        System.out.println(str.getClass().getName());

    }
}
