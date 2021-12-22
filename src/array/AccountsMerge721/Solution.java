package array.AccountsMerge721;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    /*
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> emailMapping = new HashMap<>();

        int noOfAccounts = accounts.size();
        int mergeTo = -1;

        for (int i = 0; i < noOfAccounts; i++) {
            mergeTo = -1;

            List<String> emailaddreses = accounts.get(i);
            int noOfEmailAddress = emailaddreses.size() - 1;
            List<Integer> mergeEnteries = new ArrayList<>();

            for (int j = 1; j < noOfEmailAddress; j++) {
                if (emailMapping.containsKey(emailaddreses.get(j))) {
                    // merge
                    if (emailMapping.get(emailaddreses.get(j)) == i) {
                        // duplicate email in same entry
                        continue;
                    }

                    List<String> merged = merge;
                } else {

                }
            }
        }

        return result;
    }

     */

}
