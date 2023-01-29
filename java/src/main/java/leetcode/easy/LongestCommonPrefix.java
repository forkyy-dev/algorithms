package leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        List<String> list = Arrays.stream(strs).sorted(Comparator.comparing(s -> s.length())).collect(Collectors.toList());

        String pivot = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            while (!list.get(i).contains(pivot)) {
                pivot = pivot.substring(0, pivot.length()-1);
            }
            if (pivot.length() == 0) {
                break;
            }
        }
        return pivot;
    }
}


//1. 배열을 정렬한다.
//2. 가장 짧은 문자열을 기준으로 삼는다.
//3. 각 단어들에 포함된 기준단어가 있는지 검사한다.
//4. 없을경우 기준 단어의 길이를 줄인다.
//5. 기준 단어의 길이가 0이면 break;