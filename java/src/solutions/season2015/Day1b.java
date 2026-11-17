package solutions.season2015;

import solutions.Solution;

import java.util.Scanner;

public class Day1b implements Solution {
    @Override
    public String solve(Scanner sc) {
        int floor = 0;
        int basementStep = -1;

        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == '(') {
                    floor++;
                } else if (c == ')') {
                    floor--;
                }

                if (floor == -1 && basementStep == -1) {
                    basementStep = i;
                }
            }
        }

        return String.valueOf(basementStep);
    }
}