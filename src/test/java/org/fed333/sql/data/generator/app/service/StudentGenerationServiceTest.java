package org.fed333.sql.data.generator.app.service;

import org.fed333.sql.data.generator.app.entity.Student;
import org.fed333.sql.data.generator.app.mock.data.SubjectTestDataUtil;
import org.fed333.sql.data.generator.app.repository.SubjectRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentGenerationServiceTest {

    @MockBean
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentGenerationService service;

    @Before
    public void setUp() {
        when(subjectRepository.findAll()).thenReturn(SubjectTestDataUtil.testSubjects(ArrayList::new));
    }

    @Test
    public void generateStudent_shouldReturnStudentWithFilledAttributes() {
        Student actualStudent = service.generateStudent();

        assertFalse(actualStudent.getName().isEmpty());
        assertFalse(actualStudent.getSurname().isEmpty());
        assertTrue(actualStudent.getExams().size()>4);
        actualStudent.getExams().forEach(e->{
            assertNotNull(e.getMark());
            assertTrue(e.getMark() >= 0 && e.getMark() <= 100);
            assertFalse(e.getSubject().getName().isEmpty());
            assertFalse(e.getSubject().getTutor().isEmpty());
        });

        assertNotNull(actualStudent.getDateOfBirthday());
        assertNotNull(actualStudent.getCreatedDatetime());
        assertNotNull(actualStudent.getUpdatedDatetime());

        assertFalse(actualStudent.getPhones().isEmpty());
        assertFalse(actualStudent.getPrimarySkill().isEmpty());

    }

}