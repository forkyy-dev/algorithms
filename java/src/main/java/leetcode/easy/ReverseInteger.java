package leetcode.easy;

public class ReverseInteger {
    public int reverse(int x) {
        int temp = x;
        long result = 0;

        while (temp != 0) {
            result = result * 10 + temp % 10;
            temp /= 10;
        }
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }
        return (int)result;
    }
}




