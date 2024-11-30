package org.fotech.huawei;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 流浪地球计划在赤道上均匀部署了 N 个转向发动机，按位置顺序编号为 0 ~ N
 *
 * 初始状态下所有的发动机都是未启动状态
 * 发动机启动的方式分为“手动启动”和“关联启动”两种方式
 * 如果在时刻 1 一个发动机被启动，下一个时刻 2 与之相邻的两个发动机就会被“关联启动”
 * 如果准备启动某个发动机时，它已经被启动了，则什么都不用做
 * 发动机 0 与发动机 N-1 是相邻的
 * 地球联合政府准备挑选某些发动机在某些时刻进行“手动启动”。当然最终所有的发动机都会被启动。哪些发动机最晚被启动呢？
 *
 * 输入描述
 * 第一行两个数字 N 和 E，中间有空格
 *
 * N 代表部署发动机的总个数，1 < N ≤ 1000
 * E 代表计划手动启动的发动机总个数，1 ≤ E ≤ 1000，E ≤ N
 * 接下来共 E 行，每行都是两个数字 T 和 P，中间有空格
 *
 * T 代表发动机的手动启动时刻，0 ≤ T ≤ N
 * P 代表次发动机的位置编号，0 ≤ P < N
 *
 * 输出描述
 * 第一行一个数字 N， 以回车结束
 *
 * N 代表最后被启动的发动机个数
 * 第二行 N 个数字，中间有空格，以回车结束
 *
 * 每个数字代表发动机的位置编号，从小到大排序
 */
public class Homework2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String lineOne = sc.nextLine();
        String[] lineOneArr = lineOne.split(" ");
        Integer engineNum = Integer.valueOf(lineOneArr[0]);
        Integer handOpen = Integer.valueOf(lineOneArr[1]);

        // 发动机初始状态，每一个都是关闭
        Set<Integer> engineStatusSet = new HashSet<>();

        // 初始话手动开启发动机的配置.key是时刻，value是开启发动机的位置
        Map<Integer, List<Integer>> handOpenMap = new HashMap<>();
        for (int i = 0; i< handOpen; i++) {
            String line = sc.nextLine();
            String[] lineArr = line.split(" ");
            Integer time = Integer.valueOf(lineArr[0]);
            Integer enginePos = Integer.valueOf(lineArr[1]);
            if (handOpenMap.containsKey(time)) {
                handOpenMap.get(time).add(enginePos);
            } else {
                List<Integer> arr = new ArrayList<>();
                arr.add(enginePos);
                handOpenMap.put(time, arr);
            }
        }

        int time = 0;
        boolean firstOpen = true;
        Set<Integer> autoOpen = new HashSet<>();
        while (engineStatusSet.size() < engineNum) {
            autoOpen.clear();
            // 首次启动发动机，手动开启后直接返回
            if (firstOpen) {
                engineStatusSet.addAll(handOpenMap.get(time));
                firstOpen = false;
                continue;
            }
            // 找到自动开启的位置
            for (Integer pos : engineStatusSet) {
                if (pos == 0) {
                    autoOpen.add(1);
                    autoOpen.add(engineStatusSet.size() - 1);
                } else
                if (pos == engineNum - 1) {
                    autoOpen.add(0);
                    autoOpen.add(engineStatusSet.size() - 2);
                } else {
                    autoOpen.add(pos - 1);
                    autoOpen.add(pos + 1);
                }
            }

            // 加入手动开启的部分
            if (handOpenMap.containsKey(time)) {
                autoOpen.addAll(handOpenMap.get(time));
            }

            // 过滤掉已经开启的位置
            autoOpen.removeIf(engineStatusSet::contains);

            // 添加到已开启
            engineStatusSet.addAll(autoOpen);

            time++;
        }

        System.out.println(autoOpen);
    }
}
