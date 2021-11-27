package virtualContest.weeklyContest266.MinimizedMaximumOfProductsDistributedToAnyStore2064;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.minimizedMaximum(22, new int[] {25,11,29,6,24,4,29,18,6,13,25,30});
        // sol.minimizedMaximum(7, new int[] {15,10,10});
        // sol.minimizedMaximum(6, new int[] {11,6});
    }

    public int minimizedMaximum(int stores, int[] quantities) {
        PriorityQueue<ProductInfo> pq = new PriorityQueue<>((a, b)-> b.maxDistribution - a.maxDistribution);
        for (int q : quantities) {
            pq.add(new ProductInfo(q, 1, q));
        }

        int curSize = pq.size();
        while (curSize < stores) {
            ProductInfo product = pq.poll();
            product.incNoOfStoresByOne();
            pq.add(product);
            curSize++;
        }

        return pq.poll().maxDistribution;
    }

}

class ProductInfo {

    int originalAmt;
    int noOfStoresDistributedTo;
    int maxDistribution;

    public ProductInfo(int pOriginalAmt, int pNoOfStoresDistributedTo, int pMax) {
        originalAmt = pOriginalAmt;
        noOfStoresDistributedTo = pNoOfStoresDistributedTo;
        maxDistribution = pMax;
    }

    public void incNoOfStoresByOne() {
        maxDistribution = (int) Math.ceil((double)originalAmt/++noOfStoresDistributedTo);
    }
}
