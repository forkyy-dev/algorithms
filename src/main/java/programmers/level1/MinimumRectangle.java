package programmers.level1;

public class MinimumRectangle {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        for (int[] size : sizes) {
            int w = size[0] > size[1] ? size[0] : size[1];
            int h = size[0] > size[1] ? size[1] : size[0];

            maxWidth = Math.max(maxWidth, w);
            maxHeight = Math.max(maxHeight, h);
        }

        return maxWidth * maxHeight;
    }
}

//가로 길이 중 최대값, 세로 길이 중 최대값을 구한다.
//만약 세로가 가로보다 길면 앞뒤를 바꾼다.
//배열을 돌면서 현재 저장된 값과 비교해서 값을 대체한다.