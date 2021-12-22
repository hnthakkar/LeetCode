package design.snapshotArray;

import java.util.ArrayList;
import java.util.List;

class SnapshotArray {

    private List<int[]> snapShot;
    private int[] cur;

    private int snapShotNumber;

    public SnapshotArray(int length) {
        cur = new int[length];
        snapShot = new ArrayList<>();
        snapShotNumber = 0;
    }

    public void set(int index, int val) {
        cur[index] = val;
    }

    public int snap() {
        int[] newArray = new int[cur.length];

        for (int i = 0; i < cur.length; i++) {
            newArray[i] = cur[i];
        }

        snapShot.add(newArray);
        return snapShotNumber++;
    }

    public int get(int index, int snap_id) {
        int[] a = snapShot.get(snap_id);
        return a[index];
    }
}