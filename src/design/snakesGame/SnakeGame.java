package design.snakesGame;

import java.util.HashSet;
import java.util.Set;

public class SnakeGame {
    private int[][] board;
    private int h;
    private int w;
    private int[][] f;
    private int fIndex;

    private int xHead;
    private int yHead;

    private SnakeBody snake;

    private int score;

    public static void main(String[] str) {
        // SnakeGame sol = new SnakeGame(2,2,new int[][]{{0,1}});
        SnakeGame sol = new SnakeGame(3,3,new int[][]{{2,0},{0,0},{0,2},{2,2}});
        sol.move("D");
        sol.move("D");
        sol.move("R");
        sol.move("U");
        sol.move("U");
        sol.move("L");
        sol.move("D");
        sol.move("R");
        sol.move("R");
        sol.move("U");
        sol.move("L");
        sol.move("D");
    }

    public SnakeGame(int width, int height, int[][] food) {
        w = width;
        h = height;
        f = food;
        board = new int[h][w];
        fIndex = 0;
        xHead = 0;
        yHead = 0;
        snake = new SnakeBody();
        score = 0;
    }

    public int move(String direction) {
        boolean hasMoved = false;

        switch(direction) {
            case "R":
                if (yHead + 1 < w) {
                    if (fIndex < f.length && xHead == f[fIndex][0] && (yHead + 1) == f[fIndex][1]) {
                        fIndex++;
                        score++;
                        yHead += 1;
                        hasMoved = snake.moveTo(xHead, yHead, false);
                    } else {
                        yHead += 1;
                        hasMoved = snake.moveTo(xHead, yHead, true);
                    }
                } else {
                    return -1;
                }
                break;

            case "L":
                if (yHead - 1 >= 0) {
                    if (fIndex < f.length && xHead == f[fIndex][0] && (yHead - 1) == f[fIndex][1]) {
                        fIndex++;
                        score++;
                        yHead -= 1;
                        hasMoved = snake.moveTo(xHead, yHead, false);
                    } else {
                        yHead -= 1;
                        hasMoved = snake.moveTo(xHead, yHead, true);
                    }
                } else {
                    return -1;
                }
                break;

            case "U":
                if (xHead - 1 >= 0) {
                    if (fIndex < f.length && (xHead - 1) == f[fIndex][0] && yHead == f[fIndex][1]) {
                        fIndex++;
                        score++;
                        xHead -= 1;
                        hasMoved = snake.moveTo(xHead, yHead, false);
                    } else {
                        xHead -= 1;
                        hasMoved = snake.moveTo(xHead, yHead, true);
                    }
                } else {
                    return -1;
                }
                break;

            case "D":
                if (xHead + 1 < h) {
                    if (fIndex < f.length && (xHead + 1) == f[fIndex][0] && yHead == f[fIndex][1]) {
                        fIndex++;
                        score++;
                        xHead += 1;
                        hasMoved = snake.moveTo(xHead, yHead, false);
                    } else {
                        xHead += 1;
                        hasMoved = snake.moveTo(xHead, yHead, true);
                    }
                } else {
                    return -1;
                }
                break;
        }

        if (!hasMoved) {
            return -1;
        }

        return score;
    }
}

class SnakeBody {

    Pair head;
    Pair tail;

    Set<String> body = new HashSet<>();

    public SnakeBody() {
        head = new Pair(0, 0);
        tail = head;
        body.add(head.getString());
    }

    public boolean moveTo(int x, int y, boolean deleteTail) {
        if (deleteTail) {
            body.remove(tail.getString());

            Pair tmp = tail;
            tail = tail.prev;
            tmp.prev = null;
            tail.next = null;
        }

        if (body.contains(x + "" + y)) {
            return false;
        }

        Pair newHead = new Pair(x, y);
        head.prev = newHead;
        newHead.next = head;
        head = newHead;

        body.add(newHead.getString());

        return true;
    }
}

class Pair {
    int x;
    int y;

    Pair next;
    Pair prev;

    public Pair(int px, int py) {
        x = px;
        y = py;
    }

    public String getString() {
        return x + "" + y;
    }
}
