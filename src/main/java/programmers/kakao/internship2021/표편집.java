package programmers.kakao.internship2021;

import java.util.Stack;

public class 표편집 {

    public String solution(int n, int k, String[] cmd) {
        int point = k;
        int currentData = n;
        StringBuilder result = new StringBuilder();
        Stack<Integer> history = new Stack<>();

        for (int i = 0; i < cmd.length; i++) {
            String[] commands = cmd[i].split(" ");

            String command = commands[0];

            if (command.equals("U")) {
                point -= Integer.parseInt(commands[1]);
            } else if (command.equals("D")) {
                point += Integer.parseInt(commands[1]);
            } else if (command.equals("C")) {
                history.add(point);
                currentData--;
                if (point == currentData) {
                    point--;
                }
            } else {
                int h = history.pop();
                if (h <= point) {
                    point++;
                }
                currentData++;
            }

        }


        result.append("O".repeat(Math.max(0, currentData)));
        while (!history.isEmpty()) {
            result.insert(history.pop(), "X");
        }
        return result.toString();

    }
}

/*
0 1 2 3 4 5 6 7
0 1 3 4 5 6 7 -> stack = { 2 }
0 1 4 5 6 7 -> stack = { 2, 2 }
 */
