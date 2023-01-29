package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ13072 {

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int[] beers = new int[sc.nextInt()];
        int members = sc.nextInt();

        for (int i = 0; i < beers.length; i++) {
            beers[i] = sc.nextInt();
        }
        Arrays.sort(beers);

        long result = helper(beers, 0, beers[beers.length - 1], members);

        System.out.println(result);
    }

    public static long helper(int[] arr, long start, long end, int members) {
        long result = 0;
        while (start <= end) {
            int count = 0;
            long mid = (start + end) / 2;
            for (int i = 0; i < arr.length; i++) {
                count += arr[i] / mid;
            }
            if (count < members) {
                end = mid - 1;
            } else {
                result = mid;
                start = mid + 1;
            }
        }
        return result;
    }
}

//N개의 막걸리 주전자. - 각각의 용량은 랜덤
//K명에게 일정하게 나눠줘야함.
//K명에게 최대한 많은 양의 용량을 분배할 수 있는 양은?

//파라메트릭 서치를 이용해서 풀어보자.
//0부터 702 사이의 절반을 시작점으로 잡는다.
//3명에게 나눠줘야한다. -> 각각의 주전자 용량을 절반으로 나눈다.
// 나눈 값을 모두 더했을때, k보다 크면 용량을 높인다.
// k보다 적으면 용량을 높인다.

//실패했던 케이스
//막거리 양의 크기를 제대로 보지 않아서 int타입을 사용했음.
//조건문 순서를 바꾸니 해결.