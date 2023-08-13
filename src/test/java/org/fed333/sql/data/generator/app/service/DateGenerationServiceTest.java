package org.fed333.sql.data.generator.app.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class DateGenerationServiceTest {

    private static final LocalDate expectedStartDate = LocalDate.of(1980, 1, 1).minusDays(1);
    private static final LocalDate expectedEndDate = LocalDate.of(LocalDate.now().getYear() - 18, 12, 31).plusDays(1);
    private static final LocalTime expectedStartTime = LocalTime.of(9, 0).minusSeconds(1);
    private static final LocalTime expectedEndTime = LocalTime.of(18, 0).plusSeconds(1);

    @InjectMocks
    private DateGenerationService service = new DateGenerationService();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @RepeatedTest(10)
    public void generateDate() {
        LocalDate actualDate = service.generateDate();
        log.info("date: {}", actualDate);
        assertTrue(actualDate.isAfter(expectedStartDate) && actualDate.isBefore(expectedEndDate));
    }

    @Test
    @RepeatedTest(10)
    public void generateDateTime() {
        LocalDateTime actualDateTime = service.generateDateTime();
        log.info("dateTime: {}", actualDateTime);
        LocalDate actualDate = actualDateTime.toLocalDate();
        LocalTime actualTime = actualDateTime.toLocalTime();
        assertTrue(
                actualDate.isAfter(expectedStartDate) &&
                        actualDate.isBefore(expectedEndDate) &&
                        actualTime.isAfter(expectedStartTime) &&
                        actualTime.isBefore(expectedEndTime)
                );

    }
}