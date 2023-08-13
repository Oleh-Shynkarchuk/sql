package org.fed333.sql.data.generator.app.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SurnameSupplierServiceTest {

    @InjectMocks
    private SurnameSupplierService service = new SurnameSupplierService();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @RepeatedTest(999)
    public void getSurname_returnedSurnameShouldMatchRegex() {
        String actual = service.getSurname();
        assertTrue(actual.isEmpty() || actual.matches("^((\\p{Lu}\\p{Ll}*)|(\\p{Lu}\\.?))$"));
    }
}