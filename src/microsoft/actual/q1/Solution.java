package microsoft.actual.q1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.solution(1, 3, 1);
    }

    public String solution(int A, int B, int C) {
        CharInfo aInfo = new CharInfo('a', A);
        CharInfo bInfo = new CharInfo('b', B);
        CharInfo cInfo = new CharInfo('c', C);

        PriorityQueue<CharInfo> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
        pq.add(aInfo);
        pq.add(bInfo);
        pq.add(cInfo);

        StringBuilder sb = new StringBuilder();
        char prevChar = '0';

        CharInfo top = pq.poll();

        while (top.count > 0) {
            if (prevChar == top.ch) {
                CharInfo second = pq.poll();

                if (second.count <= 0) {
                    break;
                }

                sb.append(second.ch);
                second.count -= 1;
                pq.add(second);
            }

            if (top.count > 1) {
                sb.append(top.ch).append(top.ch);
                top.count -= 2;
            } else {
                sb.append(top.ch);
                top.count -= 1;
            }

            pq.add(top);
            prevChar = top.ch;

            top = pq.poll();
        }

        return sb.toString();
    }

    /*public String solution(int A, int B, int C) {
        int prevChar = 0;
        // 1 - > A, 2 - > B, 3 - > C

        String result = "";

        while (A > 0 || B > 0 || C > 0) {
            int[] largestSeq = returnLargest(A, B, C);
            int largest = largestSeq[2];

            if (largest == 0) {
                break;
            }

            if (A == largest) {
                if (prevChar == 1) {
                    int secondLargest = largestSeq[1];
                    if (secondLargest == 0) {
                        break;
                    }

                    if (B == secondLargest) {
                        result += "b";
                        B -= 1;
                    } else {
                        result += "c";
                        C -= 1;
                    }
                }

                if (A >= 2) {
                    result += "aa";
                    A -= 2;
                } else {
                    result += "a";
                    A -= 1;
                }

                prevChar = 1;
                continue;
            }

            if (B == largest) {
                if (prevChar == 2) {
                    int secondLargest = largestSeq[1];
                    if (secondLargest == 0) {
                        break;
                    }

                    if (A == secondLargest) {
                        result += "a";
                        A -= 1;
                    } else {
                        result += "c";
                        C -= 1;
                    }
                }

                if (B >= 2) {
                    result += "bb";
                    B -= 2;
                } else {
                    result += "b";
                    B -= 1;
                }

                prevChar = 2;
                continue;
            }

            if (C == largest) {
                if (prevChar == 3) {
                    int secondLargest = largestSeq[1];
                    if (secondLargest == 0) {
                        break;
                    }

                    if (A == secondLargest) {
                        result += "a";
                        A -= 1;
                    } else {
                        result += "b";
                        B -= 1;
                    }
                }

                if (C >= 2) {
                    result += "cc";
                    C -= 2;
                } else {
                    result += "c";
                    C -= 1;
                }

                prevChar = 3;
                continue;
            }

        }

        return result;
    }

    private int[] returnLargest (int A, int B, int C) {
        int[] counters = new int[3];
        counters[0] = A;
        counters[1] = B;
        counters[2] = C;

        Arrays.sort(counters);

        return counters;
    }*/
}

class CharInfo {

    char ch;
    int count;

    public CharInfo(char pCh, int pCount) {
        ch = pCh;
        count = pCount;
    }
}