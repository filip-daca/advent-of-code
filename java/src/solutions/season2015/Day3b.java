package solutions.season2015;

import solutions.Solution;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day3b implements Solution {
    @Override
    public String solve(Scanner sc) {
        Set<String> visited = new HashSet<>();
        int[] x = new int[2];
        int[] y = new int[2];
        int j = 0;

        visited.add(x[j] + "x" + y[j]);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            for (int i = 0; i < line.length(); ++i) {
                char c = line.charAt(i);

                if (c == 'v') {
                    y[j]--;
                } else if (c == '^') {
                    y[j]++;
                } else if (c == '<') {
                    x[j]--;
                } else if (c == '>') {
                    x[j]++;
                }

                visited.add(x[j] + "x" + y[j]);
                j = j == 0 ? 1 : 0;
            }
        }

        return visited.size() + "";
    }
}
