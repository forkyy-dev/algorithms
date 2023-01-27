package programmers.level1;

import java.util.*;

public class MockExam {
    public int[] solution(int[] answers) {
        int[] answer = {0,0,0};
        int[][] caseList = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

        for(int i=0; i<caseList.length; i++){
            for(int j=0; j<answers.length; j++){
                if(answers[j] == caseList[i][j%caseList[i].length]){
                    answer[i] += 1;
                }
            }
        }

        int max = Arrays.stream(answer).max().getAsInt();

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<answer.length; i++){
            if(answer[i] == max){
                list.add(i+1);
            }
        }
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }

        return result;
    }


}
