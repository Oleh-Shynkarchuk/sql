package org.fed333.sql.data.generator.app.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class NameSupplierServiceTest {

    @InjectMocks
    private NameSupplierService service = new NameSupplierService();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @RepeatedTest(99)
    public void getName_returnedNameShouldMatchRegex() {
        String actual = service.getName();
        log.info("Name: {}", actual);
        assertTrue(actual.matches("^(\\p{Lu})('?\\p{Ll})*$"));
    }
}