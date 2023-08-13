package org.fed333.sql.data.generator.app.service;

import lombok.RequiredArgsConstructor;
import org.fed333.sql.data.generator.app.entity.Phone;
import org.fed333.sql.data.generator.app.entity.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class StudentGenerationService {

    private static final int MAX_PHONE_NUMBERS_AMOUNT = 6;

    private final DateGenerationService dateGenerator;

    private final NameSupplierService nameGenerator;

    private final SurnameSupplierService surnameGenerator;

    private final PhoneGenerationService phoneGenerator;

    private final SkillGenerationService skillGenerator;

    private final ExamResultGenerationService examsGenerator;

    public Student generateStudent() {
        LocalDateTime createdDatetime = dateGenerator.generateDateTime();
        return Student.builder()
                .name(nameGenerator.getName())
                .surname(surnameGenerator.getSurname())
                .dateOfBirthday(dateGenerator.generateDate())
                .createdDatetime(createdDatetime)
                .updatedDatetime(createdDatetime.plusDays(ThreadLocalRandom.current().nextInt(365)))
                .phones(generatePhones())
                .primarySkill(skillGenerator.getSkill())
                .exams(examsGenerator.generateExams()).build();
    }

    public List<Student> generateStudents(int count) {
        return Stream.generate(this::generateStudent).limit(count).collect(Collectors.toList());
    }

    private List<Phone> generatePhones() {
        int phones = ThreadLocalRandom.current()
                .nextInt(MAX_PHONE_NUMBERS_AMOUNT+1);

        return Stream.generate(phoneGenerator::generatePhone).limit(phones).collect(Collectors.toList());
    }

}
