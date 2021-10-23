package com.offer.n_offer_40;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
//        最简单写法排序
//        Arrays.sort(arr);
//        int[] ans = new int[k];
//
//        for (int i = 0; i < k; i++) {
//            ans[i] = arr[i];
//        }
//
//        return ans;
        
//        最大堆实现
        int[] ans = new int[k];
        if (k == 0) return ans;

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }
}
