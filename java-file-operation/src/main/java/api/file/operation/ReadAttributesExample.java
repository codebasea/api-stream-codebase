package api.file.operation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

public class ReadAttributesExample {
    public static void main(String... args) throws IOException {
        String perm = "rwxrwx---";// in octal = 770

        String fileName = "c:/tmp/test-file3.txt";
        Path path = Paths.get(fileName);
//        if (!Files.exists(path)) Files.createFile(path);

//        Set<PosixFilePermission> ownerWritable = PosixFilePermissions.fromString("rw-r--r--");
//        FileAttribute<?> permissions = PosixFilePermissions.asFileAttribute(ownerWritable);
//        Files.createFile(path, permissions);


        fileName = "c:/tmp/test-file4.txt";
        File file = new File(fileName);
        file.createNewFile();
//        setPermission(file);

//        Set<PosixFilePermission> perms = new HashSet<>();
//        perms.add(PosixFilePermission.OWNER_READ);
//        perms.add(PosixFilePermission.OWNER_WRITE);
//
//        Files.setPosixFilePermissions(file.toPath(), perms);



//        Chmod chmod = new Chmod();
//        chmod.setProject(new Project());
//        FileSet mySet = new FileSet();
//        mySet.setDir(new File("/my/path"));
//        mySet.setIncludes("**");
//        chmod.addFileset(mySet);
//        chmod.setPerm("+w");
//        chmod.setType(new FileDirBoth());
//        chmod.execute();

    }

    public static  void setPermission(File file) throws IOException{
        Set<PosixFilePermission> perms = new HashSet<>();
        perms.add(PosixFilePermission.OWNER_READ);
        perms.add(PosixFilePermission.OWNER_WRITE);
        perms.add(PosixFilePermission.OWNER_EXECUTE);

        perms.add(PosixFilePermission.OTHERS_READ);
        perms.add(PosixFilePermission.OTHERS_WRITE);
        perms.add(PosixFilePermission.OTHERS_EXECUTE);

        perms.add(PosixFilePermission.GROUP_READ);
        perms.add(PosixFilePermission.GROUP_WRITE);
        perms.add(PosixFilePermission.GROUP_EXECUTE);

        Files.setPosixFilePermissions(file.toPath(), perms);
    }
}
