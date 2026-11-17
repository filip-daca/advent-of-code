package solutions.season2015;

import solutions.Solution;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Day4a implements Solution {

    private static boolean startsWithZeros(String input, MessageDigest md) {
        byte[] bytesOfMessage = null;

        try {
            bytesOfMessage = input.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        byte[] md5 = md.digest(bytesOfMessage);

        return toHex(md5).startsWith("00000");
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
