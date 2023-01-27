package programmers.codingtest.devmatching;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    public static Map<String, String> map = new HashMap<>();

    public String solution(String[] registered_list, String new_id) {

        for (String s : registered_list) {
            map.put(s, s);
        }

        if (!checkDuplicate(new_id)) {
            return new_id;
        }

        String newId = new_id;
        while (true) {
            newId = createNewId(newId);
            if (!checkDuplicate(newId)) {
                return newId;
            }

        }
    }

    private boolean checkDuplicate(String new_id) {
        return map.containsKey(new_id);
    }

    private String createNewId(String new_id) {
        StringBuilder word = new StringBuilder();
        StringBuilder num = new StringBuilder();

        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if (Character.isAlphabetic(c)) {
                word.append(c);
            }else{
                num.append(c);
            }
        }
        String newNumber = num.length() == 0 ? "1" : String.valueOf(Integer.parseInt(num.toString()) + 1);
        return word.append(newNumber).toString();
    }
}
