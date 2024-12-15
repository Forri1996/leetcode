package org.fotech.huawei;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 让我们来模拟一个工作队列的运作，有一个任务提交者和若干任务执行者，执行者从1开始编号
 * 提交者会在给定的时刻向工作队列提交任务，任务有执行所需的时间，
 * 执行者取出任务的时刻加上执行时间即为任务完成的时刻
 * 执行者完成任务变为空闲的时刻会从工作队列中取最老的任务执行，若这一时刻有多个空闲的执行者，其中优先级最高的会执行这个任务。
 * 编号小的执行者优先级高。初始状态下所有执行者都空闲。
 * 工作队列有最大长度限制，当工作队列满而有新的任务需要加入队列时，队列中最老的任务会被丢弃。
 * 特别的，在工作队列满的情况下，当执行者变为空闲的时刻和新的任务提交的时刻相同时，队列中最老的任务被取出执行，新的任务加入队列。
 * 输入描述:
 * 输入为两行。
 * 第一行为2N个正整数，代表提交者提交的N个任务的时刻和执行时间。
 * 第一个数字是第一个任务的提交时刻，第二个数字是第一个任务的执行时间，以此类推。用例保证提交时刻不会重复，任务按提交时刻升序排列。
 * 第二行为两个数字，分别为工作队列的最大长度和执行者的数量。
 * 两行的数字都由空格分隔。N不超过20，数字为不超过1000的正整数
 * 输出描述:
 * 输出两个数字，分别为最后一个任务执行完成的时刻和被丢弃的任务的数量，数字由空格分隔。
 * 示例1:
 * 输入:
 * 1 3 2 2 3 3
 * 3 2
 * 输出:
 * 7 0
 * 示例2:
 * 输入:
 * 1 6 2 4 4 3 6 3
 * 1 2
 * 输出:
 * 10 0
 * 示例3:
 * 输入∶
 * 1 6 2 4 3 3 4 3 6 3
 * 1 2
 * 输出:
 * 10 1
 */
public class Homework1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] config = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int execNum = config[0];
        int workQueueSize = config[1];

//        int[] nums = new int[] { 1, 3, 2, 2, 3, 3};
//        int execNum = 2;
//        int workQueueSize = 3;
        int[] res = doJob(execNum, nums, workQueueSize);
        System.out.println(res);
    }


    public static int[] doJob(int execNum, int[] nums, int workQueueSize) {
        /**
         * 定义一个时间游标
         * 定义一个执行中的任务队列。这应该是一个优先队列，时间结束的早的，任务先出来
         * 定义个排队队列 linkedlist 先进先出
         */
        int time = 0;
        int discard = 0;
        LinkedList<Task> taskQueue = new LinkedList<>();
        PriorityQueue<Task> workingQueue = new PriorityQueue<>();

        boolean isFirst = true;
        // 当前执行中的数量
        int currentWorkingNum = 0;

        int k = 0;
        while (isFirst || !taskQueue.isEmpty() || !workingQueue.isEmpty()) {
            isFirst = false;
            time++;

            // 工作中最先完成的任务的执行时间与当前相等
            while (!workingQueue.isEmpty() && workingQueue.peek().getEndTime() == time) {
                workingQueue.poll();
                currentWorkingNum--;
            }
            // 判断排队队列中是否有任务需要执行，有并且执行器数量有富裕，则加入到workingQueue
            while (!taskQueue.isEmpty() && currentWorkingNum < execNum) {
                Task task = taskQueue.removeFirst();
                task.setStartTime(time);
                task.setEndTime(time + task.getExecTime());
                workingQueue.add(task);
                currentWorkingNum++;
            }

            // k 代表取nums中的第几个任务
            if (k < nums.length / 2 && time == nums[2 * k]) {
                // 如果当前执行器还有剩余，则直接执行
                if (currentWorkingNum < execNum) {
                    Task task = new Task();
                    task.setStartTime(time);
                    task.setExecTime(nums[2*k + 1]);
                    task.setEndTime(time + task.getExecTime());
                    currentWorkingNum++;
                    workingQueue.add(task);
                } else {
                    // 如果排队队列满了，就丢弃最先进来的任务，否则就加入排队队列
                    if (taskQueue.size() == workQueueSize) {
                        discard++;
                        taskQueue.removeFirst();
                    } else {
                        Task task = new Task();
                        task.setStartTime(time);
                        task.setExecTime(nums[2*k + 1]);
                        task.setEndTime(time + task.getExecTime());
                        taskQueue.addLast(task);
                    }
                }
                k++;
            }
        }

        return new int[]{time, discard};
    }
    public  static class Task implements Comparable<Task> {
        // 序号，对应第一行第一个
        private int id;
        // 执行持续时间，对应第一行第二个
        private int execTime;
        // 实际开始时间
        private int startTime;
        // 实际结束时间
        private int endTime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getExecTime() {
            return execTime;
        }

        public void setExecTime(int execTime) {
            this.execTime = execTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Task o) {
            return this.getEndTime() - o.endTime;
        }
    }
}
