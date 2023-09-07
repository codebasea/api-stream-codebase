package common.code;

import java.io.File;
import java.io.FilePermission;
import java.io.IOException;

public class StudyTonight {

    public static void main(String args[]) throws IOException {
        String file2= "C:\\Drive_D\\codebase\\development\\api.stream.codebase\\common-code\\src\\main\\java\\common\\code\\AA.txt";
        File file = new File(file2);
        file.createNewFile();
        FilePermission fp_obj = new FilePermission(file2, "read, execute, write");
        System.out.print("File permissions for myfile.txt: "+fp_obj.getActions());

    }
}
