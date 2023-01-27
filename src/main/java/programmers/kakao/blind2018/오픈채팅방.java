package programmers.kakao.blind2018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 오픈채팅방 {
    public String[] solution(String[] record) {

        Map<String, String> userList = new HashMap<>();
        List<String[]> actions = new ArrayList<>();

        for (String r : record) {
            String[] splitRecord = r.split(" ");

            if (splitRecord[0].equals("Enter")) {
                userList.put(splitRecord[1], splitRecord[2]);
                actions.add(new String[]{splitRecord[0], splitRecord[1]});
            } else if (splitRecord[0].equals("Change")) {
                userList.put(splitRecord[1], splitRecord[2]);
            } else {
                actions.add(new String[]{splitRecord[0], splitRecord[1]});
            }
        }

        String[] answer = new String[actions.size()];

        for (int i = 0; i < actions.size(); i++) {
            String action = actions.get(i)[0];
            String id = actions.get(i)[1];
            if (action.equals("Enter")) {
                answer[i] = userList.get(id) + "님이 들어왔습니다.";
            } else {
                answer[i] = userList.get(id) + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}

//key: id, value: name으로 저장하는 Map객체 생성
//입장, 퇴장을 기록할 List객체 생성 (동작과 id를 배열 형태로 저장)
//
//1. 반복문을 돌면서 기록을 저장
//- Enter일 경우 Map에 id와 name을 저장 & List에 id와 동작 저장
//- Change일 경우 Map에 저장된 name을 변경
//- Leave일 경우 List에 id와 동작 저장
//
//2. 배열에 결과값을 저장
//- actions List에서 동작과 id값 꺼내온 뒤, Map에서 해당하는 name을 꺼내와서 배열에 저장
