package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GetRow {
    /**
     * 杨辉三角
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++){
            row.add((int)((long)row.get(i-1) * (rowIndex - i +1 ) / i));
        }
        return row;
    }
}
