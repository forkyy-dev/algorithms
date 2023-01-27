package leetcode.easy;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        for (int i = 1; i < result.length; i++) {
            result[i] = 0;
        }
        return result;
    }
    //수도코드
// for문을 사용해서 뒤에서 부터 순회한다.
// 마지막 값이 9가 아니면 1을 더해서 배열을 반환한다.
// 9일 경우 해당 위치를 0으로 바꾼다.
}
