package solutions.season2015;

import solutions.Solution;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Day12b implements Solution {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");

    private String removeObject(String input, int p) {
        int i = p;
        int j = p;

        int open = 1;
        while (open > 0 && i > 0) {
            if (input.charAt(i) == '}') {
                open++;
            } else if (input.charAt(i) == '{') {
                open--;
            }
            i--;
        }

        open = 1;
        while (open > 0 && j < input.length()) {
            if (input.charAt(j) == '}') {
                open--;
            } else if (input.charAt(j) == '{') {
                open++;
            }
            j++;
        }

        return input.substring(0, i) + input.substring(j);
    }

    @Override
    public String solve(Scanner sc) {

        long sum = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            while (line.contains(":\"red\"")) {
                line = removeObject(line, line.indexOf(":\"red\""));
            }

            Matcher matcher = NUMBER_PATTERN.matcher(line);
            while (matcher.find()) {
                sum += Integer.parseInt(matcher.group());
            }
        }

        return sum + "";
    }
}
