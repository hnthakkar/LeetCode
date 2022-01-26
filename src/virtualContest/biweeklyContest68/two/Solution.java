package virtualContest.biweeklyContest68.two;

import java.util.*;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        /*
        List<String> one = new ArrayList<>();
        one.add("yeast");
        one.add("flour");

        List<String> two = new ArrayList<>();
        two.add("bread");
        two.add("meat");

        List<String> three = new ArrayList<>();
        three.add("bread");
        three.add("meat");
        three.add("sandwich");

        List<List<String>> input = new ArrayList<>();
        input.add(three);
        input.add(two);
        input.add(one);


         */

        String[] oneInput = new String[] {"ju","fzjnm","x","e","zpmcz","h","q"};
        String[] threeInput = new String[] {"f","hveml","cpivl","d"};

        List<String> one = new ArrayList<>();
        one.add("d");

        List<String> two = new ArrayList<>();
        two.add("hveml");
        two.add("f");
        two.add("cpivl");

        List<String> three = new ArrayList<>();
        three.add("cpivl");
        three.add("zpmcz");
        three.add("h");
        three.add("e");
        three.add("fzjnm");
        three.add("ju");

        List<String> four = new ArrayList<>();
        four.add("cpivl");
        four.add("hveml");
        four.add("zpmcz");
        four.add("ju");
        four.add("h");

        List<String> five = new ArrayList<>();
        five.add("h");
        five.add("f");
        five.add("fzjnm");
        five.add("e");
        five.add("q");
        five.add("x");

        List<String> six = new ArrayList<>();
        six.add("d");
        six.add("hveml");
        six.add("cpivl");
        six.add("q");
        six.add("zpmcz");
        six.add("ju");
        six.add("e");
        six.add("x");

        List<String> seven = new ArrayList<>();
        seven.add("f");
        seven.add("hveml");
        seven.add("cpivl");

        List<List<String>> input = new ArrayList<>();
        input.add(one);
        input.add(two);
        input.add(three);
        input.add(four);
        input.add(five);
        input.add(six);
        input.add(seven);


        sol.findAllRecipes(oneInput, input, threeInput);
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> availIng = new HashSet<>();
        List<String> result = new ArrayList<>();

        for (String sup : supplies) {
            availIng.add(sup);
        }

        Map<String, List<String>> recIngmap = new HashMap<>();
        int rLen = recipes.length;

        for (int i = 0; i < rLen; i++) {
            String r = recipes[i];
            List<String> ingred = ingredients.get(i);
            recIngmap.put(r, ingred);
        }

        for (int i = 0; i < rLen; i++) {
            Queue<String> q = new LinkedList();
            Set<String> visited = new HashSet<>();

            String r = recipes[i];

            List<String> ingred = ingredients.get(i);
            boolean canBeMade = true;
            q.addAll(ingred);
            visited.addAll(ingred);

            while(!q.isEmpty()) {
                String ing = q.poll();
                if (!availIng.contains(ing)) {
                    if (recIngmap.containsKey(ing)) {
                        List<String> subIng = recIngmap.get(ing);

                        for (String sub: subIng) {
                            if (sub.equals(r)) {
                                canBeMade = false;
                                break;
                            }

                            if (!visited.contains(sub)) {
                                q.add(sub);
                                visited.add(sub);
                            }
                        }
                    } else {
                        canBeMade = false;
                        break;
                    }
                }
            }

            if (canBeMade) {
                availIng.add(r);
                result.add(r);
            }
        }


        return result;
    }


}
