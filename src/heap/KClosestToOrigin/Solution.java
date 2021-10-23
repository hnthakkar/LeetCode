package heap.KClosestToOrigin;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.kClosest(new int[][] {{1,3},{-2,2}}, 1);
    }

    public int[][] kClosest(int[][] points, int k) {
        int noOfPoints = points.length;

        double[] oriDist = new double[noOfPoints];
        double[] dist = new double[noOfPoints];


        for (int i = 0; i < noOfPoints; i++) {
            int x = points[i][0];
            int y = points[i][1];

            dist[i] = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            oriDist[i] = dist[i];
        }

        buildMinHeap(dist, noOfPoints);

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            double closet = dist[0];
            result[i] = getPointFromDistance(points, oriDist, closet, noOfPoints);
            dist[0] = dist[dist.length - 1 - i];
            dist[dist.length - 1 - i] = Integer.MAX_VALUE;
            minHeapify(dist, 0, dist.length - i);
        }

        return result;
    }

    private int[] getPointFromDistance(int[][] points, double[] dist, double curDist, int noOfPoints) {
        int[] point = new int[2];

        for (int i = 0; i < noOfPoints; i++) {
            if (dist[i] == curDist) {
                dist[i] = Integer.MAX_VALUE;
                point = points[i];
                break;
            }
        }

        return point;
    }

    private static void buildMinHeap(double[] heapArray, int heapSize) {
        for (int i = (heapSize - 1) / 2; i >= 0; i--) {
            minHeapify(heapArray, i, heapSize);
        }
    }

    private static void minHeapify(double[] heapArray, int index, int heapSize) {
        int smallest = index;

        while (smallest < heapSize / 2) { // check parent nodes only
            int left = (2 * index) + 1; //left child
            int right = (2 * index) + 2; //right child
            if (left < heapSize && heapArray[left] < heapArray[index]) {
                smallest = left;
            }

            if (right < heapSize && heapArray[right] < heapArray[smallest]) {
                smallest = right;
            }

            if (smallest != index) { // swap parent with smallest child
                double temp = heapArray[index];
                heapArray[index] = heapArray[smallest];
                heapArray[smallest] = temp;
                index = smallest;
            } else {
                break; // if heap property is satisfied
            }
        } //end of while
    }
}
