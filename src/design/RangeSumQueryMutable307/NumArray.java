package design.RangeSumQueryMutable307;

import java.util.HashMap;
import java.util.Map;

public class NumArray {

    /*
    private int len;
    private int[] original;
    private int[] preSum;
    private Map<Integer, Integer> newDiff;
     */

    public static void main(String[] args) {
        /*
            ["NumArray","update","update","update","sumRange","update","sumRange","update","sumRange","sumRange","update"]
            [[[7,2,7,2,0]],[4,6],[0,2],[0,9],[4,4],[3,8],[0,4],[4,1],[0,3],[0,4],[0,4]]
         */

        NumArray sol = new NumArray(new int[]{7, 2, 7, 2, 0});
        sol.update(4, 6);
        sol.update(0, 2);
        sol.update(0, 9);
        System.out.println(sol.sumRange(4, 4));
        sol.update(3, 8);
        System.out.println(sol.sumRange(0, 4));
        sol.update(4, 1);
        System.out.println(sol.sumRange(0, 3));
        System.out.println(sol.sumRange(0, 4));
        sol.update(0, 4);
    }

    private SegmentTreeNode root = null;

    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            SegmentTreeNode ret = new SegmentTreeNode(start, end);
            if (start == end) {
                ret.sum = nums[start];
            } else {
                int mid = start + (end - start) / 2;
                ret.left = buildTree(nums, start, mid);
                ret.right = buildTree(nums, mid + 1, end);
                ret.sum = ret.left.sum + ret.right.sum;
            }
            return ret;
        }
    }

    void update(int i, int val) {
        update(root, i, val);
    }

    void update(SegmentTreeNode root, int pos, int val) {
        if (root.start == root.end) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (pos <= mid) {
                update(root.left, pos, val);
            } else {
                update(root.right, pos, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    public int sumRange(SegmentTreeNode root, int start, int end) {
        if (root.end == end && root.start == start) {
            return root.sum;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (end <= mid) {
                return sumRange(root.left, start, end);
            } else if (start >= mid + 1) {
                return sumRange(root.right, start, end);
            } else {
                return sumRange(root.right, mid + 1, end) + sumRange(root.left, start, mid);
            }
        }
    }

    /*
    public NumArray(int[] nums) {
        len = nums.length;
        original = nums;

        preSum = new int[len + 1];
        preSum[1] = nums[0];

        for (int i = 1; i < len; i++) {
            preSum[i + 1] += nums[i] + preSum[i];
        }

        newDiff = new HashMap<>();
    }

    public void update(int index, int val) {
        newDiff.put(index, val - original[index] + newDiff.getOrDefault(index, 0));
        original[index] = val;
    }

    public int sumRange(int left, int right) {
        int diff = 0;

        for (int i = left; i <= right; i++) {
            if (newDiff.containsKey(i)) {
                diff += newDiff.get(i);
            }
        }

        return preSum[right + 1] - preSum[left] + diff;
    }


     */
}

class SegmentTreeNode {
    int start, end;
    SegmentTreeNode left, right;
    int sum;

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = null;
        this.right = null;
        this.sum = 0;
    }
}