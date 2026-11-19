package solutions.season2015;

import solutions.Solution;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Day12a implements Solution {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");


    @Override
    public String solve(Scanner sc) {

        long sum = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            
            Matcher matcher = NUMBER_PATTERN.matcher(line);
            while (matcher.find()) {
                sum += Integer.parseInt(matcher.group());
            }
        }

        return sum + "";
    }
}
