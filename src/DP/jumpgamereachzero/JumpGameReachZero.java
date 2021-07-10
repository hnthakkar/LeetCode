package DP.jumpgamereachzero;

import DP.jumpgame.JumpGame;

public class JumpGameReachZero {

    public static void main(String[] args) {
        JumpGameReachZero jg = new JumpGameReachZero();
        jg.canReach(new int[]{4,2,3,0,3,1,2}, 5);
    }

    public boolean canReach(int[] arr, int start) {
        int n = arr.length;

        if (arr[start] == 0) {
            return true;
        }

        if (n == 1) {
            return false;
        }

        // Can have only three values
        // 0 --> still not calculated
        // 1 --> true
        // 2 -- false
        int[] canReachEndFromHere = new int[n];
        boolean result = canReach(arr, start, canReachEndFromHere, n);
        return result;
    }

    private boolean canReach(int[] arr, int start, int[] canReachEndFromHere, int n) {
        if (start < 0 || start >= n) {
            return false;
        }

        if (arr[start] == 0) {
            return true;
        }

        canReachEndFromHere[start] = 2;

        boolean canReachFromPrev = false;
        if (start - arr[start] >= 0) {
            if (canReachEndFromHere[start - arr[start]] == 0) {
                canReachFromPrev = canReach(arr, start - arr[start], canReachEndFromHere, n);
                if (!canReachFromPrev) {
                    canReachEndFromHere[start - arr[start]] = 2;
                }
            }
        }

        boolean canReachFromNext = false;
        if (start + arr[start] < n) {
            if (canReachEndFromHere[start + arr[start]] == 0) {
                canReachFromNext = canReach(arr, start + arr[start], canReachEndFromHere, n);
                if (!canReachFromNext) {
                    canReachEndFromHere[start - arr[start]] = 2;
                }
            }
        }

        return canReachFromPrev || canReachFromNext;
    }

}
