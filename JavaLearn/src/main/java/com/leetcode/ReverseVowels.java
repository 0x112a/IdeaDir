package com.leetcode;

public class ReverseVowels {

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left =0, right = s.length()-1;

        while (left < right){
            if (isVowel(chars[left]) && isVowel(chars[right])){
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }else if(isVowel(chars[left])){
                right--;
            }else if (isVowel(chars[right])){
                left++;
            }else {
                left++;
                right--;
            }
        }

        //从字符数组创建字符串
        return new String(chars);
    }

    public boolean isVowel(char c){
        return "AEIOUaeiou".indexOf(c) >= 0;
    }
}
