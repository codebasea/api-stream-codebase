package api.file.operation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;

public class SetFilePerm {
    public static void main(String[] args) throws IOException
    {
//        Path path = Paths.get("c:/tmp/test-file.txt");
        String fileName = "c:/tmp/test-file.txt";
        File file = new File(fileName);

        if(file.exists())
        {
            //Setting file permissions for owner, group and others using PosixFilePermission

            HashSet<PosixFilePermission> set = new HashSet<PosixFilePermission>();

            //Adding owner's file permissions

            set.add(PosixFilePermission.OWNER_EXECUTE);
            set.add(PosixFilePermission.OWNER_READ);
            set.add(PosixFilePermission.OWNER_WRITE);

            //Adding group's file permissions

            set.add(PosixFilePermission.GROUP_EXECUTE);
            set.add(PosixFilePermission.GROUP_READ);
            set.add(PosixFilePermission.GROUP_WRITE);

            //Adding other's file permissions

            set.add(PosixFilePermission.OTHERS_EXECUTE);
            set.add(PosixFilePermission.OTHERS_READ);
            set.add(PosixFilePermission.OTHERS_WRITE);

            Files.setPosixFilePermissions(Paths.get(fileName), set);
        }
        else
        {
            System.out.println("Sorry...File doesn't exist.");
        }
    }
}
