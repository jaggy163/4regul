package test;

import java.time.*;
import java.time.zone.ZoneRules;
import java.util.Objects;


public class TimeClass {
    final static long MILLIS_IN_THE_SECOND = 1000;
    final static long SECONDS_IN_THE_MINUTE = 60;
    final static long MINUTES_IN_THE_HOUR = 60;
    final static long HOURS_IN_THE_DAY = 24;
    final static long DAYS_IN_THE_YEAR = 365;
    final static long MILLIS_IN_THE_YEAR = MILLIS_IN_THE_SECOND * SECONDS_IN_THE_MINUTE * MINUTES_IN_THE_HOUR * HOURS_IN_THE_DAY * DAYS_IN_THE_YEAR;
    final static long MILLIS_IN_THE_LEAP_YEAR = MILLIS_IN_THE_YEAR + MILLIS_IN_THE_SECOND * SECONDS_IN_THE_MINUTE * MINUTES_IN_THE_HOUR * HOURS_IN_THE_DAY;
    final static long MILLIS_IN_THE_DAY = MILLIS_IN_THE_SECOND * SECONDS_IN_THE_MINUTE * MINUTES_IN_THE_HOUR * HOURS_IN_THE_DAY;
    final static long MILLIS_IN_THE_HOUR = MILLIS_IN_THE_SECOND * SECONDS_IN_THE_MINUTE * MINUTES_IN_THE_HOUR;
    final static long MILLIS_IN_THE_MINUTE = MILLIS_IN_THE_SECOND * SECONDS_IN_THE_MINUTE;
    final static long START_YEAR = 1970;

    public static void main(String[] args) throws InterruptedException {


        //System.out.println(System.currentTimeMillis());

        while (true) {
            long currentYear = START_YEAR;
            long currentMonth = 1;
            long currentDayInTheYear = 1;
            long currentDayInTheMonth = 1;
            long currentHours = 0;
            long currentMinutes = 0;
            long currentSeconds = 0;
            boolean nextYearIsLeap = false;
            boolean currentYearIsLeap = false;
            long tmp = System.currentTimeMillis();
            while ((tmp >= MILLIS_IN_THE_YEAR && !nextYearIsLeap) || (tmp >= MILLIS_IN_THE_LEAP_YEAR && nextYearIsLeap)) {
                if ((currentYear - START_YEAR - 1) % 4 == 0) {
                    nextYearIsLeap = true;
                } else {
                    nextYearIsLeap = false;
                }
                if ((currentYear - START_YEAR - 2) % 4 == 0) {
                    currentYearIsLeap = true;
                } else {
                    currentYearIsLeap = false;
                }

                if (currentYearIsLeap) {
                    tmp -= MILLIS_IN_THE_LEAP_YEAR;
                    currentYear++;
                } else {
                    tmp -= MILLIS_IN_THE_YEAR;
                    currentYear++;
                }
            }
            //System.out.println(currentYear + " год");

            while (tmp >= MILLIS_IN_THE_DAY) {
                tmp -= MILLIS_IN_THE_DAY;
                currentDayInTheYear++;
                if (currentDayInTheMonth < Month.of((int) currentMonth).length(currentYearIsLeap)) {
                    currentDayInTheMonth++;
                } else {
                    currentMonth++;
                    currentDayInTheMonth = 1;
                }
            }
            //System.out.println(currentMonth + " месяц");
            //System.out.println(currentDayInTheMonth + " день");

            while (tmp >= MILLIS_IN_THE_HOUR) {
                tmp -= MILLIS_IN_THE_HOUR;
                currentHours++;
            }
            //System.out.println(currentHours + " часов");

            while (tmp >= MILLIS_IN_THE_MINUTE) {
                tmp -= MILLIS_IN_THE_MINUTE;
                currentMinutes++;
            }
            //System.out.println(currentMinutes + " минут");

            while (tmp >= MILLIS_IN_THE_SECOND) {
                tmp -= MILLIS_IN_THE_SECOND;
                currentSeconds++;
            }
            //System.out.println(currentSeconds + " секунд");

            //System.out.println(tmp + "ms осталось");

            //System.out.println(System.currentTimeMillis());

            //System.out.println(LocalTime.now());

            System.out.println(currentYear + "-" + Month.of((int)currentMonth) + "-" + currentDayInTheMonth);
            System.out.println(currentHours + ":" + currentMinutes + ":" + currentSeconds);

            Thread.sleep(1000);
        }
    }
}

// 2020, 2016, 2012, 2008, 2004, 2000, 1996, 1992, 1988, 1984, 1980, 1976, 1972.