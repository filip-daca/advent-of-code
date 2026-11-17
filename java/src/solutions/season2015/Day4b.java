package solutions.season2015;

import solutions.Solution;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Day4b implements Solution {

    private static boolean startsWithZeros(String input, MessageDigest md) {
        byte[] bytesOfMessage = null;

        bytesOfMessage = input.getBytes(StandardCharsets.UTF_8);

        byte[] md5 = md.digest(bytesOfMessage);

        return toHex(md5).startsWith("000000");
    }

    private static String toHex(byte[] bytes) {
        BigInteger bi = new BigInteger(1, bytes);
        return String.format("%0" + (bytes.length << 1) + "X", bi);
    }

    @Override
    public String solve(Scanner sc) {
        long l = 0;
        String line = sc.nextLine();

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        while (!startsWithZeros(line + l, md)) {
            l++;
        }

        return l + "";
    }
}
