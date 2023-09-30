package streamapi.code.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

    public class GrantFilePermission {
        public static void main(String[] args) {
            System.out.println(OPERATING_SYSTEM);
            String fileName = "C:\\Drive_D\\codebase\\development\\api-stream-codebase\\src\\main\\resources\\mock\\11164KB.json";
            File file = new File(fileName);
        }
        private static String OPERATING_SYSTEM = System.getProperty("os.name").toLowerCase();

        public static boolean givePerms(File f, Set<PosixFilePermission> perms, boolean recursive) {
            boolean success = givePerm(f, perms);
            if (f.isDirectory() && recursive) {
                File[] files = f.listFiles();
                for (File file : files) {
                    if (!givePerms(file, perms, recursive)) {
                        success = false;
                    }
                }
            }
            return success;
        }

        public static boolean givePerms(File f, String perms, boolean recursive) {
            return givePerms(f, PosixFilePermissions.fromString(perms), recursive);
        }


        public static boolean givePerms(File f, boolean recursive) {
            return givePerms(f, "rwxrwxrwx", recursive);
        }

        private static boolean givePerm(File f, Set<PosixFilePermission> perms) {
            try {
                Path p = Paths.get(f.toURI());
                if (OPERATING_SYSTEM.indexOf("win") >= 0) {
                    // just set writable on windows I guess...
                    p.toFile().setWritable(true);
                } else {
                    Files.setPosixFilePermissions(p, perms);
                }
            } catch (IOException e) {
                System.err.printf("Could not set permissions '%s' to %s\n", perms, f.toString());
                return false;
            }
            return true;
        }
    }
