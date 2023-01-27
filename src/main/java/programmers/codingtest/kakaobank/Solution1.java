package programmers.codingtest.kakaobank;

public class Solution1 {
    public int[] solution(String logs){
        int[] answer = new int[24];

        String[] logArr = logs.split("\n");

        for (String log : logArr) {

            String[] l = log.split(" ");
            int hour = Integer.parseInt(l[1].split(":")[0]);

            hour += 9;
            if (hour > 23) {
                hour -= 24;
            }
            answer[hour]++;

        }

        return answer;
    }
}

/*
오토 스케일링 계획하기

YYYY/MM/DD hh:mm:ss 형식의 로그
한국은 로그의 시간 + 9를 해야 올바른 시간

0시~23시까지 각 시간대별로 로그가 몇개 찍혔는지 반환하기
input은 문자열 배열로
 */