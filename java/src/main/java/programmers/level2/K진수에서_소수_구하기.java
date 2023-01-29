package programmers.level2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class K진수에서_소수_구하기 {
    public int solution(int n, int k) {
        int answer = 0;
        String num = Integer.toString(n, k);
        List<String> split = Arrays.stream(num.split("0")).filter(s -> !s.equals("")).collect(Collectors.toList());


        for (String s : split) {
            if(s.equals("1")) continue;
            else if (isPrime(Integer.parseInt(s))) {
                answer++;
            }
        }

        return answer;
    }

    public boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        K진수에서_소수_구하기 a = new K진수에서_소수_구하기();
        System.out.println(a.solution(437674, 3));
    }
}


//n -> k로 바꿨을 때
//Integer.parseInt(n, k);
//0기준으로 split!
//각 수를 소수인지 판별