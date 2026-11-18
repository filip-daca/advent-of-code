package solutions.season2015;

import solutions.Solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day5b implements Solution {

    @Override
    public String solve(Scanner sc) {
        int count = 0;

        while (sc.hasNextLine()) {
            String w = sc.nextLine();

            Map<String, Integer> pairIndex = new HashMap<>();

            boolean contains2Pairs = false;
            boolean containsPal3 = false;

            for (int i = 1; i < w.length(); ++i) {
                String c = w.charAt(i) + "";
                String pair = w.charAt(i - 1) + c;

                if (pairIndex.containsKey(pair)) {
                    if (pairIndex.get(pair) < i - 1) {
                        contains2Pairs = true;
                    }
                } else {
                    pairIndex.put(pair, i);
                }

                if (i > 1) {
                    String ccc = w.charAt(i - 2) + "";
                    if (c.equals(ccc)) {
                        containsPal3 = true;
                    }
                }
            }

            if (contains2Pairs && containsPal3) {
                count++;
            }
        }

        return count + "";
    }
}
