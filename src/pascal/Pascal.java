package pascal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pascal {

    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> ret = new ArrayList<>();

        List<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        ret.add(firstRow);

        if (numRows == 1) {
            return ret;
        }

        List<Integer> secondRow = new ArrayList<Integer>();
        secondRow.add(1);
        secondRow.add(1);
        ret.add(secondRow);


        if (numRows == 2) {
            return ret;
        }

        for (int i = 3; i <= numRows; i++) {
            ret.add(getNextRow(ret.get(i-2), i));
        }

        return ret;
    }

    private List<Integer> getNextRow(List<Integer> previousRow, int currentRow) {
        List<Integer> ret = new ArrayList<>();

        for (int i = 0; i < currentRow; i++) {
            if (i == 0 || i == currentRow - 1) {
                ret.add(1);
                continue;
            }
            ret.add(previousRow.get(i-1) + previousRow.get(i));
        }

        return ret;
    }
}
