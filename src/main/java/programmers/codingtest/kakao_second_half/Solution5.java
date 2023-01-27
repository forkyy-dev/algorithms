package programmers.codingtest.kakao_second_half;

public class Solution5 {



    public String[] solution(String[] commands) {
        String[] answer = {};

        String[][] map = new String[51][51];

        for (int i = 0; i < commands.length; i++) {
            String[] command = commands[i].split(" ");
            String type = command[0];

            switch (type) {
                case "UPDATE": {
                    if (command.length == 4) {
                        int r = Integer.parseInt(command[1]);
                        int c = Integer.parseInt(command[2]);
                        map[r][c] = command[3];
                        break;
                    }
                    //모든 value1을 value2로!

                    break;
                }
                case "MERGE":{
                    int r1 = Integer.parseInt(command[1]);
                    int c1 = Integer.parseInt(command[2]);
                    int r2 = Integer.parseInt(command[3]);
                    int c2 = Integer.parseInt(command[4]);



                    break;
                }
                case "UNMERGE":

                    break;
                default:

                    break;
            }
        }

        //update
        //1. 좌표만 주어질때
        //2. 단어가 주어질때

        //merge

        return answer;
    }

}
