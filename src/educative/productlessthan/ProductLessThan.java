package educative.productlessthan;

import java.util.ArrayList;
import java.util.List;

public class ProductLessThan {

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < target) {
                int continuousProduct = 1;
                int j = i;
                while (j < arr.length) {
                    continuousProduct *= arr[j];
                    if (continuousProduct < target) {
                        List<Integer> ret = new ArrayList<>();
                        for (int k = i; k <= j; k++) {
                            ret.add(arr[k]);
                        }
                        subarrays.add(ret);
                        j++;
                    } else {
                        break;
                    }
                }
            }
        }
        return subarrays;
    }

    public static void main(String[] args) {
        System.out.println(ProductLessThan.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(ProductLessThan.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
    }

}
