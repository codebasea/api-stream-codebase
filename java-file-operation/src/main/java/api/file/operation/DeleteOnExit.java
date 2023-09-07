package api.file.operation;

import java.io.File;

public class DeleteOnExit {

    public static void main(String[] args){
        try {
            String filePath = "C:\\Drive_D\\codebase\\development\\api.stream.codebase\\" +
                    "java-file-operation\\src\\main\\resources\\temp\\";
            File file = new File(filePath);
            // Delete file while exit
            file.deleteOnExit();
        }catch(Exception e) {
            System.out.println(e);
        }
    }
}
