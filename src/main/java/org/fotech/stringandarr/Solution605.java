package org.fotech.stringandarr;

/**
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。
 * 可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给你一个整数数组 flowerbed 表示花坛，
 * 由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。
 * 另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？
 * 能则返回 true ，不能则返回 false 。
 */
public class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1) {
            if (flowerbed[0] == 0) {
                return 1 >= n;
            } else {
                return 0 >= n;
            }
        }
        // 最多能种的花
        int max = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            if (i == 0 ) {
                if (flowerbed[i] == 0 && flowerbed[i+1] == 0) {
                    flowerbed[i] = 1;
                    max++;
                }
                continue;
            }
            if (i == flowerbed.length - 1 ) {
                if (flowerbed[i] == 0 && flowerbed[i-1] == 0) {
                    flowerbed[flowerbed.length - 1] = 1;
                    max++;
                }
                continue;
            }

            if (flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                flowerbed[i] = 1;
                max++;
            }
        }

        return max >= n;
    }

    public static void main(String[] args) {
        Solution605 solution605 = new Solution605();
        int[] input = {0,1,0};
        System.out.println(solution605.canPlaceFlowers(input, 1));
    }
}
