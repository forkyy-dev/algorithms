package programmers.level2;

public class 쿼드압축_후_개수_세기 {

    private static int z = 0;
    private static int o = 0;

    public int[] solution(int[][] arr) {
        recur(arr, 0, 0, arr.length);

        return new int[]{z,o};
    }

    public void recur(int[][] arr, int row, int col, int size) {
        boolean status = true;
        int node = arr[row][col];

        for (int i = 0; i < row + size; i++) {
            for (int j = 0; j < col + size; j++) {
                if (node != arr[i][j]) {
                    status = false;
                    break;
                }
            }
        }
        if(status){
            if(node == 1) o++;
            else z++;
            return;
        }
        recur(arr, row, col, size/2);
        recur(arr, row, col+size/2, size/2);
        recur(arr, row+size/2, col, size/2);
        recur(arr, row+size/2, col+size/2, size/2);
    }

}
