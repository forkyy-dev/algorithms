package leetcode

import java.util.PriorityQueue

class LexicographicallyMinimumStringAfterRemovingStars {
    fun clearStars(s: String): String {
        val alphabetQueue = PriorityQueue<Int>()
        val alphabetMap = HashMap<Int, ArrayList<Int>>()

        val result = s.toCharArray()
        for(i in s.indices) {
            if (s[i] == '*') {
                result[i] = '-'
                val smallestAlphabet = alphabetQueue.poll()
                println(smallestAlphabet)
                result[alphabetMap[smallestAlphabet]!!.removeLast()] = '-'
            } else {
                alphabetQueue.add(s[i].code)
                alphabetMap.getOrPut(s[i].code) {ArrayList()}.add(i)
            }
        }
        return result
            .filter {it != '-'}
            .joinToString("")
    }

    /*

    1차 접근
    1. *의 index: 앞서 있는 알파벳들 중 가장 작은 알파벳의 index 형태의 맵을 만든다.
    2.맵을 순회하면서 해당 위치의 값들을 제거한다.

    실패: ds**형태의 데이터일 경우 예상 답안은 ""인데 결과는 "s"로 나옴
    val starMap = HashMap<Int, Int>()
    var minAlphabet = 123
    var minIndex = 0
    for(i in s.indices) {
        if (s[i] == '*') {
            starMap[i] = minIndex
            minAlphabet = 123
            minIndex = 0
        } else {
            if (minAlphabet >= s[i].code) {
                minAlphabet = s[i].code
                minIndex = i
            }
        }
    }

    if (starMap.isEmpty()) {
        return s
    }
    val result = s.toCharArray()
    for (entry in starMap) {
        result[entry.key] = '-'
        result[entry.value] = '-'
    }
    return result
        .filter {it != '-'}
        .joinToString("")


    ----
    2차 접근
    1. PriorityQueue에 알파벳이 나올때마다 추가하고, 해당 알파벳 : {인덱스, 인덱스...} 형태의 Map에도 값을 추가한다.
    2. *이 나올 경우 Queue에서 가장 작은 알파벳을 꺼내고, Map에서 해당 알파벳의 List에서 마지막 값을 제거한다.
     */
}