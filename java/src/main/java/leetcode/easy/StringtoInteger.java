package leetcode.easy;


import java.util.Arrays;
import java.util.List;

public class StringtoInteger {
    public int myAtoi(String s) {
        s = s.trim();
        if (s == null || s.isEmpty()) { return 0; }

        char[] chars = s.toCharArray();
        int signum = 1, head = 0;
        if (chars[head] == '+' || chars[head] == '-') { // treat sign
            if (chars[head] == '-') { signum = -1; }
            head++;
        }

        long result = 0l;
        long max = (long)Integer.MAX_VALUE;
        long min = (long)Integer.MIN_VALUE;
        while (head < chars.length && Character.isDigit(chars[head])) {
            result = (result * 10) + (((int)chars[head++]-'0') * signum); // char '0' = int 48, in ascii
            if (result > 0 && result > max) { result = max; break; }
            if (result < 0 && result < min) { result = min; break; }
        }
        return (int)result;
    }
}

