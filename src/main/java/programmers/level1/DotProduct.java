package programmers.level1;

public class DotProduct {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i=0; i<a.length; i++){
            answer += a[i]*b[i];
        }
        return answer;
    }
}


//answer에다가 각 배열에서 같은 인덱스를 가진 값의 곱을 더한다.