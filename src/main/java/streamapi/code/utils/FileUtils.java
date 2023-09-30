package streamapi.code.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

public class FileUtils {
    public static void main(String[] args) throws IOException {

        String fileName = "C:\\Drive_D\\codebase\\development\\api-stream-codebase\\src\\main\\resources\\mock\\e4KB.json";
        System.out.println(Runtime.getRuntime().exec("attrib -r "+fileName));
        File file = new File(fileName);
        setFilePermissionsTo600V2(file);
    }
    public static void setFilePermissionsTo600V2(File file) throws IOException {
//        Windows unfortunatelly doesn't support POSIX file systems so this is why your code doesn't work. In order to create a directory in Windows you should use:

        new File("/path/to/folder").mkdir();
//        File file = new File("file4.txt");
        file.createNewFile();

        Set<PosixFilePermission> perms = new HashSet<>();
        perms.add(PosixFilePermission.OWNER_READ);
        perms.add(PosixFilePermission.OWNER_WRITE);

        Files.setPosixFilePermissions(file.toPath(), perms);
    }
    public static void setFilePermissionsTo600(File file) throws IOException {
        file.createNewFile();
        file.setExecutable(true, false);
        file.setReadable(true, false);
        file.setWritable(true, false);

    }
}
