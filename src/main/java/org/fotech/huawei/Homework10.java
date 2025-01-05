package org.fotech.huawei;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 题目描述
 * 部门组织绿岛骑行团建活动。租用公共双人自行车，每辆自行车最多坐两人，最大载重M。
 * 给出部门每个人的体重，请问最多需要租用多少双人自行车。
 *
 * 输入描述
 * 第一行两个数字m、n，分别代表自行车限重，部门总人数。
 *
 * 第二行，n个数字，代表每个人的体重，体重都小于等于自行车限重m。
 *
 * 0<m<=200
 * 0<n<=1000000
 * 输出描述
 * 最小需要的双人自行车数量。
 */
public class Homework10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(" ");
        Integer maxWeight = Integer.parseInt(line1[0]);
        Integer peopleNum = Integer.parseInt(line1[1]);
        String[] line2 = sc.nextLine().split(" ");
        List<Integer> peopleWeight = Arrays.stream(line2).map(Integer::parseInt).sorted().collect(Collectors.toList());
        int res = 0;
        int left = 0;
        int right = peopleNum - 1;
        while (true) {
            if (left > right) {
                break;
            }
            if (peopleWeight.get(left) >= maxWeight) {
                left++;
                res++;
                continue;
            } else {
                if (peopleWeight.get(left) + peopleWeight.get(right) > maxWeight) {
                    left++;
                    res++;
                    continue;
                } else {
                    left++;
                    right--;
                    res++;
                    continue;
                }
            }
        }
        System.out.println(res);
    }
}
