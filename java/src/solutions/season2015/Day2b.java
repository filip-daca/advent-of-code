package solutions.season2015;

import solutions.Solution;

import java.util.Arrays;
import java.util.Scanner;

public class Day2b implements Solution {
    @Override
    public String solve(Scanner sc) {
        long length = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] dimensionsStrings = line.split("x");
            int[] d = new int[3];

            for (int i = 0; i<3; i++) {
                d[i] = Integer.parseInt(dimensionsStrings[i]);
            }

            Arrays.sort(d);

            length += d[0] * 2 + d[1] * 2 + d[0] * d[1] * d[2];
        }

        return length + "";
    }
}
