package org.fed333.sql.data.generator.app.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class PhoneGenerationServiceTest {

    private final Set<String> operatorsCodes = Set.of("067", "068", "096", "097", "098", "063", "073", "093", "050", "066", "095", "099");

    @InjectMocks
    private PhoneGenerationService service = new PhoneGenerationService();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void generatePhone_shouldReturn13LengthString() {
        String actual = service.generatePhoneNumber();
        assertEquals(13, actual.length());
    }

    @Test
    public void generatePhone_shouldReturnNumberWithUkrainianPhoneCode() {
        String actual = service.generatePhoneNumber();
        assertTrue(actual.startsWith("+380"));
    }

    @Test
    @RepeatedTest(10)
    public void generatePhone_shouldReturnCodesOfMobileOperators() {
        @SuppressWarnings("all")
        Set<String> expectedCodes = operatorsCodes;

        String actual = service.generatePhoneNumber();

        String actualCode = actual.substring(3, 6);

        assertTrue(expectedCodes.contains(actualCode));
    }

    @Test
    @RepeatedTest(10)
    public void generatePhone_returnedNumberShouldMatchPhoneRegex() {
        String codesRegex = String.join("|", this.operatorsCodes);
        String regex = String.format("^(\\+38)?(%s){1,1}\\d{7,7}$", codesRegex);

        String actual = service.generatePhoneNumber();

        assertTrue(actual.matches(regex));
    }

}