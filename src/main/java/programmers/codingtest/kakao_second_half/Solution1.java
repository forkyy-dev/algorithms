package programmers.codingtest.kakao_second_half;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {

    private static final int ONE_MONTH = 28;
    private static final int ONE_YEAR = 336;

    public int[] solution(String today, String[] terms, String[] privacies) {

        int todayDate = calculateDays(today);
        Map<String, Integer> termMap = new HashMap<>();
        List<Integer> elapsedPrivacies = new ArrayList<>();


        for (String term : terms) {
            String[] splitTerm = term.split(" ");
            termMap.put(splitTerm[0], Integer.parseInt(splitTerm[1]) * ONE_MONTH);
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            int startDate = calculateDays(privacy[0]);

            int elapsed = Math.abs(todayDate - startDate);
            int max = termMap.get(privacy[1]);

            if (elapsed >= max) {
                elapsedPrivacies.add(i+1);
            }
        }

        Collections.sort(elapsedPrivacies);

        int[] result = new int[elapsedPrivacies.size()];

        for (int i = 0; i < elapsedPrivacies.size(); i++) {
            result[i] = elapsedPrivacies.get(i);
        }

        return result;
    }

    public int calculateDays(String date) {
        String[] splitDate = date.split("\\.");
        String stringYear = splitDate[0].substring(2);

        int year = 0;
        if (!stringYear.equals("00")) {
            year = (Integer.parseInt(stringYear) - 1) * ONE_YEAR;
        }

        int days = Integer.parseInt(splitDate[1]) * ONE_MONTH + Integer.parseInt(splitDate[2]);

        return year + days;
    }

}
//한달은 28일
//0 ~ 22년 사이 -> 한 해는 336일
//년도 = (해당 년도 - 1 ) * 336
//해당 날짜 = (월 * 28) + 일자
//
