package educative.heap.connvertmaxtominheap;

public class CheckConvert {

    public static void convertMax(int[] maxHeap) {
        buildMinHeap(maxHeap);
    }

    private static void buildMinHeap(int[] maxHeap) {
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
