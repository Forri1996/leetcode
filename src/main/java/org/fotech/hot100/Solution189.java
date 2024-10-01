package org.fotech.hot100;

public class Solution189 {
    public void lunzhuan(int[] input, int k) {
        int[] newArr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            newArr[(i+k)%input.length] = input[i];
        }
        System.arraycopy(newArr,0, input, 0, input.length);
    }

    public void change(int[] m, int left, int right) {
        int tmp = m[left];
        m[left] = m[right];
        m[right] = tmp;
    }
    public static void main(String[] args) {
        Solution189 testComboInTacheSupporter = new Solution189();
        int[] input = new int[]{1,2,3,4,5,6,7};
        testComboInTacheSupporter.lunzhuan(input, 3);
    }
}
