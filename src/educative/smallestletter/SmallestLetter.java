package educative.smallestletter;

public class SmallestLetter {

    public static char searchNextLetter(char[] arr, char key) {
        if (arr == null || arr.length == 0) {
            return '\u0000';
        }

        if (arr[arr.length - 1] <= key) {
            return arr[0];
        }

        int leftIndex = 0;
        int rightIndex = arr.length - 1;

        if (arr[leftIndex] > key) {
            return arr[leftIndex];
        }

        while (leftIndex < rightIndex) {
            if (leftIndex + 1 == rightIndex) {
                if (arr[leftIndex] > key) {
                    return arr[leftIndex];
                } else {
                    return arr[rightIndex];
                }
            }

            int mid = leftIndex + (rightIndex - leftIndex)/2;

            if (arr[mid] > key) {
                rightIndex = mid;
            } else {
                leftIndex = mid;
            }
        }

        return '\u0000';
    }

    public static void main(String[] args) {
        System.out.println(SmallestLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
        System.out.println(SmallestLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
        System.out.println(SmallestLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
        System.out.println(SmallestLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
    }
}
