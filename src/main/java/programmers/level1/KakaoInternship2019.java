package programmers.level1;

import java.util.Stack;

public class KakaoInternship2019 {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> bucket = new Stack<>();
        int answer = 0;
        for (int move : moves) {
            int item = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][move - 1] != 0) {
                    item = board[i][move - 1];
                    board[i][move - 1] = 0;
                    break;
                }
            }
            if (item == 0) {
                continue;
            }
            if (!bucket.isEmpty() && bucket.peek() == item) {
                bucket.pop();
                answer += 2;
            } else {
                bucket.push(item);
            }
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}

//1. moves 배열을 순회하면서 각 move에 맞는 row에서 데이터를 꺼내온다.
//2. 꺼낸 데이터는 stack에 넣고 해당 위치는 0으로 변경한다.
//3. stack에 담을때 stack.peek()으로 값을 확인해서 동일한 값이면 제거한다.


//[[0,0,0,0,0],
// [0,0,1,0,3],
// [0,2,5,0,1],
// [4,2,4,4,2],
// [3,5,1,3,1]]