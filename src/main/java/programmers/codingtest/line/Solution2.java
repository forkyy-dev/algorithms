package programmers.codingtest.line;

public class Solution2 {
    public String solution(int k, String[] dic, String chat) {
        String answer = "";



        return answer;
    }
}

//단어사전 참고해서 비속어 걸러내기
//완벽히 일치하는 단어의 경우 #으로 대체
//단어에 포함된 .을 k개 이하 길이의 알파벳으로 대체 시 비속어면 #으로 대체

//제한사항
// 1 <= k <=5
// 1 <= dic <= 50 -> 단어에 중복 없음 / 소문자 / 한 단어의 길이 <= 10
// chat은 공백으로 구분 -> 개수 <= 500 / 한 단어의 길이 <= 10

//풀이
//단어가 .을 내포하고 있다면
//
//chat을 돌면서 dic에 있는 단어와 100프로 일치하는 단어인지 검사
//