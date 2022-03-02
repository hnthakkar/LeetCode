package array.sherlock;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd");
    }

    public static String isValid(String s) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        int[] freq = new int[26];

        for (int i = 0; i < len; i++) {
            freq[sArray[i] - 'a'] += 1;
        }

        Map<Integer, Integer> freqOfFreq = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) {
                continue;
            }

            freqOfFreq.put(freq[i], freqOfFreq.getOrDefault(freq[i], 0) + 1);
        }

        if (freqOfFreq.size() > 2) {
            return "NO";
        }

        Map.Entry<Integer, Integer> ref = null;

        for (Map.Entry<Integer, Integer> entry: freqOfFreq.entrySet()) {
            if (ref == null) {
                ref = entry;
                continue;
            }

            if (ref.getValue() != 1 && entry.getValue() != 1) {
                return "NO";
            }

            if ((ref.getKey() == 1 && ref.getValue() == 1) || (entry.getKey() == 1 && entry.getValue() == 1)) {
                continue;
            }

            if (Math.abs(ref.getKey() - entry.getKey()) > 1) {
                return "NO";
            }
        }

        return "YES";
    }
}
