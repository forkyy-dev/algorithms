import collections


def solution(id_list, report, k):
    answer = []
    report = list(set(report))
    dict = collections.defaultdict(set)
    count = collections.defaultdict(int)

    for r in report:
        user1, user2 = r.split()
        dict[user1].add(user2)
        count[user2] += 1

    for id in id_list:
        result = 0

        for name in dict[id]:
            if count[name] >= k:
                result += 1

        answer.append(result)

    return answer
