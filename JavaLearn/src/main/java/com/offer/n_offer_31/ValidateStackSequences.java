package com.offer.n_offer_31;

import java.util.Stack;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i=0;

        for (int num : popped) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i] ){
                stack.pop();
                i++;
            }
        }

        return stack.isEmpty();
    }
}
