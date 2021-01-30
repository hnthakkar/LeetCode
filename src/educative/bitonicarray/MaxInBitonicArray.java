package educative.bitonicarray;

public class MaxInBitonicArray {

    public static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        return findMax(arr, 0, arr.length - 1);
    }

    public static int findMax(int[] arr, int startIndex, int endIndex) {
        if  (startIndex == endIndex) {
            return arr[startIndex];
        }

        int mid = startIndex + (endIndex - startIndex)/2;
        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
            return arr[mid];
        } else if (arr[mid] > arr[mid - 1]) {
            return findMax(arr, mid + 1, endIndex);
        } else {
            return findMax(arr, startIndex, mid - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12, 4, 2 }));
        System.out.println(MaxInBitonicArray.findMax(new int[] { 3, 8, 3, 1 }));
        System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12 }));
        System.out.println(MaxInBitonicArray.findMax(new int[] { 10, 9, 8 }));
    }
}
