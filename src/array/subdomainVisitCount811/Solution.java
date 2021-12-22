package array.subdomainVisitCount811;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<String> subdomainVisits(String[] cpdomains) {
        int len = cpdomains.length;

        Map<String, Integer> resultMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            String dn = cpdomains[i];

            String[] space = dn.split(" ");
            int count = Integer.parseInt(space[0]);

            helper(count, resultMap, space[1]);
        }

        List<String> result = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }

        return result;
    }

    private void helper(int count, Map<String, Integer> resultMap, String dns) {
        char[] sArray = dns.toCharArray();
        int len = sArray.length;

        if (resultMap.containsKey(dns)) {
            resultMap.put(dns, resultMap.get(dns) + count);
        } else {
            resultMap.put(dns, count);
        }

        for (int i = 0; i < len; i++) {
            if (sArray[i] != '.') {
                continue;
            }

            String newDn = new String(sArray, i + 1, len - i - 1);

            if (resultMap.containsKey(newDn)) {
                resultMap.put(newDn, resultMap.get(newDn) + count);
            } else {
                resultMap.put(newDn, count);
            }
        }
    }

}
