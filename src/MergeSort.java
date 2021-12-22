public class MergeSort {

    public static void main(String[] args) {

        int arr[] = { 12, 11, 13, 5, 6, 7 };
        MergeSort sort = new MergeSort();
        sort.sort(arr, 0, arr.length - 1);

        for (int n: arr) {
            System.out.print(" " + n);
        }
    }

    public void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l)/2;

            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public void merge(int[] arr, int l, int m, int r) {
        int l1 = m - l + 1;
        int l2 = r - m;

        int[] ref1 = new int[l1];

        for (int i = 0; i < l1; i++) {
            ref1[i] = arr[l + i];
        }

        int[] ref2 = new int[l2];

        for (int i = 0; i < l2; i++) {
            ref2[i] = arr[i + m + 1];
        }

        int ref1Index = 0;
        int ref2Index = 0;

        for (int i = l; i <= r; i++) {
            if (ref2Index >= l2 || (ref1Index < l1 && ref1[ref1Index] <= ref2[ref2Index])) {
                arr[i] = ref1[ref1Index++];
            } else {
                arr[i] = ref2[ref2Index++];
            }
        }
    }
/*
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int indexToCopy = nums1.length - 1;
        int num1Index = m - 1;
        int num2Index = n - 1;
        while (num2Index >= 0 && num1Index >= 0) {
            if (nums1[num1Index] <= nums2[num2Index]) {
                nums1[indexToCopy--] = nums2[num2Index--];
            } else {
                nums1[indexToCopy--] = nums1[num1Index--];
            }
        }

        while(num2Index >= 0) {
            nums1[indexToCopy--] = nums2[num2Index--];
        }
        System.out.println("test");
    }


 */
}
