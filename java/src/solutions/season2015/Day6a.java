package solutions.season2015;

import solutions.Solution;

import java.util.Arrays;
import java.util.Scanner;

public class Day6a implements Solution {

    boolean[][] lights = new boolean[1000][1000];

    private void turn(Boolean on, int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; ++i) {
            for (int j = y1; j <= y2; ++j) {
                if (on == null) {
                    lights[i][j] = !lights[i][j];
                } else {
                    lights[i][j] = on;
                }
            }
        }
    }

    @Override
    public String solve(Scanner sc) {

        while (sc.hasNextLine()) {
            String w = sc.nextLine();

            Boolean on = null;
            if (w.contains("turn on")) {
                on = true;
            } else if (w.contains("turn off")) {
                on = false;
            }

            String[] numbers = w.split("\\D+");
            Integer[] l = Arrays.stream(numbers)
                    .filter(s -> !s.isBlank())
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

            turn(on, l[0], l[1], l[2], l[3]);
        }

        int count = 0;
        for (int i = 0; i < 1000; ++i) {
            for (int j = 0; j < 1000; ++j) {
                if (lights[i][j]) {
                    count++;
                }
            }
        }

        return count + "";
    }
}
