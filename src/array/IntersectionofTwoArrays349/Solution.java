package array.IntersectionofTwoArrays349;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> ref = new HashSet<>();

        Set<Integer> retSet = new HashSet<>();

        for (int n: nums1) {
            ref.add(n);
        }

        for (int n: nums2) {
            if (ref.contains(n)) {
                retSet.add(n);
            }
        }

        int len = retSet.size();
        int[] ret = new int[len];

        int index = 0;
        for (int i: retSet) {
            ret[index++] = i;
        }

        return ret;
    }
}
