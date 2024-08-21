package q150;

import java.util.Deque;
import java.util.LinkedList;

class q150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> numStack = new LinkedList<Integer>();
        Integer result = 0;
        Integer second = 0;
        Integer first = 0;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    second = numStack.removeLast();
                    first = numStack.removeLast();
                    result = first + second;
                    numStack.addLast(result);
                    break;
                case "-":
                    second = numStack.removeLast();
                    first = numStack.removeLast();
                    result = first - second;
                    numStack.addLast(result);
                    break;
                case "*":
                    second = numStack.removeLast();
                    first = numStack.removeLast();
                    result = first * second;
                    numStack.addLast(result);
                    break;
                case "/":
                    second = numStack.removeLast();
                    first = numStack.removeLast();
                    result = first / second;
                    numStack.addLast(result);
                    break;
                default:
                    numStack.addLast(Integer.parseInt(token));
            }
        }
        if(!numStack.isEmpty()){
            return numStack.getLast();
        }else {
            return 0;
        }
    }

};


