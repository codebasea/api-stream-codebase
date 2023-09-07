package string.util;

public class NestedTernaryOperator {
    public static void main(String args[])
    {
        int marks = 65;
        char grade;

        grade = (marks >= 90) ? 'A'
                :(marks < 90 && marks >= 50) ? 'B'
                :'C';

        System.out.print(grade);
    }
}
