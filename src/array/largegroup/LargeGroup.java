package array.largegroup;

import java.util.ArrayList;
import java.util.List;

public class LargeGroup {

    public List<List<Integer>> largeGroupPositions(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        List<List<Integer>> ret = new ArrayList<>();
        int currentIndex = 0;
        char previousChar = '\t';
        int groupLen = 0;
        int newGroupStartIndex = 0;

        while(currentIndex < len) {
            if (previousChar != charArray[currentIndex]) {
                if (groupLen >=3) {
                    List<Integer> indexes = new ArrayList<>();
                    indexes.add(newGroupStartIndex);
                    indexes.add(currentIndex - 1);
                    ret.add(indexes);
                }
                newGroupStartIndex = currentIndex;
                previousChar = charArray[currentIndex];
                groupLen = 1;
            } else {
                groupLen += 1;
            }
            currentIndex++;
        }

        if(groupLen >= 3) {
            List<Integer> indexes = new ArrayList<>();
            indexes.add(newGroupStartIndex);
            indexes.add(currentIndex - 1);
            ret.add(indexes);
        }

        return ret;
    }
}
