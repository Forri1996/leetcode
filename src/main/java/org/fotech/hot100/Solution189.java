package org.fotech.hot100;

public class Solution189 {
    public int[] lunzhuan(int[] input, int k) {
        int m = k % input.length;
        for (int i = 0; i < m; i++) {
            change(input, m-1- i, input.length - i - 1);
        }
        return input;
    }

    public void change(int[] m, int left, int right) {
        int tmp = m[left];
        m[left] = m[right];
        m[right] = tmp;
    }
    public static void main(String[] args) {
        Solution189 testComboInTacheSupporter = new Solution189();
        int[] input = new int[]{1,2,3,4,5,6};
        System.out.println(testComboInTacheSupporter.lunzhuan(input, 3).toString());
    }
}
