package string.lastsubstringlexiorder;

public class EfficientSolution {
    public String lastSubstring(String s) {
        char[] inputs = s.toCharArray();
        int[] offsets = getHighestAlphabetOffsets(inputs);

        return s.substring(getLexiMaxSubString(offsets, inputs));
    }

    private int getLexiMaxSubString(int[] offsets, char[] inputs) {
        if (offsets.length == 1) {
            return offsets[0];
        }

        int maxOffsetIndex = offsets[0];

        for (int i = 1; i < offsets.length; i++) {
            maxOffsetIndex = getLexiMaxSubStringAmongTwo(maxOffsetIndex, offsets[i], inputs);
        }

        return maxOffsetIndex;
    }

    private int getLexiMaxSubStringAmongTwo(int offset1, int offset2, char[] inputs) {
        int currentOffset1 = offset1 + 1;
        int currentOffset2 = offset2 + 1;
        int lastIndex = inputs.length - 1;
        while (true) {
            if (currentOffset2 > lastIndex) {
                return offset1;
            }

            if (currentOffset1 > lastIndex) {
                return offset2;
            }

            if (inputs[currentOffset1] == inputs[currentOffset2]) {
                currentOffset1++;
                currentOffset2++;
            } else if (inputs[currentOffset1] > inputs[currentOffset2]) {
                return offset1;
            } else {
                return offset2;
            }
        }
    }

    private int[] getHighestAlphabetOffsets(char[] inputs) {
        int maxChar = (int) inputs[0];
        int maxCharCount = 1;

        for (char currentChar: inputs) {
            if (((int)currentChar) > maxChar) {
                maxChar = currentChar;
                maxCharCount = 1;
            } else if (currentChar == maxChar) {
                maxCharCount++;
            }
        }

        int[] offsets = new int[maxCharCount];
        int offsetIndex = 0;
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i] == maxChar) {
                offsets[offsetIndex++] = i;
            }
        }

        return offsets;
    }
}
