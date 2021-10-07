package matrix.wordsearch79;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        // sol.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB");
        sol.exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}}, "ABCESEEEFS");
    }

    public boolean exist(char[][] board, String word) {
        char[] wordChar = word.toCharArray();
        int wordLen = wordChar.length;

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == wordChar[0] && checkForWord(board, rows, cols, i, j, wordChar, wordLen)) {
                    return true;
                }
            }
        }

        return false;
    }


    private boolean checkForWord(char[][] board, int rows, int cols, int startX, int startY, char[] wordChar, int wordLen) {
        if (wordLen == 1) {
            return true;
        }

        int[][] visited = new int[rows][cols];
        Queue<Pair> q = new LinkedList<>();
        visited[startX][startY] = 1;
        q.add(new Pair(startX, startY, visited, rows, cols));

        int wordIndex = 1;
        int wordMatchCounter = 1;

        while (!q.isEmpty() && wordMatchCounter < wordLen) {
            int size = q.size();
            boolean foundMatch = false;

            while (size > 0) {
                Pair cur = q.poll();

                // top
                if (cur.x > 0 && cur.visited[cur.x - 1][cur.y] != 1 && board[cur.x - 1][cur.y] == wordChar[wordIndex]) {
                    Pair toBeAdded = new Pair(cur.x - 1, cur.y, cur.visited, rows, cols);
                    toBeAdded.visited[cur.x - 1][cur.y] = 1;
                    q.add(toBeAdded);
                    foundMatch = true;
                }

                // down
                if (cur.x < (rows - 1) && cur.visited[cur.x + 1][cur.y] != 1 && board[cur.x + 1][cur.y] == wordChar[wordIndex]) {
                    Pair toBeAdded = new Pair(cur.x + 1, cur.y, cur.visited, rows, cols);
                    toBeAdded.visited[cur.x + 1][cur.y] = 1;
                    q.add(toBeAdded);
                    foundMatch = true;
                }

                // left
                if (cur.y > 0 && cur.visited[cur.x][cur.y - 1] != 1 && board[cur.x][cur.y - 1] == wordChar[wordIndex]) {
                    Pair toBeAdded = new Pair(cur.x, cur.y - 1, cur.visited, rows, cols);
                    toBeAdded.visited[cur.x][cur.y - 1] = 1;
                    q.add(toBeAdded);
                    foundMatch = true;
                }

                // right
                if (cur.y < (cols - 1) && cur.visited[cur.x][cur.y + 1] != 1 && board[cur.x][cur.y + 1] == wordChar[wordIndex]) {
                    Pair toBeAdded = new Pair(cur.x, cur.y + 1, cur.visited, rows, cols);
                    toBeAdded.visited[cur.x][cur.y + 1] = 1;
                    q.add(toBeAdded);
                    foundMatch = true;
                }

                size--;
            }

            if (foundMatch) {
                wordMatchCounter++;
                wordIndex++;
            }
        }

        return wordMatchCounter == wordLen;
    }

}

class Pair {
    int x, y;
    int[][] visited;

    public Pair(int pX, int pY, int[][] visitedMapForCurrentPath, int rows, int cols) {
        x = pX;
        y = pY;
        visited = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = visitedMapForCurrentPath[i][j];
            }
        }
    }
}

