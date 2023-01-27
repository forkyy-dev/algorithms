package programmers.level1;

public class StrangeWord {
    public String solution(String s) {
        String[] words = s.split(" ",-1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {

            String word = words[i];
            StringBuilder newWord = new StringBuilder();

            for (int j = 0; j < word.length(); j++) {
                if (j % 2 == 0) {
                    newWord.append(Character.toUpperCase(word.charAt(j)));
                }else{
                    newWord.append(Character.toLowerCase(word.charAt(j)));
                }
            }
            sb.append(newWord);
            if (i != words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}


//1. 문자열을 공백 기준으로 split한다. 문자열 뒤에 있는 공백을 고려해서 limit값에 음수를 넣어준다.
//2. 2중 반복문을 사용해서 각 문자열을 인덱스의 홀수, 짝수 여부에 맞게 처리한다.
//3. 변환한 문자열을 sb에 추가하고 마지막 위치가 아니라면 공백을 추가해준다.
