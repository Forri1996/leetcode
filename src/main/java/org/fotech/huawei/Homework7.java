package org.fotech.huawei;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 某公司研发了一款高性能AI处理器。每台物理设备具备8颗AI处理器，编号分别为0、1、2、3、4、5、6、7。
 *
 * 编号0-3的处理器处于同一个链路中，编号4-7的处理器处于另外一个链路中，不通链路中的处理器不能通信。
 *
 * 如下图所示。现给定服务器可用的处理器编号数组array，以及任务申请的处理器数量num，找出符合下列亲和性调度原则的芯片组合。
 *
 * 如果不存在符合要求的组合，则返回空列表。
 *
 * 亲和性调度原则：
 *
 * -如果申请处理器个数为1，则选择同一链路，剩余可用的处理器数量为1个的最佳，其次是剩余3个的为次佳，然后是剩余2个，最后是剩余4个。
 *
 * -如果申请处理器个数为2，则选择同一链路剩余可用的处理器数量2个的为最佳，其次是剩余4个，最后是剩余3个。
 *
 * -如果申请处理器个数为4，则必须选择同一链路剩余可用的处理器数量为4个。
 *
 * -如果申请处理器个数为8，则申请节点所有8个处理器。
 *
 * 输入描述
 * 输入包含可用的处理器编号数组array，以及任务申请的处理器数量num两个部分。
 *
 * 第一行为array，第二行为num。例如：
 * [0, 1, 4, 5, 6, 7]
 *
 * 递归求排列组合的内容
 * 1
 */
public class Homework7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String lineOne = sc.nextLine();
        lineOne = lineOne.replace("[", "");
        lineOne = lineOne.replace("]", "");
        Integer[] lineOneArr = Arrays.stream(lineOne.split(",")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer num = sc.nextInt();
        calcute(lineOneArr, num);
    }

    private static void calcute(Integer[] lineOneArr, Integer num) {
        Arrays.sort(lineOneArr);
        List<Integer> line1 = new ArrayList<>();
        List<Integer> line2 = new ArrayList<>();
        for (int i : lineOneArr) {
            if (i < 4) {
                line1.add(i);
            } else {
                line2.add(i);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        switch (num) {
            case 1:
                if (line1.size() == 1) dfs(line1, 0, 1, new ArrayList<>(), res);
                if (line2.size() == 1) dfs(line2, 0, 1, new ArrayList<>(), res);
                if (line1.size() == 3) dfs(line2, 0, 3, new ArrayList<>(), res);
                if (line2.size() == 3) dfs(line2, 0, 3, new ArrayList<>(), res);
                break;
            case 2: break;
            case 4: break;
            case 8: break;
        }

    }
    private static void dfs(List<Integer> line1, int start, int level, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == level) {
            res.add(curr);
            return;
        }
        for (int i = start; i < line1.size(); i++) {
            curr.add(line1.get(i));
            dfs(line1, i+1, level, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
