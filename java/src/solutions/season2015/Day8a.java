package solutions.season2015;

import solutions.Solution;

import java.util.Scanner;


public class Day8a implements Solution {

    @Override
    public String solve(Scanner sc) {

        long code = 0;
        long mem = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            StringBuilder sb = new StringBuilder();
            int i = 1;
            while (i < line.length() - 1) {
                if (i < line.length() - 2 && line.startsWith("\\\\", i)) {
                    sb.append('\\');
                    i += 2;
                } else if (i < line.length() - 2 && line.startsWith("\\\"", i)) {
                    sb.append('\"');
                    i += 2;
                } else if (i < line.length() - 4 && line.startsWith("\\x", i)) {
                    sb.append('\'');
                    i += 4;
                } else {
                    sb.append(line.charAt(i));
                    i++;
                }
            }

            String computed = sb.toString();

            mem += computed.length();
            code += line.length();
        }

        return code - mem + "";
    }
}
