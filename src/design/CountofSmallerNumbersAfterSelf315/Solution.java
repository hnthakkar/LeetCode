package design.CountofSmallerNumbersAfterSelf315;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countSmaller(new int[] {5, 2, 6, 1});
    }

    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        SegmentTreeNode root = buildTree(min, max);

        int[] result = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            insert(root, min, max, nums[i]);
            if (nums[i] == min) {
                result[i] = 0;
            } else {
                int count = getLowerCount(root, min, nums[i] - 1);
                result[i] = count;
            }
        }

        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }

    private int getLowerCount(SegmentTreeNode root, int min, int max) {
        if (min > max) {
            return 0;
        }

        if (root.start == min && root.end == max) {
            return root.count;
        }

        if (root.left.end >= max) {
            return getLowerCount(root.left, min, max);
        }

        if (root.right.start <= min) {
            return getLowerCount(root.right, min, max);
        }

        int left = getLowerCount(root.left, min, root.left.end);
        int right = getLowerCount(root.right, root.left.end + 1, max);

        return left + right;
    }

    private void insert(SegmentTreeNode root, int start, int end, int newValue) {
        if (start == newValue && end == newValue) {
            root.count += 1;
            return;
        }

        int mid = start + (end - start)/2;

        if (newValue <= mid) {
            insert(root.left, start, mid, newValue);
        } else {
            insert(root.right, mid + 1, end, newValue);
        }

        root.count = root.left.count + root.right.count;
    }

    private SegmentTreeNode buildTree(int start, int end) {
        if (start >= end) {
            SegmentTreeNode ret = new SegmentTreeNode(start, end);
            return ret;
        } else {
            SegmentTreeNode ret = new SegmentTreeNode(start, end);

            int mid = start + (end - start) / 2;
            ret.left = buildTree(start, mid);
            ret.right = buildTree(mid + 1, end);

            return ret;
        }
    }
}

class SegmentTreeNode {
    int start, end;
    SegmentTreeNode left, right;
    int count;

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = null;
        this.right = null;
        this.count = 0;
    }
}
