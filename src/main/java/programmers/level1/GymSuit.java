package programmers.level1;

import java.util.Arrays;

public class GymSuit {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 여벌 체육복을 가져온 학생이 도난당한 경우
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        // 도난당한 학생에게 체육복 빌려주는 경우
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if ((lost[i] - 1 == reserve[j]) || (lost[i] + 1 == reserve[j])) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }

}

//1. 전체 학생 수 n의 길이를 가진 배열을 만든다.
//2. lost 위치는 0, reserve의 위치는 2로 설정.
//3. 배열을 순회하면서 앞이나 뒤에 2가 있으면 lost의 위치와 2인 값을 1로 바꾼다.
//4. 0보다 큰 숫자의 개수를 센다.
