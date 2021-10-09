package matrix.wordsearch212;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] board = new char[][] {{'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}};
        String[] words = new String[] {"oath","pea","eat","rain"};

        sol.findWords(board, words);
    }

    public List<String> findWords(char[][] board, String[] words) {
        int rows = board.length;
        int cols = board[0].length;

        int len = words.length;

        List<String> result = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            char[] wordArray = words[i].toCharArray();
            boolean found = false;

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (board[r][c] == wordArray[0] && checkForWord(board, rows, cols, r, c, wordArray, 0, wordArray.length)) {
                        result.add(words[i]);
                        found = true;
                        break;
                    }
                }

                if (found) {
                    break;
                }
            }
        }

        return result;
    }

    private boolean checkForWord(char[][] board, int rows, int cols, int curRow, int curCol, char[] wordArray, int currentIndex, int wordLen) {
        if (currentIndex >= wordLen) {
            return true;
        }

        if (curRow < 0 || curCol < 0 || curRow >= rows || curCol >= cols) {
            return false;
        }

        if (board[curRow][curCol] != wordArray[currentIndex]) {
            return false;
        }

        board[curRow][curCol] = '*';

        // top
        boolean topMove = checkForWord(board, rows, cols, curRow - 1, curCol, wordArray, currentIndex + 1, wordLen);

        // down
        boolean downMove = checkForWord(board, rows, cols, curRow + 1, curCol, wordArray, currentIndex + 1, wordLen);

        // left
        boolean leftMove = checkForWord(board, rows, cols, curRow, curCol - 1, wordArray, currentIndex + 1, wordLen);

        // right
        boolean rightMove = checkForWord(board, rows, cols, curRow, curCol + 1, wordArray, currentIndex + 1, wordLen);

        board[curRow][curCol] = wordArray[currentIndex];

        return topMove || downMove || leftMove || rightMove;
    }
}
