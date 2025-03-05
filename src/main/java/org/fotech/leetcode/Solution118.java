package org.fotech.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list0 = new ArrayList<Integer>();
        list0.add(1);
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(1);
        result.add(list0);
        result.add(list1);
        for (int n = 2; n <= numRows; n++) {
            List<Integer> listn = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (i == 0 || i == n-1) {
                    listn.add(1);
                } else {
                    List<Integer> listnminus1 = result.get(n - 1);
                    listn.add(listnminus1.get(i-1) + listnminus1.get(i));
                }
            }
            result.add(listn);
        }

        return result;
    }
}
