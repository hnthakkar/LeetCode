package educative.tripletsumclosest;

import java.util.*;

public class TripletSumClosest {

    public static int searchClosestTriplet(int[] arr, int target) {
        Arrays.sort(arr);

        int leftIndex = 0, rightIndex = arr.length - 1;
        int closestSum = Integer.MAX_VALUE;
        int currentClosetSum = Integer.MAX_VALUE;
        while(leftIndex + 1 < rightIndex) {
            currentClosetSum = arr[leftIndex] + arr[rightIndex] + getClosetElement(arr, leftIndex + 1, rightIndex - 1, target - arr[leftIndex] - arr[rightIndex]);
            if (Math.abs(currentClosetSum - target) < (Math.abs(closestSum - target))) {
                closestSum = currentClosetSum;
            }

            if (currentClosetSum < target) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        return closestSum;
    }

    public static int getClosetElement(int[] arr, int startIndex, int endIndex, int target) {
        if (arr[startIndex] == target) {
            return arr[startIndex];
        }

        if (arr[endIndex] == target) {
            return arr[endIndex];
        }

        if (startIndex + 1 >= endIndex) {
            if (Math.abs(target - arr[startIndex]) < Math.abs(target - arr[endIndex])) {
                return arr[startIndex];
            } else {
                return arr[endIndex];
            }
        }

        int mid = startIndex + (endIndex - startIndex)/2;

        if (arr[mid] == target) {
            return arr[mid];
        } else if (arr[mid] > target) {
            return getClosetElement(arr, startIndex, mid - 1, target);
        } else {
            return getClosetElement(arr, mid + 1, endIndex, target);
        }
    }

    public static void main(String[] args) {
        System.out.println(TripletSumClosest.searchClosestTriplet(new int[] { -2, 0, 1, 2 }, 2));
        System.out.println(TripletSumClosest.searchClosestTriplet(new int[] { -3, -1, 1, 2 }, 1));
        System.out.println(TripletSumClosest.searchClosestTriplet(new int[] { 1, 0, 1, 1 }, 100));
    }
}
