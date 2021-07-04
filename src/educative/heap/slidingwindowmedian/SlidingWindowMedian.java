package educative.heap.slidingwindowmedian;

public class SlidingWindowMedian {

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

    private static void removeElement(int element) {
        if (maxHeap[0] < element) {
            // remo
        } else {

        }
    }

    private static void addElement(int element) {

    }

    private static void balanceHeaps() {

    }

    private static double getMedian() {
        if (maxHeapSize > minHeapSize) {
            return maxHeap[0];
        } else {
            return (maxHeap[0] + minHeap[0]) % 2.0;
        }
    }

    private static double findMedianForWindow(int[] nums, int startIndex, int windowSize) {
        if (startIndex > 0) {
            removeElement(nums[startIndex - 1]);
        }

        addElement(nums[startIndex + windowSize - 1]);
        balanceHeaps();
        return getMedian();
    }

    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];

        // initial heap
        for (int i = 0; i < k; i++) {
            addElement(nums[i]);
        }

        // keep changing the window now
        for (int i = 0; i <= nums.length - k + 1; i++) {
            result[i] =  findMedianForWindow(nums, i, k);
        }

        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[]{1, 2, -1, 3, 5}, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findSlidingWindowMedian(new int[]{1, 2, -1, 3, 5}, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }

}
