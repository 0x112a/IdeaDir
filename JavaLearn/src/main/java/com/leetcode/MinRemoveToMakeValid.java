package com.leetcode;

public class MinRemoveToMakeValid {

    public String minRemoveToMakeValid(String s) {
        StringBuffer stringBuffer = new StringBuffer();

        int length = s.length();
        
        int balance = 0;

        //清除不能闭合的右括号
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if ("(".equals(c)){
                balance++;
            }else if (")".equals(c)){
                if (balance == 0){
                    continue;
                }else {
                    balance--;
                }
            }

            stringBuffer.append(c);
        }
        
        //清除不能闭合左括号
        String s1 = stringBuffer.reverse().toString();


        StringBuffer ans = new StringBuffer();

        int length1 = s1.length();
        balance = 0;

        for (int i = 0; i < length1; i++) {
            char c = s.charAt(i);
            if (")".equals(c)){
                balance++;
            }else if ("(".equals(c)){
                if (balance == 0){
                    continue;
                }else {
                    balance--;
                }
            }

            ans.append(c);
        }

        return ans.reverse().toString();

    }
}
