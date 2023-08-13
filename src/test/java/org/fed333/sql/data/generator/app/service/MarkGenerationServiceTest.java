package org.fed333.sql.data.generator.app.service;

import lombok.extern.slf4j.Slf4j;
import org.fed333.sql.data.generator.app.rule.Repeat;
import org.fed333.sql.data.generator.app.rule.RepeatedTestRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class MarkGenerationServiceTest {

    @Rule
    public final RepeatedTestRule repeatedTestRule = new RepeatedTestRule();

    @InjectMocks
    private MarkGenerationService service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Repeat(times = 99)
    public void generateMark() {
        Short actual = service.generateMark();
        log.info("test invoke!");
        assertTrue(actual >= 1 && actual <= 10);
    }
}