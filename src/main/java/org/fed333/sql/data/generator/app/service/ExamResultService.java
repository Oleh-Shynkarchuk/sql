package org.fed333.sql.data.generator.app.service;

import lombok.RequiredArgsConstructor;
import org.fed333.sql.data.generator.app.entity.ExamResult;
import org.fed333.sql.data.generator.app.entity.Student;
import org.fed333.sql.data.generator.app.entity.Subject;
import org.fed333.sql.data.generator.app.repository.ExamResultRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ExamResultService {

    private final ExamResultRepository examResultRepo;

    public ExamResult save(ExamResult examResult) {
        return examResultRepo.save(examResult);
    }

    public void deleteAll() {
        examResultRepo.deleteAll();
    }

    public List<Map<String, Object>> countStudentsBySubjectAndMark(Short countByMark) {
        return examResultRepo.countStudentsBySubjectAndMark(countByMark);
    }

    public List<Student> findStudentsPassedAtLeastTwoSubjects(Short countByMark) {
        return examResultRepo.findStudentsPassedAtLeastTwoSubjects(countByMark);
    }

    public List<Student> findStudentsPassedAtLeastTwoExamsForSameSubject(Short passingMark) {
        return examResultRepo.findStudentsPassedAtLeastTwoExamsForSameSubject(passingMark);
    }

    public List<Subject> findSubjectsPassedOnlyByStudentsWithSamePrimarySkill(String primarySkill) {
        return examResultRepo.findSubjectsPassedOnlyByStudentsWithSamePrimarySkill(primarySkill);
    }
    public List<Subject> findSubjectsWithDifferentPrimarySkills() {
        return examResultRepo.findSubjectsWithDifferentPrimarySkills();
    }

    public List<Subject> findSubjectsWithDifferentPrimarySkillsUsingAny() {
        return examResultRepo.findSubjectsWithDifferentPrimarySkillsUsingAny();
    }
    public List<Student> findStudentsWithAverageMarkGreaterThanOverallAverage() {
        return examResultRepo.findStudentsWithAverageMarkGreaterThanOverallAverage();
    }
    public List<Student> findTop5StudentsWithLastExamBetterThanAverage() {
        return examResultRepo.findTop5StudentsWithLastExamBetterThanAverage(PageRequest.of(0, 5));
    }
    public List<Object[]> findBiggestMarkWithDescriptionForStudents() {
        return examResultRepo.findBiggestMarkWithDescriptionForStudents();
    }

    public List<Object[]> countMarksByType(){
        return examResultRepo.countMarksByType();
    }
}
