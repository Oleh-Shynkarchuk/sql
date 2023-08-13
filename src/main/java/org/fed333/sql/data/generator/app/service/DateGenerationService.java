package org.fed333.sql.data.generator.app.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class DateGenerationService {

    public LocalDate generateDate() {
        return between(LocalDate.of(1980, 1, 1), LocalDate.of(LocalDate.now().getYear()-18, 12, 31).plusDays(1));
    }

    public LocalDateTime generateDateTime() {
        return LocalDateTime.of(generateDate(), between(LocalTime.of(9,0), LocalTime.of(18, 0)));
    }

    private LocalDate between(LocalDate startInclusive, LocalDate endExclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomDay);
    }

    private LocalTime between(LocalTime startTime, LocalTime endTime) {
        int startSeconds = startTime.toSecondOfDay();
        int endSeconds = endTime.toSecondOfDay();
        int randomTime = ThreadLocalRandom
                .current()
                .nextInt(startSeconds, endSeconds);

        return LocalTime.ofSecondOfDay(randomTime);
    }
}
