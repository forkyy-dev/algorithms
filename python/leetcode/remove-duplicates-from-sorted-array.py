def removeDuplicates(nums):
    p1 = 0
    for p2 in range(1, len(nums)):
        if nums[p1] != nums[p2]:
            nums[p1 + 1] = nums[p2]
            p1 += 1
    return p1


removeDuplicates([0, 0, 1, 1, 1, 2, 2, 3, 3, 4])
