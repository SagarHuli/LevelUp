package MonotonicStack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/online-stock-span/
 */
public class OnlineStockSpan {
    Stack<Pair> stack;

    static class Pair {
        int price;
        int span;
        Pair(int a, int b) {
            price = a;
            span = b;
        }
    }
    public OnlineStockSpan() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int currSpan = 1;
        while(!stack.isEmpty() && price >= stack.peek().price) {
            currSpan += stack.pop().span;
        }
        stack.push(new Pair(price, currSpan));
        return stack.peek().span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
