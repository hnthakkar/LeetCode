package educative.hashtable.firstnonrepeat;

import java.util.HashSet;
import java.util.Set;

public class CheckFirstUnique {

    public static int findFirstUnique(int[] arr)
    {
        Set<Integer> unique = new HashSet<>();

        int firstNonrepeating = arr[arr.length - 1];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (unique.contains(arr[i])) {
                continue;
            }
            firstNonrepeating = arr[i];
            unique.add(arr[i]);
        }
        return firstNonrepeating;
    }
}
