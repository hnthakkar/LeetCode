package array.maxnumber69;

public class MaxNumber69 {

    public static void main(String[] args) {
        MaxNumber69 obj = new MaxNumber69();
        obj.maximum69Number(9669);
    }

    public int maximum69Number (int num) {
        String numStr = num + "";
        char[] numChars = numStr.toCharArray();

        for (int i = 0; i < numChars.length; i++) {
            if (numChars[i] == '6') {
                numChars[i] = '9';
                break;
            }
        }

        return Integer.parseInt(String.valueOf(numChars));
    }

}

