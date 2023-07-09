package hotBack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author fouthed
 * @date 2023/6/19
 * 最小栈
 */
public class MinStack {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(2);
        System.out.println(stack.getMin());
        stack.push(1);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.push(4);


    }

    public static class Stack {
        public Deque<Integer> stack;
        public Deque<Integer> minStack;

        public Stack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public void push(int i) {
            stack.push(i);
            minStack.push(Math.min(minStack.peek() == null ? Integer.MAX_VALUE : minStack.peek(), i));
        }

        public void pop() {
            minStack.pop();
            stack.pop();
        }

        public int top() {
            return stack.peek() == null ? -1 : stack.peek();
        }

        public int getMin() {
            return minStack.peek() == null ? -1 : minStack.peek();
        }

    }


}
