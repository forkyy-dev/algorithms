package programmers.level2;

public class 주식가격 {

    public int[] solution(int[] prices) {
        int[] board = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < i; j++) {
                if (prices[j] <= prices[i]) {
                    board[j] = board[j] + 1;
                }
            }
        }

        return board;
    }

    public static void main(String[] args) {
        주식가격 app = new 주식가격();

        int[] arr = {1, 2, 3, 2, 3};
        int[] result = app.solution(arr);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
