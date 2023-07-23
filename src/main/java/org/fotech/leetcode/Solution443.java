package org.fotech.leetcode;

/**
 * 给你一个字符数组 chars ，请使用下述算法压缩：
 * <p>
 * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
 * <p>
 * 如果这一组长度为 1 ，则将字符追加到 s 中。
 * 否则，需要向 s 追加字符，后跟这一组的长度。
 * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。
 * 需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
 * <p>
 * 请在 修改完输入数组后 ，返回该数组的新长度。
 * <p>
 * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
 * <p>
 * 输入：chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * 输出：返回 4 ，输入数组的前 4 个字符应该是：["a","b","1","2"]。
 * 解释：由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。
 */
public class Solution443 {

    public int compress(char[] chars) {
        if (chars.length == 1) return 1;
        char curr = chars[0];
        int res = 1;
        Integer nums = 1;
        char[] resChars = new char[chars.length];
        resChars[0] = chars[0];
        int loopIndex = 1;

        for (int i = 1; i < chars.length; i++) {

            // 和前值不相同
            if (chars[i] != curr) {
                curr = chars[i];
                // 没有重复过，则直接赋值给最终数组
                if (nums != 1) {
                    // 有重复过，则要将数字转换成字符串弄到后面
                    String numsstr = nums.toString();
                    for (int j = 0; j < numsstr.length(); j++) {
                        resChars[loopIndex] = numsstr.charAt(j);
                        loopIndex++;
                    }
                    resChars[loopIndex] = chars[i];
                    loopIndex++;
                    nums = 1;
                } else {
                    // 没有重复过，则直接复制给res
                    resChars[loopIndex] = chars[i];
                    loopIndex++;
                    res++;
                }
            } else {
                nums++;
            }
            if (i == chars.length - 1 && nums > 1) {
                String numsstr = nums.toString();
                for (int j = 0; j < numsstr.length(); j++) {
                    resChars[loopIndex] = numsstr.charAt(j);
                    loopIndex++;
                }
                break;
            }
        }
        for (int i = 0; i < loopIndex+1; i++) {

            chars[i] = resChars[i];


        }

        return loopIndex+1;
    }

    public static void main(String[] args) {
        Solution443 solution443 = new Solution443();
//        solution443.compress(new char[]{'a'});
//        solution443.compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'});
        solution443.compress(new char[]{'a','a', 'a','a','b','b','a'});
    }



}
