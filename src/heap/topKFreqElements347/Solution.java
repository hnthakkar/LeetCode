package heap.topKFreqElements347;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        int[] freq = toPrimitive((Integer[])freqMap.values().toArray());
        buildInitialMaxHeap(freq);

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            int highestFreq = freq[0];
            result[i] = getElemWithFreq(freqMap, highestFreq);
            freq[0] = freq[freq.length - 1 - i];
            freq[freq.length - 1 - i] = Integer.MIN_VALUE;
            maxHeapify(freq, 0, freq.length - i);
        }

        return result;
    }

    private int getElemWithFreq(Map<Integer, Integer> freqMap, int freq) {
        int key = -1;
        for (Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
            if (entry.getValue() == freq) {
                key = entry.getKey();
                freqMap.remove(key);
                break;
            }
        }

        return key;
    }

    public int[] toPrimitive(Integer[] IntegerArray) {
        int[] result = new int[IntegerArray.length];
        for (int i = 0; i < IntegerArray.length; i++) {
            result[i] = IntegerArray[i].intValue();
        }
        return result;
    }

    private void buildInitialMaxHeap(int[] maxHeap) {
        int heapSize = maxHeap.length;
        for (int i = (heapSize -1)/2; i >= 0; i--) {
            maxHeapify(maxHeap, i, heapSize);
        }
    }

    private void maxHeapify(int[] maxHeap, int index, int heapSize) {
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
