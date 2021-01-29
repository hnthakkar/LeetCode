package educative.highlowindex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindLowHigh {

    public static void main(String[] args) {
        int[] ints = {1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6};
        FindLowHigh.findHighIndex(Arrays.stream(ints).boxed().collect(Collectors.toList()), 2);
    }

    static int findLowIndex(List<Integer> arr, int key) {
        return findLowIndexHelper(arr, key, 0, arr.size() - 1);
    }

    static int findLowIndexHelper(List<Integer> arr, int key, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }

        if ((startIndex > 0 && arr.get(startIndex) == key && arr.get(startIndex-1) != key)
                || (startIndex == 0 && arr.get(startIndex) == key)) {
            return startIndex;
        }

        int mid = startIndex + (endIndex - startIndex)/2;

        if ((mid > 0 && arr.get(mid) == key && arr.get(mid-1) != key)
                || (mid == 0 && arr.get(mid) == key)) {
            return mid;
        } else if (arr.get(mid) < key) {
            return findLowIndexHelper(arr, key, mid + 1, endIndex);
        } else {
            return findLowIndexHelper(arr, key, startIndex, mid - 1);
        }
    }

    static int findHighIndex(List<Integer> arr, int key) {
        return findHighIndexHelper(arr, key, 0, arr.size() - 1);
    }

    static int findHighIndexHelper(List<Integer> arr, int key, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }

        if ((endIndex < (arr.size() - 1) && arr.get(endIndex) == key && arr.get(endIndex+1) != key)
                || (endIndex == (arr.size() - 1) && arr.get(endIndex) == key)) {
            return endIndex;
        }

        int mid = startIndex + (endIndex - startIndex)/2;

        if ((mid < (arr.size() - 1) && arr.get(mid) == key && arr.get(mid+1) != key)
                || (mid == (arr.size() - 1) && arr.get(mid) == key)) {
            return mid;
        } else if (arr.get(mid) <= key) {
            return findHighIndexHelper(arr, key, mid + 1, endIndex);
        } else {
            return findHighIndexHelper(arr, key, startIndex, mid - 1);
        }
    }

}
