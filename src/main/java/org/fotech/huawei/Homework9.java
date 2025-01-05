package org.fotech.huawei;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 题目描述
 * 在一个狭小的路口，每秒只能通过一辆车，假设车辆的颜色只有 3 种，找出 N 秒内经过的最多颜色的车辆数量。
 *
 * 三种颜色编号为0 ，1 ，2
 *
 * 输入描述
 * 第一行输入的是通过的车辆颜色信息
 *
 * [0,1,1,2] 代表4 秒钟通过的车辆颜色分别是 0 , 1 , 1 , 2
 *
 * 第二行输入的是统计时间窗，整型，单位为秒
 *
 * 输出描述
 * 输出指定时间窗内经过的最多颜色的车辆数量。
 */
public class Homework9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cars = sc.nextLine();
        Integer time = sc.nextInt();
        List<Integer> carsArr = Arrays.stream(cars.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        Map<Integer, Integer> carNum = new HashMap<>();
        for (int i = 0; i < time; i++) {
            int integer = carsArr.get(i);
            if (carNum.containsKey(integer)) {
                carNum.put(integer, carNum.get(integer) + 1);
            } else {
                carNum.put(integer, 1);
            }
        }
        int left = 0;
        int right = time - 1;
        while (true) {
            if (right == carsArr.size()) break;
            int leftCar = carsArr.get(left);
            carNum.put(leftCar, carNum.get(leftCar) - 1);
            left++;
            right++;
            int rightCar = carsArr.get(right);
            carNum.put(rightCar, carNum.get(rightCar)+1);
        }


    }
}
