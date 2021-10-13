package com.offer.n_offer_11;

public class MinArray {
    public int minArray(int[] numbers) {
        int len = numbers.length;

//        int min = Integer.MAX_VALUE;

        int low = 0, hight = len-1;

        while (low <= hight){
            int mid = (low+hight)/2;
            if (numbers[mid] < numbers[hight]){
//                hight = mid - 1;
                hight = mid;
            }else if (numbers[mid] > numbers[hight]){
                low = mid + 1;
            }else {
                hight--;
            }
        }


        return numbers[low];
    }
}
