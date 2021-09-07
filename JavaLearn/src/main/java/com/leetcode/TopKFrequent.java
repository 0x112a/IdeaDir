package com.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums,int k){
        Map<Integer,Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num,hashMap.getOrDefault(num,0)+1);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        for (Map.Entry<Integer,Integer> entry : hashMap.entrySet()){
            int num = entry.getKey(),count = entry.getValue();
            if (priorityQueue.size() == k){
                if (priorityQueue.peek()[1] < count){
                    priorityQueue.poll();
                    priorityQueue.offer(new int[]{num,count});
                }
            }else {
                priorityQueue.offer(new int[]{num,count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = priorityQueue.poll()[0];
            
        }

        return ret;
    }
}
