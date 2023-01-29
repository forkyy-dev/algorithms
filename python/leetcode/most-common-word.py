import re
from collections import Counter

def mostCommonWord(paragraph, banned):
    words = [word for word in re.sub(r'[^\w]', ' ', paragraph).lower().split() if word not in banned]
    c = Counter(words)
    return c.most_common(1)[0][0]

mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", ["hit"])
