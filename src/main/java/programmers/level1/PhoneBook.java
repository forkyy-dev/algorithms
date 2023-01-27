package programmers.level1;

import java.util.Arrays;


public class PhoneBook {
    public boolean solution(String[] phone_book) {


        Arrays.sort(phone_book);

        for(int i=0; i<phone_book.length; i++){
            for(int j=i+1; j<phone_book.length; j++){
                if(phone_book[j].startsWith(phone_book[i])){
                    return false;
                }
            }
        }

        return true;
    }
}


//1. 길이를 기준으로 sort한다.
//2. 2중 for문을 돌면서 앞의 접두어인지 확인한다.
