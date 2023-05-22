package org.fotech.huawei;

import java.util.*;
import java.util.stream.Collectors;

public class SolutionC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String group = sc.nextLine();
        String conn = sc.nextLine();
        group = group.replaceAll("\\[", "");
        group = group.replaceAll("]", "");

        conn = conn.replaceAll("\\[", "");
        conn = conn.replaceAll("]", "");

        List<String> connArr = Arrays.asList(conn.split(","));
        String[] grouopArr = group.split(",");
        List<String[]> groupArrArr = new ArrayList<>();
        int m = 0;
        int j = 0;
        for (int i = 0; i < grouopArr.length; i++) {
            if (m % 2 == 0) {
                String[] a = new String[2];
                a[0] = grouopArr[i];
                groupArrArr.add(a);
                m++;
            } else if (m % 2 == 1) {
                groupArrArr.get(j)[1] = grouopArr[i];
                j++;
                m++;
            }
        }
        // 先把区间按左区间大小先排个序
        // 从左到右判断是否可以链接。.stream().sorted(Comparator.comparing(Student::getLeiJiYiFuDiFangChaE))
        groupArrArr = groupArrArr.stream().sorted(Comparator.comparing(e -> Integer.valueOf(e[0]))).collect(Collectors.toList());

        int combined = 1;
        int left = 0;
        int right = 0;
        for (int i = 0; i < groupArrArr.size(); i++) {
            if (i == 0) {
                left =   Integer.valueOf(groupArrArr.get(0)[0]);
                right = Integer.valueOf(groupArrArr.get(0)[1]);
                continue;
            }
            int leftItem = Integer.valueOf(groupArrArr.get(i)[0]);
            right = Integer.valueOf(groupArrArr.get(i)[1]);

            if (leftItem >= right) {
                combined++;
            }
            if(connArr.contains(String.valueOf(right-leftItem))) {
                combined++;
            }
        }

        System.out.println(groupArrArr.size() - combined);
    }
}
