package solutions.season2015;

import solutions.Solution;

import java.util.Scanner;


public class Day11a implements Solution {

    private boolean isValid(char[] chars) {
        boolean has3Straight = false;
        boolean doesNotIncludeInvalidChars = true;
        boolean has2Pairs = false;

        Integer firstPairIndex = null;

        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'l') {
                doesNotIncludeInvalidChars = false;
                break;
            }

            if (!has2Pairs && i + 1 < chars.length && chars[i] == chars[i + 1]) {
                if (firstPairIndex != null && firstPairIndex < i - 1) {
                    has2Pairs = true;
                } else if (firstPairIndex == null) {
                    firstPairIndex = i;
                }
            }

            if (!has3Straight && i + 2 < chars.length && chars[i] == chars[i + 1] - 1 && chars[i] == chars[i + 2] - 2) {
                has3Straight = true;
            }
        }

        return has3Straight && doesNotIncludeInvalidChars && has2Pairs;
    }

    private void next(char[] chars) {
        int carry = 1;
        int i = chars.length - 1;
        while (carry > 0 && i > 0) {
            chars[i] = (char) (chars[i] + carry);
            carry = 0;

            if (chars[i] > 'z') {
                chars[i] = 'a';
                carry = 1;
            }

            i--;
        }
    }

    private String increment(String input) {
        char[] chars = input.toCharArray();

        next(chars);
        while (!isValid(chars)) {
            next(chars);
        }

        StringBuffer sb = new StringBuffer();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }

    @Override
    public String solve(Scanner sc) {

        String incremented = null;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            incremented = increment(line);
        }

        return incremented;
    }
}
