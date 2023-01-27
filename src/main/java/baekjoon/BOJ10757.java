import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ10757 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] numbers = input.split(" ");
        StringBuilder answer = new StringBuilder();
        List<String> s1 = reverse(numbers[0]);
        List<String> s2 = reverse(numbers[1]);

        int maxLength = Math.max(s1.size(), s2.size());

        if (s1.size() != maxLength) {
            s1 = extendSize(s1, maxLength - s1.size());
        }
        if (s2.size() != maxLength) {
            s2 = extendSize(s2, maxLength - s2.size());
        }

        int carry = 0;

        for (int i = 0; i < maxLength; i++) {
            int sum = Integer.parseInt(s1.get(i)) + Integer.parseInt(s2.get(i)) + carry;
            if (sum > 9) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            answer.append(sum);
        }
        if (carry == 1) {
            answer.append(carry);
        }
        System.out.println(answer.reverse());

    }

    public static List<String> extendSize(List<String> list, int num) {
        for (int i = 0; i <= num; i++) {
            list.add("0");
        }
        return list;
    }

    public static List<String> reverse(String number) {
        List<String> result = new ArrayList<>();

        for (int i = number.length() - 1; i >= 0; i--) {
            result.add(String.valueOf(number.charAt(i)));
        }
        return result;
    }
}