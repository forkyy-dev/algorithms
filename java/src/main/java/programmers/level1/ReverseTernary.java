package programmers.level1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseTernary {
    public int solution(int n) {
        String answer = "";

        while(n!= 0){
            answer+= n % 3;
            n/=3;

        }

        return Integer.parseInt(answer,3);
    }

}
