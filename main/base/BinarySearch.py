class Solution:
    @staticmethod
    def binary_search(arr, target):
        low = 0
        high = len(arr) - 1
        while low <= high:
            mid = int(low + (high - low) / 2)
            if arr[mid] == target:
                return mid
            elif arr[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def binary_search_rescurie(self, arr, target, low, high):
        if low < high:
            mid = int(low + (high - low) / 2)
            if arr[mid] == target:
                return mid
            elif arr[mid] < target:
                return self.binary_search_rescurie(arr, target, mid + 1, high)
            else:
                return self.binary_search_rescurie(arr, target, low, mid - 1)
        else:
            return -1

    @staticmethod
    def get_down(arr, target):
        low = 0
        high = len(arr) - 1
        while low < high:
            mid = int(low + (high - low) / 2)
            if arr[mid] < target:
                low = mid + 1
            else:
                high = mid
        return low

    @staticmethod
    def get_up(arr, target):
        low = 0
        high = len(arr) - 1
        while low < high:
            mid = int(low + (high - low) / 2)
            if arr[mid] > target:
                high = mid - 1
            else:
                low = mid
        return low


if __name__ == "__main__":
    arr = [1, 2, 2, 3, 3, 3, 4, 5]
    # print(Solution().binary_search(arr, 3))
    # print(Solution().binary_search(arr, 6))
    # print(Solution().binary_search_rescurie(arr, 5, 0, len(arr)))
    # print(Solution().binary_search_rescurie(arr, 6, 0, len(arr)))
    print(Solution().get_up(arr, 3))
    # Solution().get_up(arr, 3)
