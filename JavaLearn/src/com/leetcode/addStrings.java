package com.leetcode;

public class addStrings {
    public String addStrings(String num1, String num2){
        int n1 = num1.length() -1;
        int n2 = num2.length() -1;
        int add = 0;
        StringBuffer ans = new StringBuffer();
        while (n1 >= 0 || n2 >= 0 || add != 0){
            int x = n1 >= 0? num1.charAt(n1) - '0' : 0;
            int y = n2 >= 0 ? num2.charAt(n2) - '0' : 0;
            int result = x+y+add;
            ans.append(result%10);
            add = result/10;
            n1--;
            n2--;
        }

        
        ans.reverse();
        return ans.toString();

    }
}
