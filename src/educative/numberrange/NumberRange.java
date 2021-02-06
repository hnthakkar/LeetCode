package educative.numberrange;

class FindRange {

    public static int[] findRange(int[] arr, int key) {
        int[] result = new int[] { -1, -1 };

        if (arr[0] <= key && arr[arr.length - 1] >= key) {
            int leftIndex = 0;
            int rightIndex = arr.length - 1;

            if (arr[leftIndex] == key) {
                return getRange(arr, leftIndex);
            }

            if (arr[rightIndex] == key) {
                return getRange(arr, rightIndex);
            }

            while (leftIndex < rightIndex) {
                if (leftIndex + 1 == rightIndex) {
                    if (arr[leftIndex] == key) {
                        result = getRange(arr, rightIndex);
                    } else {
                        break;
                    }
                }

                int mid = leftIndex + (rightIndex - leftIndex)/2;

                if (arr[mid] == key) {
                    result = getRange(arr, mid);
                    break;
                } else if (arr[mid] < key) {
                    leftIndex = mid;
                } else {
                    rightIndex = mid;
                }
            }
        }

        return result;
    }

    private static int[] getRange(int[] arr, int index) {
        int[] range = new int[2];

        int tmp = index;
        while (tmp >= 0 && arr[tmp] == arr[index]) {
            tmp--;
        }

        range[0] = tmp + 1;
        tmp = index;
        while (tmp <= (arr.length - 1) && arr[tmp] == arr[index]) {
            tmp++;
        }

        range[1] = tmp - 1;

        return range;
    }

    public static void main(String[] args) {
        int[] result = FindRange.findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }
}