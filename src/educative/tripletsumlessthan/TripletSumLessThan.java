package educative.tripletsumlessthan;

import java.util.*;

public class TripletSumLessThan {

    public static int searchTriplets(int[] arr, int target) {
        List<List<Integer>> finalTriplets = new ArrayList<>();
        Arrays.sort(arr);

        Set<String> alreadyAdded = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            List<List<Integer>> listIncludingCurrent = getTriplets(arr, i, target - arr[i]);
            for (List<Integer> triplet: listIncludingCurrent) {
                String tripletString = "" + triplet.get(0) + triplet.get(1) + triplet.get(2);
                if (!alreadyAdded.contains(tripletString)) {
                    finalTriplets.add(triplet);
                    alreadyAdded.add(tripletString);
                }
            }
        }

        return finalTriplets.size();
    }

    private static List<List<Integer>> getTriplets(int[] arr, int excludeIndex, int target) {
        List<List<Integer>> triplets = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = arr.length - 1;

        while (leftIndex < rightIndex) {
            if (leftIndex == excludeIndex) {
                leftIndex++;
                continue;
            }

            if (rightIndex == excludeIndex) {
                rightIndex--;
                continue;
            }

            if (arr[leftIndex] + arr[rightIndex] < target) {
                addTriplet(arr, triplets, leftIndex, excludeIndex, rightIndex);
                int tmpRightIndex = rightIndex - 1;
                while (leftIndex < tmpRightIndex && arr[leftIndex] + arr[tmpRightIndex] < target) {
                    if (tmpRightIndex == excludeIndex) {
                        tmpRightIndex--;
                        continue;
                    }
                    addTriplet(arr, triplets, leftIndex, excludeIndex, tmpRightIndex--);
                }
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return triplets;
    }

    private static void addTriplet(int[] arr, List<List<Integer>> triplets, int first, int second, int third) {
        List<Integer> triplet = new ArrayList<>();
        triplet.add(arr[first]);
        triplet.add(arr[second]);
        triplet.add(arr[third]);
        Collections.sort(triplet);
        triplets.add(triplet);
    }

    public static void main(String[] args) {
        System.out.println(TripletSumLessThan.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(TripletSumLessThan.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
    }

}
