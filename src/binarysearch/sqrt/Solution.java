package binarysearch.sqrt;

public class Solution {

    public static void main(String[]args){
        Solution obj = new Solution();
        obj.mySqrt(2147395599);
    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        long leftIndex = 0;
        long rightIndex = x;
        long squareRoot = 0;
        while (leftIndex <= rightIndex) {
            long mid = (leftIndex + rightIndex)/2;
            long midSquare = mid * mid;
            long midPlusOne = mid + 1;
            long midPlusOneSquare = midPlusOne * midPlusOne;
            if (midSquare == x || (midSquare < x && midPlusOneSquare > x)) {
                squareRoot = mid;
                break;
            } else if (midSquare > x) {
                rightIndex = mid;
            } else {
                leftIndex = mid + 1;
            }
        }

        return (int) squareRoot;
    }
}