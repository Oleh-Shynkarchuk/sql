package org.fed333.sql.data.generator.app.service;

import lombok.RequiredArgsConstructor;
import org.fed333.sql.data.generator.app.entity.Subject;
import org.fed333.sql.data.generator.app.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepo;

    public Subject save(Subject subject) {
        return subjectRepo.save(subject);
    }

    public List<Subject> findAll() {
        return subjectRepo.findAll();
    }

}
