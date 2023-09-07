package common.code;

import java.io.File;
import java.io.FilePermission;
import java.io.IOException;

public class TestFileCreation {
    public static void main(String[] args) throws SecurityException, IOException {
        String file3= "C:\\Drive_D\\codebase\\development\\api.stream.codebase\\common-code\\src\\main\\java\\common\\code\\AAA.txt";

        File file = new File("C:\\Drive_D\\codebase\\development\\api.stream.codebase\\common-code\\src\\main\\java\\common\\code\\setExecuteTestQQQ.txt");
        file.createNewFile();
        file.setReadable(true); //read
        file.setWritable(true); //write
        file.setExecutable(true,false); //execute
//        if (file.exists()) {
//            boolean bval = file.setExecutable(true);
//            System.out.println("set the owner's execute permission: "+ bval);
//        } else {
//            System.out.println("File cannot exists: ");
//        }
//
//        if (file.exists()) {
//            boolean bval = file.setExecutable(true,false);
//            System.out.println("set the everybody execute permission: "+ bval);
//        } else {
//            System.out.println("File cannot exists: ");
//        }


        FilePermission filePermission = new FilePermission(file3,"write");











//String file2= "C:\\Drive_D\\codebase\\development\\api.stream.codebase\\common-code\\src\\main\\java\\common\\code\\setE222xecuteTestQQQ.txt";
//
//        Path path = Paths.get(file2); //creates Path instance
//        try {
//            Path p = Files.createFile(path); //creates file at specified location
//            System.out.println("File Created at Path: " + p);
//        }
//        catch(IOException e) {
//            System.out.println("Exception Occurred:");
//            e.printStackTrace();
//        }
    }
}
