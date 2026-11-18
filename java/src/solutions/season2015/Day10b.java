package solutions.season2015;

import solutions.Solution;

import java.util.Scanner;


public class Day10b implements Solution {

    private String explode(String input) {
        StringBuffer sb = new StringBuffer();

        int i = 0;
        while (i < input.length()) {
            int j = 1;
            while (i + j < input.length() && input.charAt(i + j) == input.charAt(i)) {
                j++;
            }
            sb.append(j);
            sb.append(input.charAt(i));
            i += j;
        }

        return sb.toString();
    }

    @Override
    public String solve(Scanner sc) {

        int len = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            for (int i = 0; i < 50; ++i) {
                line = explode(line);
            }
            len = line.length();
        }
        
        return len + "";
    }
}
