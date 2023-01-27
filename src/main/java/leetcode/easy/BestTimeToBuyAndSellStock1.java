package leetcode.easy;

public class BestTimeToBuyAndSellStock1 {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int result = 0;

        for (int i = 1; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            } else if (result < prices[i] - min) {
                result = prices[i] - min;
            }
        }
        return result;
    }
    //수도 코드
//최소값을 둔다.
//최소값보다 현재값이 더 작으면 최소값을 현재값으로 변경한다.
//결과 값은 0으로 초기화한다.
//현재값에서 최소값을 빼서 결과값보다 클 경우 결과값을 바꾼다.
}
