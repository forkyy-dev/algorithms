package leetcode.medium;

public class LexicographicallySmallestEquivalentString {

    int[] parentNode = new int[26];
    int startInt = 'a';

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        //최초 자신의 부모는 자기 자신.
        for (int i = 0; i < 26; i++) {
            parentNode[i] = (startInt + i);
        }

        //s1과 s2를 비교하면서 parentNode 설정
        for (int i = 0; i < s1.length(); i++) {
            int c1 = s1.charAt(i) - startInt;
            int c2 = s2.charAt(i) - startInt;
            union(c1, c2);
        }

        StringBuilder result = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            char parent = (char) (find(c - startInt) + startInt);
            result.append(parent);
        }

        return result.toString();
    }

    private void union(int first, int second) {
        int firstParent = find(first);
        int secondParent = find(second);

        if (firstParent == secondParent) {
            return;
        }

        if (firstParent < secondParent) {
            parentNode[secondParent] = firstParent;
            return;
        }

        parentNode[firstParent] = secondParent;
    }

    private int find(int target) {
        if (parentNode[target] != target) {
            parentNode[target] = find(parentNode[target]);
        }
        return parentNode[target];
    }
}

/*
s1 = parker
s2 = morris
baseStr = parser

union find algorithm
가장 작은 알파벳을 Parent Node로 설정하고 baseStr의 단어들을 Parent Node들의 조합으로 구성하기.


 */
