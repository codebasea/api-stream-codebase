package api.file.operation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ReadingCSVFileFromUrl {
    public static void main(String[] args) throws IOException {

        URL url = new URL("https://reqres.in/api/users?page=2");
        URLConnection connection = url.openConnection();

        InputStreamReader input = new InputStreamReader(connection.getInputStream());
        BufferedReader buffer = null;
        String line = "";
        String csvSplitBy = ",";

        try {

            buffer = new BufferedReader(input);
            while ((line = buffer.readLine()) != null) {
                String[] room = line.split(csvSplitBy);
                System.out.println(line);
                System.out.println("room [capacity =" + room[0] + " , price=" + room[1]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
