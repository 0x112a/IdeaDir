package com.leetcode;

public class Multiply {
    public String mutiply(String num1,String num2){
//        if (num1.equals("0") && num2.equals("0")){
//            return "0";
//        }
//
//        int n1 = num1.length()-1;
//        int n2 = num2.length()-1;
//
//        int[] ansArr = new int[n1+n2];
//        for (int i = n1-1; i>=0; i--){
//            int x = num1.charAt(i)-'0';
//            for (int j = n2-1; j>=0; j--){
//                int y = num2.charAt(j) - '0';
//                ansArr[i+j+1] += x*y;
//            }
//        }
//
//        for (int i = n1+n2-1; i>0; i--){
//            ansArr[i-1] += ansArr[i]/10;
//            ansArr[i] %= 10;
//        }
//
//        int index = ansArr[0] == 0 ? 1 : 0;
//        StringBuffer ans = new StringBuffer();
//        while (index<n1+n2){
//            ans.append(ansArr[index]);
//            index++;
//        }
//
//        return ans.toString();

        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }

        StringBuffer ans = new StringBuffer();

        int l1 = num1.length();
        int l2 = num2.length();

        int[] ansArry = new int[l1+l2];

        for (int i = l1-1; i >=0 ; i-- ){
            int i1 = num1.charAt(i) - '0';
            for (int j = l2-1; j >= 0 ; j-- ){
                int i2 = num2.charAt(j) - '0';
                ansArry[i+j+1] += i1 * i2;
            }
        }

        for (int i = l1+l2-1; i > 0; i--) {
            ansArry[i-1] += ansArry[i]/10;
            ansArry[i]%=10;
        }

        int index = ansArry[l1+l2-1] == 0 ? 1 : 0;

        for (; index  < l1+l2 ; index ++) {
            ans.append(ansArry[index]);
        }
        return ans.toString();
    }
}
