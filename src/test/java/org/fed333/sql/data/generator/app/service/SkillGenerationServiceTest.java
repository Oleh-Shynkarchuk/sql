package org.fed333.sql.data.generator.app.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Set;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class SkillGenerationServiceTest {

    private static final Set<String> EXPECTED_SKILLS = Set.of(
            "Java", "PostgreSQL", "Spring Boot", "Spring", "Git", "Docker", "Apache Tomcat", "Apache Maven",
            "HTML5", "CSS3", "Amazon Web Services", "Agile", "Scrum", "Kanban", "Object-oriented Programming",
            "English", "REST", "SOLID", "Unit Testing", "Flyway", "Hibernate", "JDBC", "Object-relational mapping",
            "Spring Data", "Spring MVC", "Spring Security", "SQL", "Postman", "JavaScript", "React", "Angular",
            "NodeJS", "Python", "C#", ".NET", "C++", "Go"
    );

    @InjectMocks
    private SkillGenerationService service = new SkillGenerationService();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @RepeatedTest(30)
    public void getSkill_shouldReturnRightSkill() {

        String actualSkill = service.getSkill();

        assertTrue(EXPECTED_SKILLS.contains(actualSkill));
    }
}