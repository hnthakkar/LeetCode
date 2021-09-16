package string.backspacestrcompare;

public class Solution {

    public boolean backspaceCompare(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        //System.out.println("S1 : " + afterBackSpace(sArray));
        //System.out.println("S2 : " + afterBackSpace(tArray));

        return afterBackSpace(sArray).equals(afterBackSpace(tArray));
    }

    private String afterBackSpace(char[] arr) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            if (arr[i] == '#') {
                arr[i] = ' ';
                if (i > 0) {
                    int j = i -1;
                    while(j > 0 && arr[j] == ' ') {
                        j--;
                    }
                    arr[j] = ' ';
                }
            }
        }

        return String.valueOf(arr).replaceAll(" ", "").trim();
    }

}
