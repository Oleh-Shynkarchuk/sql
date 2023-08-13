package org.fed333.sql.data.generator.app.service;

import lombok.RequiredArgsConstructor;
import org.fed333.sql.data.generator.app.entity.Student;
import org.fed333.sql.data.generator.app.repository.StudentRepository;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.FetchType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepo;

    private final PhoneService phoneService;

    private final ExamResultService examService;

    private final SubjectService subjectService;

    public Student save(Student student) {
        Student saved = studentRepo.save(student);

        Optional.ofNullable(student.getPhones())
                .ifPresent(phones -> phones.forEach(phone->{phone.setStudent(saved); phoneService.save(phone);}));
        Optional.ofNullable(student.getExams())
                .ifPresent(exams -> exams.forEach(exam->{exam.setStudent(saved); examService.save(exam);}));

        return saved;
    }

    @Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    public List<Student> findAll(FetchType fetch) {
        List<Student> all = studentRepo.findAll();
        if (fetch == FetchType.EAGER) {
            all.forEach(s->Hibernate.initialize(s.getExams()));
        }
        return all;
    }

    public List<Student> saveAll(List<Student> students) {
        List<Student> saved = new ArrayList<>();
        for (Student s: students) {
            saved.add(save(s));
        }
        return saved;
    }

    public void deleteAll() {
        phoneService.deleteAll();
        examService.deleteAll();
        studentRepo.deleteAll();
    }
}

