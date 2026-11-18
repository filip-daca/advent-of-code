package solutions.season2015;

import solutions.Solution;

import java.util.*;


public class Day9b implements Solution {

    private List<List<String>> permutate(List<String> l) {
        List<List<String>> permutations = new ArrayList<>();
        if (l.size() == 1) {
            List<String> single = new ArrayList<>();
            single.add(l.get(0));
            permutations.add(single);
        } else {
            for (int i = 0; i < l.size(); ++i) {
                String e = l.get(i);
                List<String> subList = new ArrayList<>();
                for (int j = 0; j < l.size(); ++j) {
                    if (j != i) {
                        subList.add(l.get(j));
                    }
                }

                List<List<String>> subPermutations = permutate(subList);
                subPermutations.forEach(perm -> perm.addFirst(e));
                permutations.addAll(subPermutations);
            }
        }
        return permutations;
    }

    @Override
    public String solve(Scanner sc) {

        Map<String, Map<String, Integer>> g = new HashMap<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] words = line.split(" ");

            Map<String, Integer> v1 = g.computeIfAbsent(words[0], k -> new LinkedHashMap<>());
            Map<String, Integer> v2 = g.computeIfAbsent(words[2], k -> new LinkedHashMap<>());
            v1.put(words[2], Integer.parseInt(words[4]));
            v2.put(words[0], Integer.parseInt(words[4]));
        }

        Integer best = null;
        List<List<String>> permutations = permutate(g.keySet().stream().toList());
        for (List<String> p : permutations) {
            int score = 0;

            for (int i = 1; i < p.size(); ++i) {
                score += g.get(p.get(i - 1)).get(p.get(i));
            }

            if (best == null || score > best) {
                best = score;
            }
        }

        return best + "";
    }
}
