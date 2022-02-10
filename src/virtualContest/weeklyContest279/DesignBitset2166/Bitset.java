package virtualContest.weeklyContest279.DesignBitset2166;

public class Bitset {

    private int[] bitSet;
    private int sBitCount;
    private int totalBits;
    private boolean flipped;

    public static void main(String[] str) {
        /*
        Bitset sol = new Bitset(5);
        sol.fix(3);
        sol.fix(1);
        sol.flip();
        sol.all();
        sol.unfix(0);
        sol.flip();
        sol.one();
        sol.unfix(0);
        sol.count();
        sol.toString();

         */

        Bitset sol = new Bitset(1);
        sol.all();
        sol.fix(0);
        sol.flip();
        sol.fix(0);
        sol.flip();
        sol.unfix(0);
        sol.one();
        sol.all();
        sol.toString();
        sol.flip();
        sol.fix(0);
        sol.all();
        sol.flip();
        sol.fix(0);
        sol.flip();
        sol.unfix(0);
        sol.fix(0);
        sol.all();
        sol.flip();
        sol.all();
    }

    public Bitset(int size) {
        bitSet = new int[size];
        sBitCount = 0;
        totalBits = size;
        flipped = false;
    }

    public void fix(int idx) {
        if (flipped) {
            if (bitSet[idx] == 1) {
                bitSet[idx] = 0;
                sBitCount++;
            }
        } else {
            if (bitSet[idx] == 0) {
                bitSet[idx] = 1;
                sBitCount++;
            }
        }
    }

    public void unfix(int idx) {
        if (flipped) {
            if (bitSet[idx] == 0) {
                bitSet[idx] = 1;
                sBitCount--;
            }
        } else {
            if (bitSet[idx] == 1) {
                bitSet[idx] = 0;
                sBitCount--;
            }
        }
    }

    public void flip() {
        flipped = !flipped;
        sBitCount = totalBits - sBitCount;
    }

    public boolean all() {
        return sBitCount == totalBits;
    }

    public boolean one() {
        return sBitCount > 0;
    }

    public int count() {
        return sBitCount;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < totalBits; i++) {
            if (flipped) {
                sb.append(bitSet[i] == 0? 1: 0);
            } else {
                sb.append(bitSet[i]);
            }
        }
        return sb.toString();
    }
}
