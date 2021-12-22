package design.fileSystem1166;

import java.util.HashMap;
import java.util.Map;

public class FileSystem {

    Map<String, Integer> fs;

    public static void main(String[] str) {
        FileSystem sol = new FileSystem();
        sol.createPath("/leet",1);
        sol.createPath("/leet/code",2);
        sol.get("/leet/code");
        sol.createPath("/c/d",1);
        sol.get("/c");
    }

    public FileSystem() {
        fs = new HashMap<>();
    }

    public boolean createPath(String path, int value) {
        if (fs.containsKey(path)) {
            return false;
        }

        if (!checkValidPath(path, fs)) {
            return false;
        }

        fs.put(path, value);
        return true;
    }

    private boolean checkValidPath(String path, Map<String, Integer> fs) {
        char[] pathArray = path.toCharArray();
        int len = pathArray.length;

        if (len == 0 || pathArray[0] != '/') {
            return false;
        }

        for (int i = 1; i < len; i++) {
            if (pathArray[i] != '/') {
                continue;
            }

            if (!fs.containsKey(new String(pathArray, 0, i))) {
                return false;
            }
        }

        return true;
    }

    public int get(String path) {
        if (!fs.containsKey(path)) {
            return -1;
        }

        return fs.get(path);
    }
}
