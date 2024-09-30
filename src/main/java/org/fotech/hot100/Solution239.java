package org.fotech.hot100;

public class Solution239 {
    public static void main(String[] args) {
        Solution239 testComboInTacheSupporter = new Solution239();
        System.out.println(testComboInTacheSupporter.maxNum(new int[]{1}, 1));;
    }
    public int maxNum(int[] input, int k) {
        int left = 0;
        int right = k-1;
        int[] output = new int[input.length];
        if (k == 1) {
            return getMax(input, 0, input.length);
        }
        while (right <= input.length) {
            if (left == 0) {
                output[left] = getMax(input, left, right);
            } else {
                // 如果左边少掉的这个元素是最大值，则重新计算
                // 如果右边新的元素大于最大值，则直接赋值
                // 其他情况，和上一个值相等
                if (input[left - 1] == output[left - 1]) {
                    output[left] = getMax(input, left, right);
                } else if (input[right - 1] > output[left - 1]) {
                    output[left] = input[right - 1];
                } else {
                    output[left] = output[left - 1];
                }
            }
            left++;
            right++;
        }

        return getMax(output, 0, output.length);
    }

    private int getMax(int[] input, int left, int right) {
        int max = Integer.MIN_VALUE;
        for (int i = left; i < right; i++) {
            if (input[i] > max) {
                max = input[i];
            }
        }

        return max;
    }
}
