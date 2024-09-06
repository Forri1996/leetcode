package org.fotech.hot100;

public class Solution53 {
    private int maxArr(int[] m) {
        int result = 0;
        int pre = 0;
        for (int i = 0; i< m.length; i++) {
            if (i == 0) {
                pre = m[i];
                result = m[i];
            } else {
                result = Math.max(pre, pre+result);
                pre = result;
            }
        }

        return result;
    }
}
