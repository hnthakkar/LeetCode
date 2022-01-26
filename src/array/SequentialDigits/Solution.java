package array.SequentialDigits;

import java.util.*;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.sequentialDigits(100, 100000);
    }

    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> q = new LinkedList<>();
        int curQValue = 0;

        int lastDigitAdded = low;

        while (lastDigitAdded > 0) {
            if (lastDigitAdded < 10) {
                break;
            }

            lastDigitAdded /= 10;
        }

        curQValue = lastDigitAdded;
        q.add(lastDigitAdded);

        List<Integer> result = new ArrayList<>();

        while (!q.isEmpty()) {
            if (curQValue >= low && curQValue <= high) {
                if (result.contains(curQValue)) {
                    curQValue = curQValue * 10 + ++lastDigitAdded;
                    q.add(lastDigitAdded);
                    if (curQValue > high) {
                        break;
                    }
                }

                result.add(curQValue);

                q.poll();
                curQValue = curQValue % (int) Math.pow(10, q.size());
            } else if (curQValue < low) {
                if (lastDigitAdded < 9) {
                    q.add(lastDigitAdded + 1);
                    curQValue = curQValue * 10 + (lastDigitAdded + 1);

                    if (curQValue > high) {
                        break;
                    }

                    lastDigitAdded += 1;
                } else {
                    int size = 0;
                    while (!q.isEmpty()) {
                        q.poll();
                        size++;
                    }

                    lastDigitAdded = 1;
                    q.add(lastDigitAdded);
                    curQValue = 1;
                    while ((size + 1) > 0) {
                        q.add(++lastDigitAdded);
                        curQValue = curQValue * 10 + lastDigitAdded;
                        size--;
                    }
                }
            } else {
                q.poll();
                curQValue = curQValue % (int) Math.pow(10, q.size());
            }
        }

        return result;
    }
}
