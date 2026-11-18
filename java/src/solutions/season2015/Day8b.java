package solutions.season2015;

import solutions.Solution;

import java.util.Scanner;


public class Day8b implements Solution {

    @Override
    public String solve(Scanner sc) {

        long code = 0;
        long newCode = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            StringBuilder sb = new StringBuilder();
            sb.append('"');
            int i = 0;
            while (i < line.length()) {
                if (line.charAt(i) == '\\') {
                    sb.append("\\\\");
                } else if (line.charAt(i) == '\"') {
                    sb.append("\\\"");
                } else {
                    sb.append(line.charAt(i));
                }
                i++;
            }
            sb.append('"');

            String encoded = sb.toString();
            
            newCode += encoded.length();
            code += line.length();
        }

        return newCode - code + "";
    }
}
