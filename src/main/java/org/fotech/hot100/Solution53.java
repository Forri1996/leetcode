package org.fotech.hot100;

public class Solution53 {
    private int maxArr(int[] m) {
        int result = 0;
        int pre = 0;
        int[] k = new int[m.length];
        for (int i = 0; i< m.length; i++) {
            if (i == 0) {
                pre = m[i];
                result = m[i];
            } else {
                pre = Math.max(m[i], pre+m[i]);
                result = Math.max(pre,result);
            }
            k[i] = result;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        // -2,1,-2,4,4,3,5,6,1,5
        int[] input = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(solution53.maxArr(input));
    }
}
