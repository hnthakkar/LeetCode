package string.equivalent;

public class Solution {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuffer sb1 = new StringBuffer();
        for (String st1: word1) {
            sb1.append(st1);
        }

        StringBuffer sb2 = new StringBuffer();
        for (String st2: word2) {
            sb2.append(st2);
        }

        if(sb1.toString().equals(sb2.toString())) {
            return true;
        }

        return false;
    }
}
