package ranktransform;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RankTransform {

    public int[] arrayRankTransform(int[] arr) {
        int len = arr.length;
        if (len == 0) {
            return arr;
        }
        List<RankWrapper> rankList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            RankWrapper rankWrapper = new RankWrapper(arr[i], i);
            rankList.add(rankWrapper);
        }

        Collections.sort(rankList, new RankComparator());

        int previousValue = rankList.get(0).value;
        int rankIndex = 1;
        int[] ret = new int[len];
        for (int j = 0; j < len; j++) {
            RankWrapper rank = rankList.get(j);
            if (previousValue != rank.value) {
                rankIndex++;
            }
            ret[rank.originalPlace] = rankIndex;
            previousValue = rank.value;
        }

        return ret;
    }

}

class RankWrapper {
    int originalPlace;
    int value;

    RankWrapper(int pValue, int pOriginalPlace) {
        originalPlace = pOriginalPlace;
        value = pValue;
    }
}

class RankComparator implements Comparator<RankWrapper> {
    public int compare (RankWrapper wrapper1, RankWrapper wrapper2) {
        return wrapper1.value - wrapper2.value;
    }
}