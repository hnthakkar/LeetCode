package pascal2;

import java.util.ArrayList;
import java.util.List;

public class Pascal2 {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);

        if (rowIndex == 0) {
            return firstRow;
        }

        List<Integer> secondRow = new ArrayList<>();
        secondRow.add(1);
        secondRow.add(1);

        if (rowIndex == 1) {
            return secondRow;
        }

        List<Integer> previousRow = secondRow;
        List currentRow;
        for (int i = 3; i <= rowIndex + 1; i++) {
            currentRow = getNextRow(previousRow, i);
            previousRow = currentRow;
        }

        return previousRow;
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
