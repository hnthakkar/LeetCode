package rollinghash.longestDuplicateSubstring1044;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.longestDupSubstring("dcecccaedebdcedcbaaddbbdbccbcbdcecbddaaedecbeccdeabdceebcaaeccbbcdcdaceceeacedadcdddbbbaedeaebbbecbeebdcdebadabaecacdeeeabeaaaeacbdacedabbadcbeddebbbcebedeecdbebbdbcebacebdaaceabdbdcaebddeaeccaccbcebdacddbdddbadecbadaacaadcdececadeebbacedebeddcaacedacbcaadecdeecddbdbbbcccedeaaeecededdaccddbdccdcdddddcdacceabbcebdebddbcbbaaababceebdaaeababeacaeddccecadebeceeddaddbdbdebcbceceeacedcaedcebeeeadbbecdecaeabaeedbdddaececeebcaddbcaaeebcbeccbedcdeccebeebdbaceddebddabebbabbcedbbedacecbaebaaedbeaeaebbaaeeeebbbbeecdecdcedbcdbbbdcaecdbbcadbeebaebcaebccadecdccabbddbddeaeeaecccbeacdcbeadadadacbceaaeceebcdcddceeebebedececacadbedeeebdecadbebebebecaeeecbdceecdcacadceadcceaebcbaceeceeaaedecaddbaacacdbedebeeccadbccdeccdcadcdaadbabddbbdaacbaaaceeecaadcabadbeecadeebbdcebabedcddbebdcbaccdaabebcbacbedadeacbbcacadbdabbaccadadddeabdcbbdeacdbeededdecebceacabdceaeaaeaacbbbacabccedddeceadceedacccedaaceadeabccbdaeadcabbccadaecddebbadeecadccbacebdaabbeacdccaedeeeaaadaaaddebeadcbbdcebeeaebecdbacccbaeadcbacabbbeedeaaccaebddaaceadebeedebabdbbecebeabddeeecaeedddabacbbdbddebbadadcbeacecdaabcaeddceebceebaecccadeecbbdbeaeedcdeaabadcdeaebaaaadbdadeeaadadcabeceadbbdedadaaaecdacdbcedbeabcbeaeacaecebdeaedacbcbeaebcabdaabaddecadbeaecdcbebbbccbbddbccdebaaeecccddaaeccedebabacdeecbbbbccdedcbcebeceedcaacbeaacabdbbeeebdcddbceebdaddacadadceaaeecabaecadcdabbccaabcdbeededadcbecbebcdceabccecbebbbccbcddccebdeacbebabeecbebacceecbdddeeeeabeaabcdbecbbdacdccadbeeaccecdbcddcdacbaddcacdacdbebeaabdadeaadcacedcccdcdbddaaebacecbdccdbaabdecadddedcbbaaacdeaddcdcebcaeccbcbcdaaeceabaedeeeadebcaadbbedbccbaabdbdccbabceabeeccbbadbaecedddccedaeaabcbaaeabcdbdbdaabcedbbbdbeabaedcbdabeeabbadecadeadabcbdaebdbcbecccaaeadcaaebcccdacabdbecebbedaaeebcadbeeeebebccdaceedecdedceaceaeabccbebaccebdceabbdadcdccbeeebbbbaedebecbbbeabebdabdcdcbcbedaedcbcaebbccdbacdccbbcbadcbbaccbebaaabaaaedccdceecababeacddacceeabeaabaaeccceccecddeecdadedeaadabaccabbadaaecbebccbabaadcbecebedbaececeabdebcadaddcaebeeabbebedeadcdccbadabcecbacecbdbccebcbbaadceadbacadeeebcddcdddccaeaababdcddeebaaddcbcaaddceedacdaaeaadcedeeaeaddebdabaddddbadccbdbebcecdccebeebdcccbeedbcceebbadcdebaeedbecccdbaedcdbcbbaaaaabbbdaddabdbbeebdeabedededbdbcecedadbaebddcabbbabecacdedccbeaacaeaccadcbeebaadceddbdacbbadccacbadcdddabcccaababebdceeddcaebbaebeeedabdbcacabdcbaceabcccdcacacbbaeeaaddedaabccaabbeaccaceecbaacbeebcbeaecdbcaeaaaedcdbebcaaaaacaabbbbccbceebbbaaaceccabdeceeeddbabadddeeaaebbabbeaadaacacdebbaadbaeebbdebbabbbbbeadbebadacdcdbaccaebaadccbabcadccbeaacadeabcadebbcadabaaaaeccaddbbebcdabdededddeadcbceacebaeeddeaebedbebaeabebcadcdbccdbdbdeccaebddeaabccdaecebdededddcbbcacdcbaedcebdedaaceebccbcdababaeaacabcddaadacaadbadcdbbedaebddebedceddddceadeaebbebbaabdeabdcdabccdcedaddeaeddecdecbeebeedaadbcbbebcbeecedaabcacaabdbaecaeebeaedadbabecbaabbebadaccadeebeeebbecdcaecaeacadeabbadceaeccbcdbebaaabebaacdebbcaaeadccbebcebebebbedddacbbccbedbecbeaebecedacdcdbbebdaedeabcabaaaeebbdbbaddadcebbacecbaacddecbddeecbbedecedbbaebddeeacbcdedbdaddbbaecdccaedcebeeebaacaaabcbddccacbccbacdbebaeadbeaacacbceddbaeabaaaadaabbcddaabcabeeccabcebacdacbadbdebddaddeaabeebbbbbbacbdddecbaddcdeaaaeecbbcedcbecddbebeccaacaedabdacabdaabdbadccddedecdebadcdcadbedeecbdddaacdbdcadddacaedceacaecaebcecedeaeadbabccdbdeacebaccaabccccdcecaecadeaddeaeddabcbadedceebdaacdadebbeebdeedcecebdeecaaeccbcdddddadbbbcbaabccabebabdcdcaacadaaeebbbedbdecabcceeccabadbbaddcdbeaaeeadaddeebaecaedecccaadbdeddbbbeeceeaaccaedadddbaecacccadaeecdecabccabbebcacedbeadccddeaadacdcbeedeaeabcbccbbdcdaeedbcabaaccaccbdaacebacaecdacbebddbbbdddebacadaaadbdcbcaccdddeedbecbcdcbaeaacbabbeaeebbadadaebbccaebebdeeceecbabdebcebeaadebdbbddcaeddbcadeadaabdccdecdcaccaecccdeaaacdbdccadacbdbaaccdbddbecaacbcbbdbedecedecbaacadccaedbacabddaeccdecaaeeecadddeaaadcdaedeadedbeeccccabeadaebcaaecacebdcdaaadedccacdceaeededcaaedceccedccebdacbececeeaebaecbdeecdbaeeeeeadececcdcabbddadecdddabdeeedccabbaebddedecccacdbdcbbcddcaecbdaddcadacbbccceccecacddcbaedcbbeecedbeecdeaaeeeecdcabcebecbcebbceabaddeacaedaabadebcecdadbebcbbeeaceaacbdcaabacadaebebcdceeeacaacaddeaadabaceeecbccbecbdabebebccdadeedaadaecceacaabeacdaebeecbdcbbdeddbeebdadbabbeaddbcdccdbcebddaebeddcaecdededebebdaabdddaecedddabbeeebadbbbdebeeecbbebaebdeebceaeaedbecbbcadadbeacceeecbabaeadbdedccbbbbaabeabbbdadceedaaddcbbceadbbaebebebbdeadcaabdeebaaebbeecaddecccbddcdebadcebbaacddbbeecadbcaebdebaaeeaadbaeeeedbcabebceccebabbeebcddebcdbdabcbcbbcadecbdacedadacdbbebeebaddecbccaeaeccedbcddededdecbcecdeaabeceeadbcbeaaccaeccceadecaaacbaaccaccbeeeceddadaabdeeaedbcceabeabbbcaeededdcdcbdbbedecbbdbeeeccadcadedeacbbcdbebcbeaedbcbdbdabbdcacacadeedbebddeddccaeebceddeeebdbbabcaebdbdbedeeadbabaadddcaabbbbcabeeddbbadabacceabcbceddeceadcdbaeadaedebecdecbdbabdcacddbccbaedcceabbecabdacbdcbaeaeccceecabbaeaecdeadabaeeedeeadeebbacdaceadedecedebbbcbaccaacebbebadaeaecbeebadaaceaabebdbddeecedcbcbcdbcdaccacbbbdaddacbcaaaebdcadbcaeeaacacebeebaeeecbdeedddcebcbeaabdedbaddabcadbbaeadccdbcebddadebaaabcaeadcedaadcaeedcbbcdbcdbcdcbdcebaaadededdccebebbedcadeadeeadeebbdceebdddacebdedbbcdabbcdacbbdcccacdbacbbaeeeacbedceaedebbacdbeebaebbaeacaccaecdeacbbaacaceebedaacdcebaaacadcdeceaeeadcadceaeeabeecaabbabbebdecdcadadebabddbabebdbadeabcdadbbcaadcdbdbabddebcbcbeddabbcabaebcbccddbbbbebdbdabcdcddbdbceecadbadadbdcbadedecdcbaebcaaddbeebceaceeaacceabcacaccddcebcabbebddecddbedbddaeadebbcdccddeebebbaceaaeeebcdceeebdccbaababcdcbdcebbbbcaeccecaadcaeabababbcdaeaecdcbaddbacbaeecdcdecccabcddbbbcdcadadabcbcedaadaacceaededbaecaeadabdcd");
        // sol.longestDupSubstring("banana");
        // sol.longestDupSubstring("zxcvdqkfawuytt");
        // sol.longestDupSubstring("aa");
    }

    public String longestDupSubstring(String s) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        int lastMatchIndex = -1;
        int lastMatchWS = -1;

        int rightWindowMargin = len;
        int leftWindowMargin = 1;

        int mid = leftWindowMargin + (rightWindowMargin - leftWindowMargin)/2;

        while (leftWindowMargin <= rightWindowMargin) {
            int result = checkForWindowSize(sArray, mid, len);
            if (result == -1) {
                rightWindowMargin = mid - 1;
            } else {
                lastMatchIndex = result;
                lastMatchWS = mid;
                leftWindowMargin = mid + 1;

                if (checkForWindowSize(sArray, leftWindowMargin, len) == -1) {
                    break;
                }
            }

            mid = leftWindowMargin + (rightWindowMargin - leftWindowMargin)/2;
        }

        return lastMatchIndex != -1 ? new String(sArray, lastMatchIndex, lastMatchWS) : "";
    }

    private int checkForWindowSize (char[] sArray, int windowSize, int len) {
        int resultIndex = -1;
        boolean found = false;
        Map<Integer, List<Integer>> hashMapping = new HashMap<>();
        int hash = calculateHash(sArray, 0, windowSize, len);

        List<Integer> initial = new ArrayList<>();
        initial.add(0);
        hashMapping.put(hash, initial);

        for (int i = 1; i < len - (windowSize - 1); i++) {
            hash += (sArray[i + windowSize - 1] - sArray[i - 1]);

            if (hashMapping.containsKey(hash)) {
                List<Integer> possibleMatch = hashMapping.get(hash);
                for (int index: possibleMatch) {
                    if (confirmIfMatch(sArray, i, index, windowSize, len)) {
                        found = true;
                        resultIndex = index;
                        break;
                    }
                }
                if (found) {
                    break;
                }

                possibleMatch.add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hashMapping.put(hash, list);
            }
        }

        return resultIndex;
    }

    private boolean confirmIfMatch(char[] sArray, int startIndex1, int startIndex2, int windowSize, int len) {
        if (windowSize < 1) {
            return false;
        }

        int counter = 0;
        while (counter < windowSize) {
            if (startIndex1 < len && startIndex2 < len && sArray[startIndex1] == sArray[startIndex2]) {
                startIndex1++;
                startIndex2++;
                counter++;
                continue;
            }

            return false;
        }

        return true;
    }

    private int calculateHash(char[] sArray, int startIndex, int windowSize, int len) {
        int hash = 0;

        for (int i = startIndex; i < windowSize && i < len; i++) {
            hash += sArray[i] - 'a';
        }

        return hash;
    }
}
