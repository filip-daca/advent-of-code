package solutions.season2015;

import solutions.Solution;

import java.util.Scanner;

public class Day5a implements Solution {

    @Override
    public String solve(Scanner sc) {
        int count = 0;

        while (sc.hasNextLine()) {
            String w = sc.nextLine();

            int vovels = 0;

            boolean contains2Vovels = false;
            boolean containsEqualPair = false;
            boolean hasNoForbiddenPair = true;

            for (int i = 0; i < w.length(); ++i) {
                String c = w.charAt(i) + "";
                if (i > 0) {
                    String prev = w.charAt(i - 1) + "";
                    if (c.equals(prev)) {
                        containsEqualPair = true;
                    }
                    String s = prev + c;
                    if (s.equals("ab") || s.equals("cd") || s.equals("pq") || s.equals("xy")) {
                        hasNoForbiddenPair = false;
                    }
                }
                if ("aeiou".contains(c)) {
                    vovels++;
                    if (vovels >= 3) {
                        contains2Vovels = true;
                    }
                }
            }

            if (contains2Vovels && containsEqualPair && hasNoForbiddenPair) {
                count++;
            }
        }

        return count + "";
    }
}
