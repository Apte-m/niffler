package niffler.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {

    public static String getDateAsString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yy");
        return sdf.format(date);
    }

    public static Date fromString(String dateAsString) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yy");
        try {
            return sdf.parse(dateAsString);
        } catch (ParseException e) {
            throw new RuntimeException("Unable to parse date: " + dateAsString, e);
        }
    }

    public static Date convertDate(String inputDate) {
        // Парсим строку в LocalDateTime объект с помощью DateTimeFormatter
        LocalDateTime localDateTime = LocalDateTime.parse(inputDate + "T00:00:00");

        // Преобразуем LocalDateTime в объект Date
        Date date = Date.from(localDateTime.atZone(ZoneId.of("Europe/Moscow")).toInstant());

        return date;
    }
}
