package leetcode.easy;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] m = new int[n+1];
        m[0] = 1;
        m[1] = 1;
        for(int i=2; i<=n; i++){
            m[i] = m[i-1] + m[i-2];
        }
        return m[n];
    }
}
//수도코드
//4의 경우 2의 경우의 수  + 3의 경우의 수다.
//즉, 자신의 앞의 숫자들의 경우의 수를 더한다.
// n = (n-1) + (n-2)
