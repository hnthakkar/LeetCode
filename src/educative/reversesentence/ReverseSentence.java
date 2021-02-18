package educative.reversesentence;

public class ReverseSentence {

    public static void main(String[] args) {
        char[] input = "Hello World".toCharArray();
        reverseWords(input);
        System.out.print(String.valueOf(input));
    }

    public static void reverseWords (char[] sentence) {
        reverse(sentence, 0, sentence.length - 1);

        int lastIndex = sentence.length - 1;
        int index = 0;
        int startIndex = 0;
        int endIndex;

        while (index < lastIndex) {
            startIndex = index;
            endIndex = index;
            while (index < lastIndex && sentence[index] != ' ') {
                index++;
            }
            if (index < lastIndex) {
                endIndex = index - 1;
            } else {
                endIndex = lastIndex;
            }

            reverse(sentence, startIndex, endIndex);
            index++;
        }
    }

    private static void reverse(char[] sentence, int startIndex, int endIndex) {
        char tmp = '\u0000';
        while (startIndex < endIndex) {
            tmp = sentence[startIndex];
            sentence[startIndex] = sentence[endIndex];
            sentence[endIndex] = tmp;
            startIndex++;
            endIndex--;
        }
    }
}
