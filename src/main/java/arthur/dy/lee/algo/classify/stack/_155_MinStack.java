package arthur.dy.lee.algo.classify.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 155. 最小栈
 * 提示
 * 中等
 * 1.6K
 * 相关企业
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * 实现 MinStack 类:
 * <p>
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 * <p>
 * 示例 1:
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 * 提示：
 * -2^31 <= val <= 2^31 - 1
 * pop、top 和 getMin 操作总是在 非空栈 上调用
 * push, pop, top, and getMin最多被调用 3 * 10^4 次
 */
public class _155_MinStack {
    Deque<Integer> dataStack;
    Deque<Integer> minStack;

    public _155_MinStack() {
        dataStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        dataStack.push(val);
        if (minStack.peek() > val) {
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        _155_MinStack minStack = new _155_MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int param1 = minStack.getMin();   // --> 返回 -3.
        System.out.println(-3 == param1);
        minStack.pop();
        int param2 = minStack.top();     // --> 返回 0.
        System.out.println(0 == param2);
        int param3 = minStack.getMin();   //--> 返回 -2.
        System.out.println(-2 == param3);

    }
}
