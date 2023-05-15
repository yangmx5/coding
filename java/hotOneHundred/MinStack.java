package hotOneHundred;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author fouthed
 * @date 2023/5/9
 */
public class MinStack {

    public static void main(String[] args) {
        push(-2);
        push(1);
        push(2);
        System.out.println(getMin());
        push(-3);
        System.out.println(getMin());
    }

    static Deque<Integer> stack = new LinkedList<>();
    static Deque<Integer> minStack = new LinkedList<>();

    public static void push(Integer num) {
        stack.push(num);
        minStack.push(Math.min(minStack.peek() == null ? Integer.MAX_VALUE: minStack.peek(), num));
    }

    public static Integer pop() {
        minStack.pop();
        return stack.pop();
    }

    public static Integer getMin() {
        return minStack.peek();
    }
}
