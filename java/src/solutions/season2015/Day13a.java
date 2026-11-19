package solutions.season2015;

import solutions.Solution;

import java.util.*;


public class Day13a implements Solution {

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

        Map<String, Integer> e = new HashMap<>();
        Set<String> v = new HashSet<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] words = line.split(" ");

            String a = words[0] + ".";
            String b = words[words.length - 1];

            int value = Integer.parseInt(words[3]);
            if (words[2].equals("lose")) {
                value = -value;
            }

            e.put(a + b, value);
            v.add(a);
        }

        List<List<String>> permutations = permutate(v.stream().toList());
        int best = 0;
        for (List<String> permutation : permutations) {
            int sum = 0;
            for (int i = 0; i < permutation.size(); ++i) {
                String guest = permutation.get(i);
                String previous = permutation.get(Math.floorMod(i - 1, permutation.size()));
                String next = permutation.get(Math.floorMod(i + 1, permutation.size()));

                int prevVal = e.getOrDefault(guest + previous, 0);
                int nextVal = e.getOrDefault(guest + next, 0);

                sum += prevVal + nextVal;
            }

            if (sum > best) {
                best = sum;
            }
        }

        return best + "";
    }
}
