package org.fotech.huawei;

import java.util.*;

/**
 * 题目描述
 * 某块业务芯片最小容量单位为1.25G，总容量为M*1.25G，对该芯片资源编号为1，2，...，M。该芯片支持3种不同的配置，分别为A、B、C。
 *
 * 配置A：占用容量为 1.25 * 1 = 1.25G
 * 配置B：占用容量为 1.25 * 2 = 2.5G
 * 配置C：占用容量为 1.25 * 8 = 10G
 * 某块板卡上集成了N块上述芯片，对芯片编号为1，2，...，N，各个芯片之间彼此独立，不能跨芯片占用资源。
 *
 * 给定板卡上芯片数量N、每块芯片容量M、用户按次序配置后，请输出芯片资源占用情况，保证消耗的芯片数量最少。
 *
 * 资源分配规则：按照芯片编号从小到大分配所需资源，芯片上资源如果被占用标记为1，没有被占用标记为0.
 *
 * 用户配置序列：用户配置是按次序依次配置到芯片中，如果用户配置序列种某个配置超过了芯片总容量，丢弃该配置，继续遍历用户后续配置。
 *
 * 输入描述
 * M：每块芯片容量为 M * 1.25G，取值范围为：1~256
 *
 * N：每块板卡包含芯片数量，取值范围为1~32
 *
 * 用户配置序列：例如ACABA，长度不超过1000
 *
 * 输出描述
 * 板卡上每块芯片的占用情况
 *
 * 备注
 * 用户配置是按次序依次配置到芯片中，如果用户配置序列种某个配置超过了芯片总容量，丢弃该配置，继续遍历用户后续配置。
 *
 * 输入
 * 8
 * 2
 * ACABA
 * 输出
 * 11111000
 * 11111111
 */
public class Homework20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer chipNum = Integer.parseInt(in.nextLine());
        Integer blockNum = Integer.parseInt(in.nextLine());
        String input = in.nextLine();

        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i <blockNum; i++) {
            List<String> item = new ArrayList<>();;
            for (int j = 0; j < chipNum; j++) {
                item.add("0");
            }
            result.add(item);
        }

        for (int i = 0; i < input.length(); i++) {
            char currChip = input.charAt(i);
            if (currChip == 'A') {
                boolean flag = false;
                for (List<String> block : result) {
                    for (int j = 0; j < block.size(); j++) {
                        if (block.get(j).equals("0")) {
                            block.set(j, "1");
                            flag = true;
                            break;
                        }
                    }
                    if (flag) break;
                }
            }
            if (currChip == 'B') {
                boolean flag = false;
                for (List<String> block : result) {
                    for (int j = 0; j < block.size(); j++) {
                        if (block.get(j).equals("0") && block.size() - j >=2) {
                            for (int m = j; m < j + 2; m++) {
                                block.set(m, "1");
                            }
                            flag = true;
                            break;
                        }
                    }
                    if (flag) break;
                }
            }
            if (currChip == 'C') {
                boolean flag = false;
                for (List<String> block : result) {
                    for (int j = 0; j < block.size(); j++) {
                        if (block.get(j).equals("0") && block.size() - j >=8) {
                            for (int m = j; m < j + 8; m++) {
                                block.set(m, "1");
                            }

                            flag = true;
                            break;
                        }
                    }
                    if (flag) break;
                }
            }


        }
        System.out.println(result);

    }
}
