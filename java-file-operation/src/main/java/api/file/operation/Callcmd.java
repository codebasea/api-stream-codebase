package api.file.operation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Callcmd {
    public static void main(String[] args) {

        pingLocal();
//        testPingLocal();
/*        try {
//            String[] command={"cmd", "/k","start","ping 192.168.10.9" };
            String[] command = {"cmd", "/k", "start", "ping 127.0.0.1"};
            Process process = Runtime.getRuntime().exec(command);
            System.out.println(process);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }


    private static void pingLocal() {
        try {
            String[] command = { "cmd", "/k", "start", "ping", "localhost" };
            Process process = Runtime.getRuntime().exec(command);
            System.out.println(process);
        } catch (IOException e) {
            e.printStackTrace();
    }
    }
    private static void testPingLocal() {
        try {
            String[] command = {"ping", "localhost"};
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = input.readLine()) != null) {
                System.out.println("Command output: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
