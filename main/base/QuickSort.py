class Solution:
    def quick_sort(self, arr, start, end):
        if end > start:
            mid = self.partition(arr, start, end)
            self.quick_sort(arr, start, mid)
            self.quick_sort(arr, mid + 1, end)
        return arr

    def partition(self, arr, start, end):
        key = arr[start]
        i = start
        j = end
        while i < j:
            while i < j and arr[j] >= key:
                j -= 1
            if i < j:
                arr[i] = arr[j]
                i += 1
            while i < j and arr[i] <= key:
                i += 1
            if i < j:
                arr[j] = arr[i]
                j -= 1
        arr[i] = key
        return i


if __name__ == '__main__':
    arr = [2, 5, 1, 4, 6, 8, 1, 2]
    print(Solution().quick_sort(arr, 0, len(arr) - 1))
