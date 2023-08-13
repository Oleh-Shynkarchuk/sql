package org.fed333.sql.data.generator.app.service;

import lombok.RequiredArgsConstructor;
import org.fed333.sql.data.generator.app.entity.ExamResult;
import org.fed333.sql.data.generator.app.entity.Subject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ExamResultGenerationService {

    private static final int MAX_EXAMS_AMOUNT = 10;

    private static final int MIN_EXAMS_AMOUNT = 0;

    private final SubjectService subjectService;

    private final MarkGenerationService markGenerator;

    public ExamResult generateExam(List<Subject> subjects) {
        return ExamResult.builder()
                .mark(markGenerator.generateMark())
                .subject(getRandom(subjects)).build();
    }

    public List<ExamResult> generateExams() {
        List<Subject> subjects = subjectService.findAll();
        return generateExams(subjects);
    }

    public List<ExamResult> generateExams(List<Subject> subjects) {
        int exams = ThreadLocalRandom.current()
                .nextInt(MIN_EXAMS_AMOUNT, MAX_EXAMS_AMOUNT+1);
        return Stream.generate(()->generateExam(subjects)).limit(exams).collect(Collectors.toList());
    }

    private Subject getRandom(List<Subject> subjects) {
        int index = ThreadLocalRandom.current()
                .nextInt(subjects.size());
        return subjects.get(index);
    }

}
