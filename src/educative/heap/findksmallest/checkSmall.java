package educative.heap.findksmallest;

public class checkSmall {

    public static int[] findKSmallest(int[] arr,int k) {
        int[] result = new int[k];
        buildInitialMinHeap(arr);

        for (int i = 0; i < k; i++) {
            result[i] = arr[0];
            arr[0] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = Integer.MAX_VALUE;
            minHeapify(arr, 0, arr.length - i);
        }

        return result;
    }

    private static void buildInitialMinHeap(int[] maxHeap) {
        int heapSize = maxHeap.length;
        for (int i = (heapSize -1)/2; i >= 0; i--) {
            minHeapify(maxHeap, i, heapSize);
        }
    }

    private static void minHeapify(int[] maxHeap, int index, int heapSize) {
        int smallest = index;

        while (smallest < heapSize / 2) {
            int leftChildIndex = (index * 2) + 1;
            int rightChildIndex = (index * 2) + 2;

            if (leftChildIndex < heapSize && maxHeap[leftChildIndex] < maxHeap[smallest]) {
                smallest = leftChildIndex;
            }

            if (rightChildIndex < heapSize && maxHeap[rightChildIndex] < maxHeap[smallest]) {
                smallest = rightChildIndex;
            }

            if (smallest != index) {
                int tmp = maxHeap[index];
                maxHeap[index] = maxHeap[smallest];
                maxHeap[smallest] = tmp;
                index = smallest;
            } else {
                break;
            }
        }
    }
}
