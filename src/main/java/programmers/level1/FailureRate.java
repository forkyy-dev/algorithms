package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class FailureRate {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<Rate> list = new ArrayList<>();

        for(int i=1; i<=N; i++){
            //실패율 : stages.filter(s->s==i).count() / stages.filter(s->s>=i).count();
            final int f = i;
            int a = (int)Arrays.stream(stages).filter(s->s==f).count();
            int b = (int)Arrays.stream(stages).filter(s->s>=f).count();

            double failure = 0;
            if(b != 0){
                failure = (double) a/b;
            }

            //스테이지 넘버는 i
            list.add(new Rate(i, failure));
            //Rate객체를 만들어서 리스트에 추가.
        }

        list.sort( Comparator.comparing(Rate::getFailure).reversed().thenComparing(Rate::getStageNumber));
        //list를 failure 높은 순으로, 만약 동일하면 stageNumber가 작은 순으로 정렬을 한다.

        int count = 0;
        for(Rate a : list){
            answer[count]  = a.getStageNumber();
            count++;
        }

        return answer;
    }

    class Rate{
        public final int stageNumber;
        public final double failure;

        public Rate(int stageNumber, double failure) {
            this.stageNumber = stageNumber;
            this.failure = failure;
        }

        public double getFailure() {
            return failure;
        }

        public int getStageNumber() {
            return stageNumber;
        }
    }
}

// 1. 중복값을 제거한 배열 A를 만든다.
// 2. for문을 통해 A를 순환한다.
// 3. Stream으로 A[i]값의 개수 / Arrays.stream().filter(s -> s>=A[i]).count 값이 실패율
// 4. Rate객체를 만든다.
// 5. 순서대로 배열에 담아서
