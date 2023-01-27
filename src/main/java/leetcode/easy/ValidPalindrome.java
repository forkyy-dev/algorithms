package leetcode.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]","");
        List<String> strList = Arrays.stream(s.split("")).map(str->str.toLowerCase()).collect(Collectors.toList());
        int point1 = 0;
        int point2 = strList.size()-1;

        while(point1 < point2){
            if(!strList.get(point1).equals(strList.get(point2))){
                return false;
            }
            point1++;
            point2--;
        }

        return true;
    }
}


//수도코드
//1. point1 = start, point2 = end
//2. 각 point의 위치를 비교해간다. 둘의 글자가 동일하지 않으면 false.