package Helpers;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateTimeHelper {
    
//    public static Map<String, String> formatSqlDateTime(Timestamp sqlDateTime) {
//        Map<String, String> formattedDateTimeMap = new HashMap<>();
//
//        if (sqlDateTime != null) {
//            // Convert Timestamp to Date
//            Date date = new Date(sqlDateTime.getTimestamp());
//
//            // Format short date
//            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//            String shortDate = dateFormat.format(date);
//
//            // Format short time
//            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
//            String shortTime = timeFormat.format(date);
//
//            // Put values into the map
//            formattedDateTimeMap.put("shortDate", shortDate);
//            formattedDateTimeMap.put("shortTime", shortTime);
//        }
//
//        return formattedDateTimeMap;
//    }
    

    public static String calculateDuration(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        Duration duration = Duration.between(startDateTime, endDateTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
