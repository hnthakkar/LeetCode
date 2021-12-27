package array.crawlerLogFolder;

public class Solution {

    public int minOperations(String[] logs) {
        int distance = 0;

        for (int i = 0; i < logs.length; i++) {
            if (logs[i].equals("../")) {
                if (distance == 0) {
                    continue;
                } else {
                    distance -= 1;
                }
            } else if (logs[i].equals("./")) {
                continue;
            } else {
                distance += 1;
            }
        }

        return Math.abs(distance);
    }
}
