package org.fotech.hot100;

public class Solution41 {
    public int firstMissingPositive(int[] input) {
        int[] flag = new int[input.length];
        if (input.length == 1) {
            return (input[0] != 1) ? 1 : 2;
        }
        for (int i = 0; i < input.length; i++) {
            if (input[i] <=0 || input[i] > input.length) {
                continue;
            }
            flag[input[i] - 1] = 1;
        }

        for (int i = 0; i < flag.length; i++) {
            if (flag[i] != 1) {
                return i+1;
            }
        }

        return input.length;
    }

    public static void main(String[] args) {
        Solution41 testComboInTacheSupporter = new Solution41();
        int[] input = new int[]{2,1};
        System.out.println(testComboInTacheSupporter.firstMissingPositive(input));;
    }
}
