package org.fotech.leetcode;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

import static java.time.temporal.ChronoUnit.DAYS;

public class Tianyiyun {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        int month = in.nextInt();
        int day = in.nextInt();


        int[] monthDay = {31,28,31,30,31,30,31,31,30,31,30,31};
        int[] monthDay2 = {31,29,31,30,31,30,31,31,30,31,30,31};
        int resultDays = 0;
        for (int i = 0; i < month-1; i++) {
            if (year % 4 == 0) {
                resultDays += monthDay2[i];
            } else {
                resultDays += monthDay[i];
            }
        }

        resultDays += day;

        // 判断两个日期之间的天数，与今天做比较
        // 今天是20230326 星期天。
        LocalDate from = LocalDate.of(year, month, day);
        int days = new Long(DAYS.between(from, LocalDate.now())).intValue();
        // 两天之间的天数
        // 取余数
        int m = days % 7;
        // 余数=0 星期天 余数=1星期6 …… 余数=6 星期1
        int resultWeek[] = {0,6,5,4,3,2,1};
        System.out.println(resultDays + " " + resultWeek[m]);


    }
}
