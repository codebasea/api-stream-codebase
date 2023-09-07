package string.util;

public class IndexOfSpecifiedSubstring {
    public static void main(String[] args) {
        findStringInword();
    }
    public static void findStringInword(){
        String str = "This sentance contains find me string";
        System.out.println(str);
        // find word in String
        String find = "find me";
        int i = str.indexOf(find);
        System.out.println("Position "+i);
        System.out.println("ind.length "+find.length());
        if(i>0)
            System.out.println(str.substring(i, i+find.length()));
        else
            System.out.println("string not found");
    }
}
