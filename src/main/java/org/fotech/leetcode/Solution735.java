package org.fotech.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 *
 * 对于数组中的每一个元素，其绝对值表示行星的大小，
 * 正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 *
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，
 * 较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。
 * 两颗移动方向相同的行星，永远不会发生碰撞。
 *
 *
 *
 * 示例 1：
 *
 * 输入：asteroids = [5,10,-5]
 * 输出：[5,10]
 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 * 示例 2：
 *
 * 输入：asteroids = [8,-8]
 * 输出：[]
 * 解释：8 和 -8 碰撞后，两者都发生爆炸。
 * 示例 3：
 *
 * 输入：asteroids = [10,2,-5]
 * 输出：[10]
 * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
 *
 */
public class Solution735 {
    public int[] asteroidCollision(int[] asteroids) {
        // 后进先出。保证栈里面的符号是一样的
        Stack<Integer> stack = new Stack<>();
        for (int i : asteroids) {
            // 如果栈空，则直接入栈
            // 如果新元素大于0，也直接入栈
            if (stack.isEmpty() || i > 0) {
                stack.push(i);
                continue;
            } else {
                // 获取栈顶元素
                int top = stack.peek();
                // 如果符号相同
                if (isNegtive(top, i)) {
                    stack.push(i);
                    continue;
                } else {
                    // 符号不相同
                    // 一直到栈空
                    while (!stack.isEmpty()) {
                        // 新来的被撞没了
                        if (top > -i ) {
                            break;
                        } else if (isNegtive(top, i)){
                            stack.push(i);
                            break;
                        } else if (top == -i) {
                            stack.pop();
                            if (stack.isEmpty()) break;
                            top = stack.peek();
                            break;
                        } else {
                            // 在里面的被撞没了
                            stack.pop();
                            if (stack.isEmpty()) {
                                stack.push(i);
                                break;
                            }
                            top = stack.peek();
                        }
                    }
                }
            }
        }
        int[] res = new int[stack.size()];
        int m = 0;
        for (int i : stack) {
            res[m] = i;
            m++;
        }

        return res;
    }



    // 判断两个数字的符号是否一致
    private boolean isNegtive(int a, int b) {
        return (a * b) > 0;
    }

    public static void main(String[] args) {
        int[] input = {1,-2,-2,-2};
        Solution735 solution735 = new Solution735();
        solution735.asteroidCollision(input);
    }
}
