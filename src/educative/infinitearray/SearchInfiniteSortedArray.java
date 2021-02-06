package educative.infinitearray;

class ArrayReader {
    int[] arr;

    ArrayReader(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        if (index >= arr.length)
            return Integer.MAX_VALUE;
        return arr[index];
    }
}

public class SearchInfiniteSortedArray {

    public static int search(ArrayReader reader, int key) {
        return search(0, 1, reader, key);
    }

    public static int binarySearch(ArrayReader reader, int startFrom, int endAt, int key) {
        if (startFrom > endAt) {
            return -1;
        }

        if (reader.get(startFrom) == key) {
            return startFrom;
        }

        if (reader.get(endAt) == key) {
            return endAt;
        }

        if (startFrom + 1 == endAt) {
            return -1;
        }

        int mid = startFrom + (endAt - startFrom)/2;

        if (reader.get(mid) >= key) {
            return binarySearch(reader, startFrom, mid, key);
        } else {
            return binarySearch(reader, mid, endAt, key);
        }

    }

    public static int search(int startFrom, int endAt, ArrayReader reader, int key) {
        while (reader.get(endAt) == Integer.MAX_VALUE) {
            endAt = startFrom + (endAt - startFrom)/2;
            if (reader.get(endAt) < key) {
                startFrom = endAt;
                endAt = startFrom + 1;
                break;
            }
        }

        if (reader.get(startFrom) < Integer.MAX_VALUE && reader.get(endAt) == Integer.MAX_VALUE) {
            return -1;
        }

        if (key <= reader.get(endAt) && key >= reader.get(startFrom)) {
            return binarySearch(reader, startFrom, endAt, key);
        }

        return search(endAt, endAt * 2, reader, key);
    }

    public static void main(String[] args) {
        ArrayReader reader = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
        System.out.println(SearchInfiniteSortedArray.search(reader, 16));
        System.out.println(SearchInfiniteSortedArray.search(reader, 11));
        reader = new ArrayReader(new int[] { 1, 3, 8, 10, 15 });
        System.out.println(SearchInfiniteSortedArray.search(reader, 15));
        System.out.println(SearchInfiniteSortedArray.search(reader, 200));
    }
}