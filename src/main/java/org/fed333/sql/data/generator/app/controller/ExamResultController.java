package org.fed333.sql.data.generator.app.controller;

import org.fed333.sql.data.generator.app.entity.Student;
import org.fed333.sql.data.generator.app.entity.Subject;
import org.fed333.sql.data.generator.app.service.ExamResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/exam")
public class ExamResultController {

    private final ExamResultService examResultService;

    @Autowired
    public ExamResultController(ExamResultService examResultService) {
        this.examResultService = examResultService;
    }

    @GetMapping("/subjects/{countByMark}")
    public List<Map<String, Object>> countStudentsBySubjectAndMark(@PathVariable Short countByMark) {
        return examResultService.countStudentsBySubjectAndMark(countByMark);
    }

    @GetMapping("/students/{countByMark}")
    public List<Student> findStudentsPassedAtLeastTwoSubjects(@PathVariable Short countByMark) {
        return examResultService.findStudentsPassedAtLeastTwoSubjects(countByMark);
    }
    @GetMapping("/passed-two-same-subject")
    public List<Student> findStudentsPassedAtLeastTwoExamsForSameSubject(@RequestParam Short passingMark) {
        return examResultService.findStudentsPassedAtLeastTwoExamsForSameSubject(passingMark);
    }
    @GetMapping("/subjects-passed")
    public List<Subject> findSubjectsPassedOnlyByStudentsWithSamePrimarySkill(@RequestParam String primarySkill) {
        return examResultService.findSubjectsPassedOnlyByStudentsWithSamePrimarySkill(primarySkill);
    }
    @GetMapping("/different-subjects")
    public List<Subject> findSubjectsWithDifferentPrimarySkills() {
        return examResultService.findSubjectsWithDifferentPrimarySkills();
    }

    @GetMapping("/different-subjects-using-any")
    public List<Subject> findSubjectsWithDifferentPrimarySkillsUsingAny() {
        return examResultService.findSubjectsWithDifferentPrimarySkillsUsingAny();
    }
    @GetMapping("/students-average")
    public List<Student> findStudentsWithAverageMarkGreaterThanOverallAverage() {
        return examResultService.findStudentsWithAverageMarkGreaterThanOverallAverage();
    }
    @GetMapping("/top5-students")
    public List<Student> findTop5StudentsWithLastExamBetterThanAverage() {
        return examResultService.findTop5StudentsWithLastExamBetterThanAverage();
    }
    @GetMapping("/biggest-mark")
    public List<Object[]> findBiggestMarkWithDescriptionForStudents() {
        return examResultService.findBiggestMarkWithDescriptionForStudents();
    }
    @GetMapping("/count-marks-by-type")
    public List<Object[]> countMarksByType() {
        return examResultService.countMarksByType();
    }
}
