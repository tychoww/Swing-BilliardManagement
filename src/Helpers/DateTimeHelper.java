package Helpers;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class providing helper methods for handling date and time operations.
 */
public class DateTimeHelper {

    /**
     * Formats the date part of a LocalDateTime object in "MM/dd/yyyy" pattern.
     *
     * @param dateTime The LocalDateTime object to format.
     * @return A string representing the formatted date or null if the input is null.
     */
    public static String formatSqlDateShort(LocalDateTime dateTime) {
        if (dateTime != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            return dateTime.format(formatter);
        }
        return null;
    }

    /**
     * Formats the time part of a LocalDateTime object in "HH:mm:ss" pattern.
     *
     * @param dateTime The LocalDateTime object to format.
     * @return A string representing the formatted time or null if the input is null.
     */
    public static String formatSqlTimeShort(LocalDateTime dateTime) {
        if (dateTime != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            return dateTime.format(formatter);
        }
        return null;
    }

    /**
     * Calculates the duration between two LocalDateTime objects and returns the result in "HH:mm:ss" format.
     *
     * @param startDateTime The starting LocalDateTime.
     * @param endDateTime   The ending LocalDateTime.
     * @return A formatted string representing the duration between startDateTime and endDateTime.
     */
    public static String calculateDuration(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        Duration duration = Duration.between(startDateTime, endDateTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
    
    public static long calculateDurationToMinute(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        Duration duration = Duration.between(startDateTime, endDateTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        long totalMinutes = hours * 60 + minutes;
        return totalMinutes;
    }
}
