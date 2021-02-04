package educative.cielingnumber;

public class CeilingNumber {
    public static int searchCeilingOfANumber(int[] arr, int key) {
        if (arr == null || arr.length == 0 || arr[arr.length - 1] < key) {
            return -1;
        }

        if (arr.length == 1) {
            if (arr[0] > key) {
                return 0;
            } else {
                return -1;
            }
        }

        int leftIndex = 0;
        int rightIndex = arr.length - 1;

        while (leftIndex < rightIndex) {
            if (leftIndex + 1 == rightIndex) {
                if (arr[leftIndex] >= key) {
                    return leftIndex;
                } else if (arr[rightIndex] >= key){
                    return rightIndex;
                }
            }

            int mid = leftIndex + (rightIndex - leftIndex)/2;

            if (arr[mid] > key) {
                rightIndex = mid;
            } else {
                leftIndex = mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(CeilingNumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
        System.out.println(CeilingNumber.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(CeilingNumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
        System.out.println(CeilingNumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
    }
}
