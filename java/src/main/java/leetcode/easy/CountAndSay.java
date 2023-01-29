package leetcode.easy;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        StringBuilder sb = new StringBuilder();
        String s = countAndSay(n - 1);
        char number = s.charAt(0);
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            if (number == c) {
                count++;
                continue;
            }

            sb.append(count).append(number);
            number = c;
            count = 1;
        }

        sb.append(count).append(number);

        return sb.toString();
    }
}


//1. 1이 1개 있기때문에 11
//2. 1이 2개 있기 때문에 21
//3. 2가 1개, 1이 1개 있기때문에 1211
//4. 1이 1개, 2가 1개, 1이 2개 111221
//5. 재귀로 푼다.