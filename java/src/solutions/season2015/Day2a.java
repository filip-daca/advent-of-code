package solutions.season2015;

import solutions.Solution;

import java.util.Arrays;
import java.util.Scanner;

public class Day2a implements Solution {
    @Override
    public String solve(Scanner sc) {
        long area = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] dimensionsStrings = line.split("x");
            int[] d = new int[3];

            for (int i = 0; i<3; i++) {
                d[i] = Integer.parseInt(dimensionsStrings[i]);
            }

            Arrays.sort(d);

            area += (long) d[0] * d[1] * 3 + (long) d[1] * d[2] * 2 + (long) d[2] * d[0] * 2;
        }

        return area + "";
    }
}
