package com.kn.tip.problem.codewars;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class CountTheDays {
  public String countDays(final Date d){
    // Days are time-zone sensitive
    final ZoneId zone = ZoneId.systemDefault();

    final ZonedDateTime zonedEventTime = ZonedDateTime.ofInstant(d.toInstant(), zone);
    final ZonedDateTime zonedNow = ZonedDateTime.now(zone);

    final LocalDate localEventDate = zonedEventTime.toLocalDate();
    final LocalDate localToday = zonedNow.toLocalDate();

    if (localEventDate.isEqual(localToday)) {
      return "Today is the day!";
    } else if (localEventDate.isBefore(localToday)) {
      return "The day is in the past!";
    } else {
      // Passed, but comment out
      //final long millis = zonedNow.until(zonedEventTime, ChronoUnit.MILLIS);
      //final long conversion = TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS);
      //final long days = millis / conversion;

      // Attempt to use LocalDate#until, but didn't failed. Off by +/- 1
      final long days = zonedNow.until(zonedEventTime, ChronoUnit.DAYS);
      return days + " days";
    }
}
}
