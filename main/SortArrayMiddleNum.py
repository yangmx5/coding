# coding=utf-8
"""
nums1 = [1, 3]
nums2 = [2]

则中位数是
2.0
示例
2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是(2 + 3) / 2 = 2.5
"""


class Solution:
    @staticmethod
    def find_median_sorted_arrays(nums1, nums2):
        ret = []
        i = nums1.pop()
        j = nums2.pop()
        while nums1 or nums2:
            if i <= j:
                ret.append(i)
                i = nums1.pop() if nums1 else 9999
            else:
                ret.append(j)
                j = nums2.pop() if nums2 else 9999
        print(ret)


if __name__ == '__main__':
    Solution().find_median_sorted_arrays([1, 2], [3, 4])
