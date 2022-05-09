package design.FlattenNestedListIterator341;

import java.util.*;

public class NestedIterator implements Iterator<Integer> {
    /*
    public static void main(String[] args) {
        List<NestedInteger> list = new ArrayList<>();
        NestedInteger nested = new ArrayList<>();
        list.add(new ArrayList<NestedInteger>());
        NestedIterator root = new NestedIterator();
    }
    */

    public static void main(String[] args) {
        List<NestedInteger> root = new ArrayList<>();
        NestedInteger n1 = new NestedIntegerValues(new NestedInteger[]{});
        NestedInteger n2 = new NestedIntegerValues(new NestedInteger[]{new NestedIntegerValue(3)});

        root.add(n1);
        root.add(n2);

        NestedIterator it = new NestedIterator(root);

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    private List<NestedInteger> lNestedList;
    private Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        lNestedList = nestedList;
        stack = new Stack<>();
        addListToStack(nestedList);
    }

    private void addListToStack(List<NestedInteger> nestedList) {
        int size = nestedList.size();

        for (int i = size - 1; i >= 0; i--) {
            stack.add(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        }

        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            addListToStack(stack.pop().getList());
        }

        return !stack.isEmpty();
    }
    /*
    @Override
    public Integer next() {
        Integer ret = null;

        if (curElemIsList && curList.hasNext()) {
            ret = curList.next();
        } else {
            NestedInteger nextItem = lNestedList.get(curIndex++);

            if (nextItem.isInteger()) {
                curElemIsList = false;
                curList = null;

                return nextItem.getInteger();
            } else {
                curElemIsList = true;
                curList = new NestedIterator(nextItem.getList());
                ret = curList.next();
            }
        }

        return ret;
    }

    @Override
    public boolean hasNext() {
        if (curElemIsList && curList.hasNext()) {
            return true;
        }

        return curIndex < curListLen;
    }

     */
}

interface NestedInteger {
    public boolean isInteger();
    public Integer getInteger();
    public List<NestedInteger> getList();
}

class NestedIntegerValues implements NestedInteger {

    List<NestedInteger> values;


    public NestedIntegerValues(NestedInteger... values) {
        this.values = Arrays.asList(values);
    }

    @Override
    public boolean isInteger() {
        return false;
    }

    @Override
    public Integer getInteger() {
        return null;
    }

    @Override
    public List<NestedInteger> getList() {
        return values;
    }

    @Override
    public String toString() {
        StringBuffer buff = new StringBuffer();
        buff.append('{');
        values.forEach(v -> {
            buff.append(v.toString());
            buff.append(',');
        });
        buff.setCharAt(buff.length() - 1, '}');
        return buff.toString();
    }
}

 class NestedIntegerValue implements NestedInteger {

    Integer value;

    public NestedIntegerValue(Integer v){
        value = v;
    }

    @Override
    public boolean isInteger() {
        return true;
    }

    @Override
    public Integer getInteger() {
        return value;
    }

    @Override
    public List<NestedInteger> getList() {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
