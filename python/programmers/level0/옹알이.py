def solution(babbling):
    answer = 0
    words = ["aya", "ye", "woo", "ma"]

    for x in babbling:
        for w in words:
            x = x.replace(w, ' ', 1)
        if x.strip() == '':
            answer += 1

    return answer

print(solution(["aya", "yee", "u", "maa", "wyeoo"]))
