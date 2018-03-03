package com.bitbucket.atygaev.course.task2.date;

import java.util.Calendar;
import java.util.Date;

/**
 * Some utils methods to work with dates.
 */
public class DateUtils {

    /**
     * TODO: Floor the date.
     * <p>
     * Returns date with 00:00:00 of the given date.
     */
    public static Date floor(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date == null) {
            throw new IllegalArgumentException("Date is not specified.");
        }
        else {
            calendar.setTime(date);
            calendar.set(Calendar.HOUR, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
        }
        Date finish = calendar.getTime();
        return finish;
    }

    /**
     * TODO: Ceil the date.
     * <p>
     * Returns the next day after the given date with 00:00:00.
     */
    public static Date ceil(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Date is not specified.");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        return DateUtils.floor(calendar.getTime());
    }
}