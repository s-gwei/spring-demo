import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.TimeZone;

public class TimeConverter {
    public static void main(String[] args) {
        // 获取当前时间
        Date currentDate = new Date();

        // 提供一个long类型的分钟数
        long minutes = 20L; // 用你实际的long值替换

        // 在当前时间上添加分钟
        currentDate.setTime(currentDate.getTime() + (minutes * 60L * 1000L));

        // 将最终的Date对象转换为字符串
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC")); // 设置时区，根据需要更改
        String finalDateString = dateFormat.format(currentDate);

        System.out.println("转换后的时间字符串：" + finalDateString);
    }

    // 辅助方法，将日期字符串解析为Date对象
    private static String parseDate(String dateString, long minutes) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date date = dateFormat.parse(dateString);
            // 在Date对象上添加分钟
            date.setTime(date.getTime() + (minutes * 60000L));

            // 将最终的Date对象转换为字符串
            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC")); // 设置时区，根据需要更改
            return dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

