package api.file.operation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileAndDirectory1 {
    public static void main(String[] args) throws IOException {
        setFileAttributes();
    }/*{
        String fileName = "c:/tmp/test-file5.txt";
        File file = new File(fileName);
        System.out.println(file.getAbsoluteFile());

        Path path2 = Paths.get(fileName);
        Files.setPosixFilePermissions(path2, PosixFilePermissions.fromString("rwxrwxrwx"));
        System.out.println(path2);




        try {
            //file.createNewFile();
            if(!file.exists())
            {
                //PosixFilePermission is an enum class, PosixFilePermissions is a final class

                //create file permissions from string
                Set<PosixFilePermission> filePermissions = PosixFilePermissions.fromString("---------"*//* "rwxrwxrwx" *//*);
                FileAttribute<?> permissions = PosixFilePermissions.asFileAttribute(filePermissions);
                Files.createFile(file.toPath(), permissions);
                // printing the permissions associated with the file
                System.out.println("Executable: " + file.canExecute());
                System.out.println("Readable: " + file.canRead());
                System.out.println("Writable: "+ file.canWrite());

                file.setExecutable(true);
                file.setReadable(true);
                file.setWritable(true);
            }
            else
            {
                //modify permissions

                //get the permission using file attributes
                Set<PosixFilePermission> perms = Files.readAttributes(file.toPath(), PosixFileAttributes.class).permissions();
                perms.remove(PosixFilePermission.OWNER_WRITE);

                perms.add(PosixFilePermission.OWNER_READ);
                perms.add(PosixFilePermission.OWNER_EXECUTE);
                perms.add(PosixFilePermission.GROUP_WRITE);
                perms.add(PosixFilePermission.GROUP_READ);
                perms.add(PosixFilePermission.GROUP_EXECUTE);
                perms.add(PosixFilePermission.OTHERS_WRITE);
                perms.add(PosixFilePermission.OTHERS_READ);
                perms.add(PosixFilePermission.OTHERS_EXECUTE);
                Files.setPosixFilePermissions(file.toPath(), perms);

                System.out.println("Executable: " + file.canExecute());
                System.out.println("Readable: " + file.canRead());
                System.out.println("Writable: "+ file.canWrite());

                file.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path path = Paths.get(String.valueOf(file));
        System.out.println(path);
    }*/

    public static void setFileAttributes() throws IOException {
        String fileName = "c:/tmp/test-file3.txt";
        Path path = Paths.get(fileName);

        final File file = new File(fileName);
//        file.setReadable(true, false);
//        file.setExecutable(true, false);
//        file.setWritable(true, false);
        file.setReadable(true);
        file.setExecutable(true);
        file.setWritable(true);

        file.createNewFile();
//        Runtime.getRuntime().exec("chmod 777 file");
    }
}