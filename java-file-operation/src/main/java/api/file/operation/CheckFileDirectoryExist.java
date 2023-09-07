package api.file.operation;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class CheckFileDirectoryExist {
    public static void main(String[] args) throws Exception {
//        isFileExist();
//        checkIsFileIsExist();
//        isDirectoryExist();
//        isPathDirectoryExist();
        permission0777();
//        setExecutable();
    }
    public static void isFileExist(){
            String filePath= "C:\\Drive_D\\codebase\\development\\api.stream.codebase\\java-file-operation" +
                    "\\src\\main\\java\\api\\file\\operation\\CheckFileDirectoryExist.java";
            File file = new File(filePath);
            boolean isexist = file.exists();
            if(isexist) {
                System.out.println("File is present");
            }else {
                System.out.println("File does not present");
            }

    }


    public static void checkIsFileIsExist(){
        String filePath= "C:\\Drive_D\\codebase\\development\\api.stream.codebase\\java-file-operation" +
                "\\src\\main\\java\\api\\file\\operation\\CheckFileDirectoryExist.java";
        File file = new File(filePath);
        boolean isExist = file.exists();  // Check for valid path
        boolean isFile  = file.isFile();  // Check for file
        if(isExist && isFile) {
            System.out.println("File is present");
        }else {
            System.out.println("File does not present");
        }

    }

    public static void isDirectoryExist(){
        String filePath= "C:\\Drive_D\\codebase\\development\\api.stream.codebase\\java-file-operation" +
                "\\src\\main\\java\\api\\file\\operation\\";
        File file = new File(filePath);
        boolean isDirectory  = file.isDirectory();  // Check for directory
        if(isDirectory) {
            System.out.println("It is a directory");
        }else {
            System.out.println("It is not directory");
        }
    }

    public static void isPathDirectoryExist(){
        String filePath= "C:\\Drive_D\\codebase\\development\\api.stream.codebase\\java-file-operation" +
                "\\src\\main\\java\\api\\file\\operation\\";
        Path path = Paths.get(filePath);
        boolean isDirectory  = Files.isDirectory(path);  // Check for directory
        if(isDirectory) {
            System.out.println("It is a directory");
        }else {
            System.out.println("It is not directory");
        }
    }


    public static void permission0777() throws Exception {
        Path path = Paths.get("c:/tmp/test-file.txt");
        String fileName = "c:/tmp/test-file.txt";
                if (!Files.exists(path)) Files.createFile(path);
        Map<String,Object> map;
        map = Files.readAttributes(path, "*");
        System.out.println(map);
//        if (!Files.exists(path)) Files.createFile(path);
//        Set<PosixFilePermission> perms = Files.readAttributes(path, PosixFileAttributes.class).permissions();

        Files.readAttributes(path, java.nio.file.attribute.PosixFileAttributes.class);

//
//        System.out.format("Permissions before: %s%n",  PosixFilePermissions.toString(perms));
//
//        perms.add(PosixFilePermission.OWNER_WRITE);
//        perms.add(PosixFilePermission.OWNER_READ);
//        perms.add(PosixFilePermission.OWNER_EXECUTE);
//        perms.add(PosixFilePermission.GROUP_WRITE);
//        perms.add(PosixFilePermission.GROUP_READ);
//        perms.add(PosixFilePermission.GROUP_EXECUTE);
//        perms.add(PosixFilePermission.OTHERS_WRITE);
//        perms.add(PosixFilePermission.OTHERS_READ);
//        perms.add(PosixFilePermission.OTHERS_EXECUTE);
//        Files.setPosixFilePermissions(path, perms);
//
//        System.out.format("Permissions after:  %s%n",  PosixFilePermissions.toString(perms));


//        final FileSystem fs = FileSystems.getDefault(); // <-- that's your filesystem
//        System.out.println(fs.supportedFileAttributeViews());
//        final FileSystem fs1 = MemoryFileSystemBuilder.newLinux()
//                .build(fileName);
//        System.out.println(fs1);
//
//        MoreFiles.setMode(somePath, 0644); // for instance

//        Files.setPosixFilePermissions(Path.of(fileName), PosixFilePermissions.fromString("-rw-r--r--"));

//        final File file = new File(fileName);
//        file.setReadable(true, false);
//        file.setExecutable(true, false);
//        file.setWritable(true, false);
//
//        file.createNewFile();


    }


}
