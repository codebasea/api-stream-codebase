package api.file.operation;

public class GetFileExtension {
    public static void main(String[] args) {
        getFileExt();
    }

    public static void getFileExt() {
        String extension = "null";
        String fileName = "file.txt";
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i + 1);
        }
        System.out.println(extension);
    }
}

