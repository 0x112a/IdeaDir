package com.offer.n_offer_5;

public class ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                ans.append("%20");
            }else {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }

}
