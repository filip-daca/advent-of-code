package solutions.season2015;

import solutions.Solution;

import java.util.Scanner;

public class Day1a implements Solution {
    @Override
    public String solve(Scanner sc) {
        int floor = 0;

        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == '(') {
                    floor++;
                } else if (c == ')') {
                    floor--;
                }
            }
        }

        return String.valueOf(floor);
    }
}
