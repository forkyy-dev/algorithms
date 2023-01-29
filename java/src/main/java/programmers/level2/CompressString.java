package programmers.level2;

public class CompressString {
    public static void main(String[] args) {
        CompressString f = new CompressString();
        f.solution("aabbaccc");
//        System.out.println(f.solution("aabbaccc"));
    }

    public int solution(String s) {
        int answer = 1000;
        int max = s.length() / 2;

        for (int i = 1; i < max; i++) {
            int count = 1;
            String current, next;
            String l = "";
            for (int j = 0; j < s.length()-i; j += i) {
                int mid = j + i;
                int end = j+(i*2) > s.length() ? s.length() : j+(i*2);
                current = s.substring(j, mid);
                next = s.substring(mid, end);

                System.out.println("c = " + current);
                System.out.println("n = " + next);
                System.out.println();

                boolean canCompress = current.equals(next);
                if (canCompress) {
                    System.out.println("hahah!!!");
                    count++;
                }else{
                    if (count == 1) {
                        l += current;
                    }else{
                        l += count + current;
                    }
                    count = 1;
                }
            }
            System.out.println(l);
            if (l.length() < answer) {
                answer = l.length();
            }
        }
        return answer;
    }
}

//aabbaccc
//1,2,3,4가 최대.
//이 이상은 압축 불가능

//ababcdcdababcdcd
//현재 압축 단위로 비교.
//같으면 카운트 1을 더한다.
//다르면? 카운트를 저장하고 현재 문자값을 변경한다.
