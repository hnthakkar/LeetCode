package educative.heap.findklargest;

public class CheckLarge {

    public static int[] findKSmallest(int[] arr,int k) {
        int[] result = new int[k];
        buildInitialMaxHeap(arr);

        for (int i = 0; i < k; i++) {
            result[i] = arr[0];
            arr[0] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = Integer.MIN_VALUE;
            maxHeapify(arr, 0, arr.length - i);
        }

        return result;
    }

    private static void buildInitialMaxHeap(int[] maxHeap) {
        int heapSize = maxHeap.length;
        for (int i = (heapSize -1)/2; i >= 0; i--) {
            maxHeapify(maxHeap, i, heapSize);
        }
    }

    private static void maxHeapify(int[] maxHeap, int index, int heapSize) {
        int largest = index;

        while (largest < heapSize / 2) {
            int leftChildIndex = (index * 2) + 1;
            int rightChildIndex = (index * 2) + 2;

            if (leftChildIndex < heapSize && maxHeap[leftChildIndex] > maxHeap[largest]) {
                largest = leftChildIndex;
            }

            if (rightChildIndex < heapSize && maxHeap[rightChildIndex] > maxHeap[largest]) {
                largest = rightChildIndex;
            }

            if (largest != index) {
                int tmp = maxHeap[index];
                maxHeap[index] = maxHeap[largest];
                maxHeap[largest] = tmp;
                index = largest;
            } else {
                break;
            }
        }
    }

}
