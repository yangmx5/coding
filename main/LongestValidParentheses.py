# coding=utf-8
class Solution(object):
    @staticmethod
    def longest_valid_parentheses_dp(parentheses):
        if not parentheses:
            return 0
        length = len(parentheses)
        dp = [0 for _ in range(length)]
        for i in range(1, length):
            if parentheses[i] == ')':
                pre = i - dp[i - 1] - 1
                if pre >= 0 and parentheses[pre] == '(':
                    dp[i] = dp[i - 1] + 2 + (dp[pre - 1] if pre > 0 else 0)
        return max(dp)

    @staticmethod
    def longest_valid_parentheses_stack(parentheses):
        stack = [-1]
        ret = 0
        for index in range(0, len(parentheses)):
            if parentheses[index] == '(':
                stack.append(index)
            if parentheses[index] == ')':
                stack.pop()
                if not len(stack):
                    stack.append(index)
                else:
                    ret = max(ret, index - stack[-1])
        return ret


if __name__ == "__main__":
    print(Solution().longest_valid_parentheses_stack("()())"))
    print(Solution().longest_valid_parentheses_stack("(())()"))
    print(Solution().longest_valid_parentheses_stack("()()"))
