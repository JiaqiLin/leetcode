package q155;

import java.util.Deque;
import java.util.LinkedList;

class q155 {
    private Deque<Integer> xStack;
    private Deque<Integer> minStack;

    public q155() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.addLast(Integer.MAX_VALUE);   //用于Math.min(minStack.peek(),val)
    }

    public void push(int val) {
        xStack.addLast(val);
        minStack.addLast(Math.min(minStack.getLast(),val));
    }

    public void pop() {
        xStack.removeLast();
        minStack.removeLast();

    }

    public int top() {
        return xStack.getLast();
    }

    public int getMin() {
        return minStack.getLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */