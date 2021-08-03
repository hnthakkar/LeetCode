package array.reorderdatalogs;

public class Solution {


    public static void main(String[] args) {
        Solution obj = new Solution();
        obj.reorderLogFiles(new String[]{"1 n u", "r 527", "j 893", "6 14", "6 82"});
    }

    public String[] reorderLogFiles(String[] logs) {
        int len = logs.length;
        int digiItemCounts = sortDigitLogs(logs, len);
        sortLetterLogs(0, len - digiItemCounts -1, logs);
        return logs;
    }

    private void sortLetterLogs(int startIndex, int endIndex, String[] logs) {
        if (startIndex < endIndex) {
            int mid = startIndex + (endIndex - startIndex)/2;
            sortLetterLogs(startIndex, mid, logs);
            sortLetterLogs(mid + 1, endIndex, logs);
            mergeSortedItems(startIndex, mid, endIndex, logs);
        }
    }

    private void mergeSortedItems(int startIndex, int midIndex, int endIndex, String[] logs) {
        int lenOfFirstArray = midIndex - startIndex + 1;
        int lenOfSecondArray = endIndex - midIndex;

        String[] firstArray = new String[lenOfFirstArray];
        String[] secondArray = new String[lenOfSecondArray];

        for (int i = 0; i < lenOfFirstArray; i++) {
            firstArray[i] = logs[startIndex + i];
        }

        for (int i = 0; i < lenOfSecondArray; i++) {
            secondArray[i] = logs[midIndex + 1 + i];
        }

        int firstArrayIndex = 0, secondArrayIndex = 0;
        int currentIndex = startIndex;

        while (firstArrayIndex < lenOfFirstArray && secondArrayIndex < lenOfSecondArray) {
            String[] firstArrayItems = firstArray[firstArrayIndex].split(" ", 2);
            String[] secondArrayItems = secondArray[secondArrayIndex].split(" ", 2);
            int compareResult = firstArrayItems[1].compareTo(secondArrayItems[1]);
            if (compareResult < 0) {
                logs[currentIndex++] = firstArray[firstArrayIndex++];
            } else if (compareResult > 0) {
                logs[currentIndex++] = secondArray[secondArrayIndex++];
            } else {
                if (firstArrayItems[0].compareTo(secondArrayItems[0]) <= 0) {
                    logs[currentIndex++] = firstArray[firstArrayIndex++];
                } else {
                    logs[currentIndex++] = secondArray[secondArrayIndex++];
                }
            }
        }

        while (firstArrayIndex < lenOfFirstArray) {
            logs[currentIndex++] = firstArray[firstArrayIndex++];
        }

        while (secondArrayIndex < lenOfSecondArray) {
            logs[currentIndex++] = secondArray[secondArrayIndex++];
        }

    }

    private int sortDigitLogs(String[] logs, int len) {
        int currentIndex = len - 1;
        int indexToBeReplaced = len - 1;
        int numberOfDigiItems = 0;

        while (currentIndex >= 0) {
            if (!isDigitLog(logs[currentIndex])) {
                currentIndex--;
                continue;
            } else {
                numberOfDigiItems++;
            }

            while(indexToBeReplaced > currentIndex && isDigitLog(logs[indexToBeReplaced])) {
                indexToBeReplaced--;
            }

            if (currentIndex < indexToBeReplaced) {
                String tmp = logs[currentIndex];
                logs[currentIndex] = logs[indexToBeReplaced];
                logs[indexToBeReplaced] = tmp;
            }

            currentIndex--;
        }

        return numberOfDigiItems;
    }

    private boolean isDigitLog(String input) {
        return input.split(" ")[1].matches("\\d+");
    }
}
