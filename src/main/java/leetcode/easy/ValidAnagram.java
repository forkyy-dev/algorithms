package leetcode.easy;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] memory = new int[256];

        for(int i=0; i<s.length(); i++){
            memory[(int)s.charAt(i)]++;
        }
        for(int i=0; i<t.length(); i++){
            memory[(int)t.charAt(i)]--;
        }
        for(int i=0; i<memory.length; i++){
            if(memory[i]!=0){
                return false;
            }
        }
        return true;
    }
}
