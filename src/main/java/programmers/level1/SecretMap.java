package programmers.level1;

public class SecretMap {
    public final String poundKey = "#";
    public final String blank = " ";
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            answer[i] = checkStrings(n,arr1[i], arr2[i]);
        }
        return answer;
    }

    public String checkStrings(int n, int num1, int num2){
        String n1 = Integer.toBinaryString(num1);
        String n2 = Integer.toBinaryString(num2);

        if(n1.length() <n){
            while(n1.length()!=n){
                n1 ="0" + n1;
            }
        }
        if(n2.length() <n){
            while(n2.length()!=n){
                n2 ="0" + n2;
            }
        }

        String answer = "";
        for(int i=0; i<n1.length(); i++){
            if(n1.charAt(i) == '1' || n2.charAt(i) == '1' ){
                answer+=poundKey;
            }else{
                answer+=blank;
            }
        }
        return answer;
    }
}

// result라는 배열을 만든다.
// for문을 통해서
// Integer.toBinary를 사용
// Helper함수를 통해 2개의 2진수를 받고 String으로 변환해서 각 자리를 검사.
// 결과값을 String으로 만들어서 반환한다.
//

