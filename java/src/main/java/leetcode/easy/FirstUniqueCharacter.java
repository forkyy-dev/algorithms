package leetcode.easy;

public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        if(s.length()==1){
            return 0;
        }
        String[] arr = s.split("");
        for(int i=0; i<s.length(); i++){
            if(s.indexOf(arr[i])==s.lastIndexOf(arr[i])){
                return i;
            }
        }
        return -1;
    }
}
