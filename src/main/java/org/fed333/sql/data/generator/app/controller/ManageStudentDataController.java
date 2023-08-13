package org.fed333.sql.data.generator.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fed333.sql.data.generator.app.entity.Student;
import org.fed333.sql.data.generator.app.service.StudentGenerationService;
import org.fed333.sql.data.generator.app.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/data/student")
@RequiredArgsConstructor
public class ManageStudentDataController {

    private final StudentGenerationService studentGenerator;

    private final StudentService studentService;

    @PostMapping("/insert/{records}")
    public ResponseEntity<Map<String,String>> insertData(@PathVariable(name = "records") Integer records) {
        log.info("insertion of {} records", records);
        List<Student> inserted = studentService.saveAll(studentGenerator.generateStudents(records));
        return ResponseEntity.ok(Map.of(
                "insertedRecords", records.toString(),
                "records", inserted.toString()
        ));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Map<String,String>> deleteData() {
        log.info("deletion of all data.");
        studentService.deleteAll();
        return ResponseEntity.ok(Map.of("deletedRecords", "all"));
    }
}
