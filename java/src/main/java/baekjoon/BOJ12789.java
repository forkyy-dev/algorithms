package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BOJ12789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cur = 1;
        String[] stringNumbers = br.readLine().split(" ");
        Queue<Integer> queue = new LinkedList<>();

        for (String stringNumber : stringNumbers) {
            queue.add(Integer.parseInt(stringNumber));
        }

        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty()) {
            int num = queue.peek();
            if (cur == num) {
                queue.poll();
                cur++;
            } else {
                if (!stack.isEmpty()) {
                    if (cur == stack.peek()) {
                        stack.pop();
                        cur++;
                        continue;
                    }
                }
                stack.add(queue.poll());
            }
        }

        while (!stack.isEmpty()) {
            int num = stack.pop();
            if (cur == num) {
                cur++;
                continue;
            }
            break;
        }

        if (stack.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }

}
