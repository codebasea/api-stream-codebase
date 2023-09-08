package streamapi.code.filesapi;

public class CheckStringContainsInString {
    public static void main(String[] args) {
        String string = "https://microsoftedge.github.io/Demos/json-dummy-data/64KB.json";
        String substring = "https://";
        System.out.println(string.contains(substring));
    }
}
