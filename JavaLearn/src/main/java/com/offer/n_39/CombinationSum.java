package com.offer.n_39;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();

        dfs(candidates,target,ans,combine,0);

        return ans;
    }

    /**
     * 深度遍历加回溯
     * @param candidates
     * @param target
     * @param ans
     * @param combine
     * @param index
     */
    public void dfs(int[] candidates,int target, List<List<Integer>> ans, List<Integer> combine, int index){

        if (index == candidates.length) return;

        if (target <= 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }

        dfs(candidates,target,ans,combine,index+1);

        if (target - candidates[index] >= 0){
            combine.add(candidates[index]);
            dfs(candidates,target-candidates[index],ans,combine,index);
            combine.remove(combine.size()-1);
        }
        return;
    }
}
