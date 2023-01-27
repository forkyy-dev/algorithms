package programmers.level1;

import java.util.Arrays;

public class Dart {
    public int solution(String dartResult) {
        char[] arr = dartResult.toCharArray();
        int count = -1;
        int[] list = new int[3];

        for(int i=0; i<arr.length; i++){
            //숫자인지
            if(arr[i]>='0' && arr[i]<='9'){
                count++;
                if(arr[i]=='1' && arr[i+1]=='0'){
                    list[count] = 10;
                    i++;
                }else{
                    list[count] = arr[i]-'0';
                }
            //제곱 조건인지
            }else if(arr[i] == 'D'){
                list[count] *= list[count];
            }else if(arr[i] == 'T'){
                list[count] *= list[count]*list[count];
            //*인지
            }else if(arr[i]=='*'){
                if(count>0){
                    list[count-1] *= 2;
                }
                list[count]*=2;
            //#인지
            }else if(arr[i]=='#'){
                list[count]*=-1;
            }
        }

        return Arrays.stream(list).sum();
    }
}
