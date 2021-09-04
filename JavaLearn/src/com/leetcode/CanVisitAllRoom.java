package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CanVisitAllRoom {


    public boolean canVisitAllRoom(List<List<Integer>> rooms){
        int size = rooms.size(),num = 0;
        boolean[] vis = new boolean[size];

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);

        vis[0] = true;

        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            num++;
            for (Integer integer : rooms.get(poll)) {
                if (!vis[integer]){
                    vis[integer] = true;
                    queue.offer(integer);
                }
            }
        }


        return size == num;
    }

}
