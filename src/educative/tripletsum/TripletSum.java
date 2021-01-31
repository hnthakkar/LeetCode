package educative.tripletsum;

import java.util.*;

public class TripletSum {

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);

        Map<Integer, List<Integer>> elements = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> indexes;
            if (!elements.containsKey(arr[i])) {
                indexes = new ArrayList<>();
            } else {
                indexes = elements.get(arr[i]);
            }
            indexes.add(i);
            elements.put(arr[i], indexes);
        }

        int leftIndex = 0, rightIndex = arr.length - 1;
        int pointerSum = 0;
        Set<String> alreadyAdded = new HashSet<>();
        while(leftIndex < rightIndex) {
            if (arr[leftIndex] > 0 || arr[rightIndex] < 0) {
                break;
            }

            pointerSum = arr[leftIndex] + arr[rightIndex];
            if (elements.containsKey(pointerSum * -1)) {
                List<Integer> possibleThirdElement = elements.get(pointerSum * -1);
                int thirdElementIndex = -1;
                for (int index: possibleThirdElement) {
                    if (leftIndex < index && rightIndex > index) {
                        thirdElementIndex = index;
                        break;
                    }
                }

                if (thirdElementIndex != -1) {
                    List<Integer> newTriplet = new ArrayList<>();
                    newTriplet.add(arr[leftIndex]);
                    newTriplet.add(arr[thirdElementIndex]);
                    newTriplet.add(arr[rightIndex]);
                    if(!alreadyAdded.contains("" + arr[leftIndex] + arr[thirdElementIndex] + arr[rightIndex])) {
                        triplets.add(newTriplet);
                        alreadyAdded.add("" + arr[leftIndex] + arr[thirdElementIndex] + arr[rightIndex]);
                    }
                    if (Math.abs(arr[leftIndex]) > arr[rightIndex]) {
                        leftIndex++;
                    } else {
                        rightIndex--;
                    }
                    continue;
                }
            }

            if (pointerSum > 0) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }

        return triplets;
    }

    public static void main(String[] args) {
        System.out.println(TripletSum.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(TripletSum.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
    }

}
