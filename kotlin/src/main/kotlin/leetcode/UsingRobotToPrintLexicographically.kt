package leetcode

import java.util.Stack

class UsingRobotToPrintLexicographically {
    fun robotWithString(s: String): String {

        /*1. 남은 단어들 중 꺼낼 수 있는 가장 작은 알파벳값을 각각 저장한다.
        ex) s = "bsagd" / t = ""
        b, s, a, g, d 순서대로 Stack에 저장된다.

        b -> 이때는 나올 수 있는 가장 작은 알파벳은 a다.
        s -> 마찬가지
        a -> 마찬가지
        g -> a가 이미 나왔기 때문에 이후로는 d밖에 없다.
        d -> 무조건 자기 자신이다.

        [a, a, a, d, d]라는 해당 시점 최소값을 담은 결과를 만들 수 있다.
        해당 결과를 바탕으로 계산을 한다면 stack에 b -> s -> a까지 등록하고,

        1. a를 pop한다.
        2. 이후 g -> d까지 등록한다.
        3. 더이상 s에 남은 단어가 없기 때문에 스택에서 하나씩 pop해서 추가한다.
        */

        val alphabets = s.toCharArray()
        val minArray = IntArray(s.length)
        minArray[s.length - 1] = alphabets.last().code

        for (i in alphabets.size - 2 downTo 0) {
            minArray[i] = minOf(alphabets[i].code, minArray[i + 1])
        }

        val stack = Stack<Int>()
        val result = StringBuilder()

        for (i in alphabets.indices) {
            stack.push(alphabets[i].code)
            while (
                stack.isNotEmpty()
                && i != alphabets.size - 1
                && minArray[i + 1] >= stack.peek()
            ) {
                result.append(stack.pop().toChar())
            }
        }

        if (stack.isNotEmpty()) {
            while (stack.isNotEmpty()) {
                result.append(stack.pop().toChar())
            }
        }

        return result.toString()
    }
}