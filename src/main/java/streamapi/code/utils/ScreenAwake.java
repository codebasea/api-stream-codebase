package streamapi.code.utils;

import java.awt.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Random;

public class ScreenAwake {

    private static int sleepTime = -1;

    public static void main(String[] args) throws IOException {

        pointerToTheSameLocationV1();
//        pointerToTheSameLocation();
//        robotMouseMove();
//        toDisableTheScreenShuttingOff();
//        disableSleep();
    }

    public static void pointerToTheSameLocationV1() {
        try {
            Robot rob = new Robot();
            PointerInfo ptr = null;
            while (true) {
                rob.delay(4000);  // Mouse moves every 4 seconds
                ptr = MouseInfo.getPointerInfo();
                rob.mouseMove((int) ptr.getLocation().getX() + 1, (int) ptr.getLocation().getY() + 1);
            }
        } catch (AWTException e) {
            throw new RuntimeException(e);

        }
    }

    public static void pointerToTheSameLocation() {
        try {
            while (true) {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                System.out.println(timestamp);
                Thread.sleep(180000);//this is how long before it moves
                Point mouseLoc = MouseInfo.getPointerInfo().getLocation();
                Robot rob = new Robot();
                rob.mouseMove(mouseLoc.x, mouseLoc.y);
            }
        } catch (InterruptedException | AWTException e) {
            throw new RuntimeException(e);

        }
    }

    public static void toDisableTheScreenShuttingOff() {
        Robot hal = null;
        try {
            hal = new Robot();
            while (true) {
                hal.delay(1000 * 30);
                Point pObj = MouseInfo.getPointerInfo().getLocation();
                System.out.println(pObj.toString() + "x>>" + pObj.x + "  y>>" + pObj.y);
                hal.mouseMove(pObj.x + 1, pObj.y + 1);
                hal.mouseMove(pObj.x - 1, pObj.y - 1);
                pObj = MouseInfo.getPointerInfo().getLocation();
                System.out.println(pObj.toString() + "x>>" + pObj.x + "  y>>" + pObj.y);
            }
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

    }

    public static void robotMouseMove() {
        Robot hal = null;
        try {
            hal = new Robot();
            Random random = new Random();
            while (true) {
                hal.delay(1000 * 60);
                int x = random.nextInt() % 640;
                int y = random.nextInt() % 480;
                hal.mouseMove(x, y);
            }
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

    }

    public static void disableSleep() throws IOException {
        if (sleepTime != -1) {
            // sleep time is already recorded, assume sleep is disabled
            return;
        }

        // query pmset for the current setting
        Process proc = Runtime.getRuntime().exec("pmset -g");
        BufferedInputStream is = new BufferedInputStream(proc.getInputStream());
        StringBuffer output = new StringBuffer();
        int c;
        while ((c = is.read()) != -1) {
            output.append((char) c);
        }
        is.close();

        // parse the current setting and store the sleep time
        String outString = output.toString();
        String setting = outString.substring(outString.indexOf(" sleep\t")).trim();
        setting = setting.substring(7, setting.indexOf(" ")).trim();
        sleepTime = Integer.parseInt(setting);

        // set the sleep time to zero (disable sleep)
        Runtime.getRuntime().exec("pmset sleep 0");
    }

    public void enableSleep() throws IOException {
        if (sleepTime == -1) {
            // sleep time is not recorded, assume sleep is enabled
            return;
        }

        // set the sleep time to the previously stored value
        Runtime.getRuntime().exec("pmset sleep " + sleepTime);

        // reset the stored sleep time
        sleepTime = -1;
    }
}
