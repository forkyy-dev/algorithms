package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class K번째수 {
    public static int[] solution(int[] array, int[][] commands) {
        List<Integer> list = new ArrayList<>();

        for (int[] command : commands) {
            int start = command[0];
            int end = command[1];
            int target = command[2];
            int[] arr = (Arrays.copyOfRange(array, start-1, end));
            Arrays.sort(arr);
            Arrays.stream(arr).forEach(System.out::println);
            list.add(arr[target-1]);
        }
        return list.stream().mapToInt(s -> s).toArray();
    }
}

//1. commands의 길이만큼 반복문을 돌린다.
//2. 각 command에서 요구한 길이대로 자른 배열을 정렬한다.
//3. 목표 위치의 값을 list에 저장한다.
//4. list를 배열 형태로 반환한다.