package org.fed333.sql.data.generator.app.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SkillGenerationService {

    private final Random random = new Random(System.nanoTime());

    private static final String[] SKILLS = new String[]{
            "Java", "PostgreSQL", "Spring Boot", "Spring", "Git", "Docker", "Apache Tomcat", "Apache Maven",
            "HTML5", "CSS3", "Amazon Web Services", "Agile", "Scrum", "Kanban", "Object-oriented Programming",
            "English", "REST", "SOLID", "Unit Testing", "Flyway", "Hibernate", "JDBC", "Object-relational mapping",
            "Spring Data", "Spring MVC", "Spring Security", "SQL", "Postman", "JavaScript", "React", "Angular",
            "NodeJS", "Python", "C#", ".NET", "C++", "Go"
    };

    public String getSkill() {
        return SKILLS[random.nextInt(SKILLS.length)];
    }

}
