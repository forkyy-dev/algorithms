package leetcode.medium;

public class FindTheLexicographicallyLargestString {

//    public String max = "";
//
//    public String answerString(String word, int numFriends) {
//        bt(0, word, numFriends);
//        return max;
//    }
//
//    public void bt(int index, String word, int sizeLeft) {
//        if (sizeLeft == 1) {
//            String w = word.substring(index);
//            if (w.compareTo(max) > 0) {
//                max = w;
//            }
//            return;
//        }
//
//        for (int i = index + 1;  i <= word.length() - sizeLeft + 1; i++) {
//            String w = word.substring(index, i);
//            if (w.compareTo(max) > 0) {
//                max = w;
//            }
//            bt(i, word, sizeLeft-1);
//        }
//    }

    //BackTracking 방식으로 최초 접근했지만 구현에 실패하고 Solution을 참고하였습니다.
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }

        String max = "";
        int size = word.length() - numFriends + 1;
        char maxChar = word.charAt(0);

        for (char w : word.toCharArray()) {
            if (w > maxChar) maxChar = w;
        }

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == maxChar) {
                int pieceSize = i + size;
                if (pieceSize <= word.length()) {
                    String piece = word.substring(i, pieceSize);
                    if (piece.compareTo(max) > 0) max = piece;
                } else {
                    String piece = word.substring(i);
                    if (piece.compareTo(max) > 0) max = piece;
                }
            }
        }

        return max;
    }
}

/*
word = abcde / numFriends = 3

가능한 경우의 수
[a, b, cde
a, bc, de
a, bcd, e
ab, c, de
ab, cd, e
abc, d, e]


bt(index = 0, word, size = word.length - numFriends + 1);

---
//남은 조각 for문을 돌리면 될듯.

1. w = a가 됨 -> set에 'a' 삽입
2. remainWord = 'bcde'가 됨.
3. bt 반복
    -

 */
