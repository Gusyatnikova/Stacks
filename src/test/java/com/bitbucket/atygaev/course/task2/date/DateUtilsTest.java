package com.bitbucket.atygaev.course.task2.date;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static com.bitbucket.atygaev.course.task2.date.DateUtils.ceil;
import static com.bitbucket.atygaev.course.task2.date.DateUtils.floor;
import static org.junit.Assert.assertEquals;

public class DateUtilsTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Date date;

    @Before
    public void setUp() {
        date = new Date();
    }

    @Test
    public void floorDateShouldThrowExceptionWhenDateIsNull() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Date is not specified.");

        floor(null);
    }

    @Test
    public void floorDateShouldFloorDate() {
        long actualDateInMillis = floor(date).getTime();

        long expectedDateInMillis = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime()
                .truncatedTo(ChronoUnit.DAYS)
                .atZone(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();

        assertEquals(expectedDateInMillis, actualDateInMillis);
    }

    @Test
    public void ceilDateShouldThrowExceptionWhenDateIsNull() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Date is not specified.");

        ceil(null);
    }

    @Test
    public void ceilDateShouldCeilDate() {
        long actualDateInMillis = ceil(date).getTime();

        long expectedDateInMillis = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime()
                .truncatedTo(ChronoUnit.DAYS)
                .plusDays(1L)
                .atZone(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();

        assertEquals(expectedDateInMillis, actualDateInMillis);
    }
}