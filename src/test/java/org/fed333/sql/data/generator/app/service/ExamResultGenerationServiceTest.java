package org.fed333.sql.data.generator.app.service;

import org.fed333.sql.data.generator.app.entity.ExamResult;
import org.fed333.sql.data.generator.app.entity.Subject;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExamResultGenerationServiceTest {

    private final Set<Subject> testSubjects = SubjectTestDataUtil.testSubjects(HashSet::new);

    @MockBean
    private SubjectRepository subjectRepository;

    @Autowired
    private ExamResultGenerationService service;

    @Before
    public void setUp() {
        when(subjectRepository.findAll()).thenReturn(SubjectTestDataUtil.testSubjects(ArrayList::new));
    }


    @Test
    public void generateExam() {
        ExamResult actualExam = service.generateExam(SubjectTestDataUtil.testSubjects(ArrayList::new));

        assertTrue(testSubjects.stream().map(Subject::getName).collect(Collectors.toSet()).contains(actualExam.getSubject().getName()));
        assertTrue(testSubjects.stream().map(Subject::getTutor).collect(Collectors.toSet()).contains(actualExam.getSubject().getTutor()));
    }

    @Test
    public void generateExams() {
        List<ExamResult> actualExams = service.generateExams();

        Set<String> actualExamNames = actualExams.stream().map(e -> e.getSubject().getName()).collect(Collectors.toSet());
        Set<String> actualExamTutors = actualExams.stream().map(e -> e.getSubject().getTutor()).collect(Collectors.toSet());

        assertTrue(testSubjects.stream().map(Subject::getName).collect(Collectors.toSet()).containsAll(actualExamNames));
        assertTrue(testSubjects.stream().map(Subject::getTutor).collect(Collectors.toSet()).containsAll(actualExamTutors));

    }

}