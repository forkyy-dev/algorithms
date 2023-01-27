package programmers.level1;

public class SumOfPlusMinus {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i=0; i<signs.length; i++){
            if(signs[i]){
                answer += absolutes[i];
            }else{
                answer -= absolutes[i];
            }
        }
        return answer;
    }
}
//수도코드
//signs 배열을 돌면서 true absolutes의 해당 인덱스를 더하고 아니면 뺀다.
