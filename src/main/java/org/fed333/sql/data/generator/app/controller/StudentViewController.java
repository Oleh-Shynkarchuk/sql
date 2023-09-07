package org.fed333.sql.data.generator.app.controller;

import lombok.RequiredArgsConstructor;
import org.fed333.sql.data.generator.app.entity.Student;
import org.fed333.sql.data.generator.app.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/data/view")
@RequiredArgsConstructor
public class StudentViewController {
    private final StudentService studentService;

    @GetMapping("/oneSurname")
    public List<Student> getStudentsWithOnlyOneWordForName() {
        return studentService.findStudents();
    }

    @GetMapping("/skills")
    public List<String> findPrimarySkillsWithMultipleWords() {
        return studentService.findSkills();
    }
    @GetMapping("/subjects/{passingMark}")
    public List<Map<String, Integer>> findSubjectsAndNumStudentsPassed(@PathVariable Short passingMark) {
        return studentService.findSubjectsAndNumStudentsPassed(passingMark);
    }
}
