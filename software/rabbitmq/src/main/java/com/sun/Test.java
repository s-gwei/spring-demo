package com.sun;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Test {
    public static void main(String[] args) {
        // 示例时间戳
        Timestamp timestamp1 = Timestamp.valueOf("2021-01-01 19:00:00");
        Timestamp timestamp2 = Timestamp.valueOf("2021-01-03 00:00:00");

        // 将Timestamp转换为LocalDateTime
        LocalDateTime dateTime1 = timestamp1.toLocalDateTime().toLocalDate().atStartOfDay();
        LocalDateTime dateTime2 = timestamp2.toLocalDateTime().toLocalDate().atStartOfDay();

        // 计算相差的天数
        long daysDiff = ChronoUnit.DAYS.between(dateTime1, dateTime2);

        System.out.println("相差天数: " + daysDiff);
    }
}