package programmers.level1;

import java.util.Arrays;

public class DropoutPerson {
    public String solution(String[] participant, String[] completion) {

        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;
        for (i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        return participant[i];


    }
}


// class Solution {
//     public String solution(String[] participant, String[] completion) {
//         String answer = "";
//         HashMap<String, Integer> hashmap = new HashMap<>();

//         for(String name : participant){
//             hashmap.put(name, hashmap.getOrDefault(name,0)+1);
//         }
//         for(String name : completion){
//             hashmap.put(name, hashmap.get(name)-1);
//         }

//         for(String key : hashmap.keySet()){
//             if(hashmap.get(key)!=0){
//                 answer = key;
//                 break;
//             }
//         }


//         return answer;
//     }
// }

