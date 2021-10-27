import java.util.Deque;
import java.util.LinkedList;
//https://leetcode-cn.com/problems/min-stack/solution/zui-xiao-zhan-by-leetcode-solution/
//要在o(1)内得到栈的最小值，可以设置一个辅助栈。进栈时比较新的数和辅助栈的栈顶大小，让小的进入辅助栈，就可以保证在辅助栈的栈顶是最小的数。如果栈出栈的话辅助栈也会出栈，保证了最小值的更新。
public class MinStack {

        Deque<Integer> stack;
        Deque<Integer> minStack;
        public MinStack() {
            stack = new LinkedList<Integer>();
            minStack = new LinkedList<Integer>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            minStack.push(Math.min(val,minStack.peek()));
            stack.push(val);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }

}
