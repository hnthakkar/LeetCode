package educative.heap.medianofstream;

public class MedianOfAStream {
    private static int[] minHeap = new int[10];
    private static int minHeapSize = 0;

    private static int[] maxHeap = new int[10];
    private static int maxHeapSize = 0;

    static {
        for (int i = 0; i < 10; i++) {
            minHeap[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < 10; i++) {
            maxHeap[i] = Integer.MIN_VALUE;
        }
    }

    public double findMedian() {
        double median = 0;
        if (maxHeapSize > minHeapSize) {
            median = maxHeap[0];
        } else {
            median = (minHeap[0] + maxHeap[0])/2.0;
        }

        return median;
    }

    public void insertNum(int num) {
        if (num < maxHeap[0] || minHeapSize == 0) {
            insertIntoMaxHeap(num);
        } else {
            insertIntoMinHeap(num);
        }

        while (maxHeapSize != minHeapSize) {
            if (maxHeapSize == minHeapSize + 1) {
                break;
            }

            if (minHeapSize > maxHeapSize) {
                moveItemFromMinToMaxHeap();
            } else {
                moveItemFromMaxToMinHeap();
            }
        }
    }

    private static void moveItemFromMaxToMinHeap() {
        int moveNumber = maxHeap[0];
        maxHeap[0] = maxHeap[maxHeapSize - 1];
        maxHeap[maxHeapSize - 1] = Integer.MIN_VALUE;
        maxHeapSize--;
        maxHeapify(0);
        insertIntoMinHeap(moveNumber);
    }

    private static void moveItemFromMinToMaxHeap() {
        int moveNumber = minHeap[0];
        minHeap[0] = minHeap[minHeapSize - 1];
        minHeap[minHeapSize - 1] = Integer.MAX_VALUE;
        minHeapSize--;
        minHeapify(0);
        insertIntoMaxHeap(moveNumber);
    }

    private static void insertIntoMaxHeap(int num) {
        if (maxHeapSize >= 10) {
            return;
        }
        maxHeap[maxHeapSize++] = num;
        for (int i = 0; i < maxHeapSize; i++) {
            maxHeapify(i);
        }
    }

    private static void insertIntoMinHeap(int num) {
        if (minHeapSize >= 10) {
            return;
        }

        minHeap[minHeapSize++] = num;
        for (int i = 0; i < minHeapSize; i++) {
            minHeapify(i);
        }
    }

    private static void minHeapify(int index) {
        int smallest = index;

        while (smallest < minHeapSize / 2) {
            int leftChildIndex = (index * 2) + 1;
            int rightChildIndex = (index * 2) + 2;

            if (leftChildIndex < minHeapSize && minHeap[leftChildIndex] < minHeap[smallest]) {
                smallest = leftChildIndex;
            }

            if (rightChildIndex < minHeapSize && minHeap[rightChildIndex] < minHeap[smallest]) {
                smallest = rightChildIndex;
            }

            if (smallest != index) {
                int tmp = minHeap[index];
                minHeap[index] = minHeap[smallest];
                minHeap[smallest] = tmp;
                index = smallest;
            } else {
                break;
            }
        }
    }

    private static void maxHeapify(int index) {
        int largest = index;

        while (largest < maxHeapSize / 2) {
            int leftChildIndex = (index * 2) + 1;
            int rightChildIndex = (index * 2) + 2;

            if (leftChildIndex < maxHeapSize && maxHeap[leftChildIndex] > maxHeap[largest]) {
                largest = leftChildIndex;
            }

            if (rightChildIndex < maxHeapSize && maxHeap[rightChildIndex] > maxHeap[largest]) {
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

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}
