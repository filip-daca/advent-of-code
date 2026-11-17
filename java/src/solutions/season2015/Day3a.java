package solutions.season2015;

import solutions.Solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day3a implements Solution {
    @Override
    public String solve(Scanner sc) {
        Set<String> visited = new HashSet<>();
        int x = 0;
        int y = 0;

        visited.add(x + "x" + y);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            for (int i = 0; i < line.length(); ++i) {
                char c = line.charAt(i);

                if (c == 'v') {
                    y--;
                } else if (c == '^') {
                    y++;
                } else if (c == '<') {
                    x--;
                } else if (c == '>') {
                    x++;
                }

                visited.add(x + "x" + y);
            }
        }

        return visited.size() + "";
    }
}
