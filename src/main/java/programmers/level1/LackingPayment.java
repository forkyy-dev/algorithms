package programmers.level1;

public class LackingPayment {
    public long solution(int price, int money, int count) {
        long result = price * ((long)count * (1 + count) / 2);

        if(result <= money) {
            return 0;
        }
        else
        {
            return result - (long)money;
        }
    }
}

//count 횟수만큼 price * count를 한다.

