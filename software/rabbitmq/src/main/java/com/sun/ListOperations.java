package com.sun;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListOperations {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(); // 这里是你的 List
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        int from = 7; // 假设 from 的值为 7
        int to = 12; // 假设 to 的值为 12

        int toIndex = list.indexOf(to);
        if (toIndex != -1) { // 如果找到了 to 的索引
            List<Integer> toLeft = new ArrayList<>();
            List<Integer> toRight = new ArrayList<>();
            List<Integer> fromLeft = new ArrayList<>();

            // 获取 to 左边的元素，不包含 from
            int count = 0;
            for (int i = toIndex - 1; i >= 0 && count < 3; i--) {
                if (list.get(i) == from) {
                    break;
                }
                toLeft.add(list.get(i));
                count++;
            }

            // 获取 to 右边的三个元素
            for (int i = toIndex + 1; i <= Math.min(list.size() - 1, toIndex + 3); i++) {
                toRight.add(list.get(i));
            }

            int fromIndex = list.indexOf(from);
            if (fromIndex != -1) { // 如果找到了 from 的索引
                // 获取 from 左边的三个元素
                for (int i = fromIndex - 1; i >= Math.max(0, fromIndex - 3); i--) {
                    fromLeft.add(list.get(i));
                }
                // 输出结果
                System.out.println("To左边三个元素（不包含from）：" + toLeft);
                System.out.println("To右边三个元素：" + toRight);
                System.out.println("From左边三个元素：" + fromLeft);
            } else {
                System.out.println("未找到from元素。");
            }
        } else {
            System.out.println("未找到to元素。");
        }
    }
}
