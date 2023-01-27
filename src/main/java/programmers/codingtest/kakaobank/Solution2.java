package programmers.codingtest.kakaobank;

public class Solution2 {
    public int solution(int money, int minratio, int maxratio, int ranksize, int threshold, int months) {

        if (maxratio == 0 || money == 0) {
            return money;
        }

        int startPoint = threshold + ranksize;

        for (int i = 0; i < months; i++) {
            StringBuilder sb = new StringBuilder(String.valueOf(money));
            sb.replace(sb.length() - 2, sb.length(), "00");
            int expectMoney = Integer.parseInt(sb.toString());

            if (expectMoney < threshold) {
                break;
            }

            double percent;
            if (expectMoney < startPoint) {
                percent = minratio * 0.01;
            }else{
                int overMoney = expectMoney - threshold;
                percent = ((overMoney / ranksize) + minratio)* 0.01;

                if (percent >= maxratio * 0.01) {
                    percent = maxratio * 0.01;
                }
            }
            money = (money - (int)(expectMoney * percent));
        }
        return money;
    }

    public static void main(String[] args) {
        Solution2 app = new Solution2();
        app.solution(12345678, 10, 20, 250000, 10000000, 4);
//        app.solution(1000000000, 50, 99, 100000, 0, 6);
    }
}


/*
<세금 정책 시뮬레이션>

소유금액 : m
세금 계산은 m의 백의 자리 미만을 버림하고 계산한다.
ex) 21,025,667 -> 21,025,600

- threshold 미만이면 세금 안걷음
- 이상일 경우 threshold로부터 ranksize 단위만큼 올라갈때마다 1% 추가
- 최대 퍼센트는 maxratio

threshold ~ threshold + ranksize -1 -> minratio 만큼 걷음
months만큼 시뮬 돌림

 */