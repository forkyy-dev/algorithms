def solution(s):
    words = []
    cur = word = ''

    for w in s:
        if not cur:
            cur = w
            word = word + w
            continue
        word = word + w

        if len(word) - word.count(cur) == word.count(cur):
            words.append(word)
            cur = word = ''

    if word:
        words.append(word)

    return len(words)

print(solution("abracadabra"))