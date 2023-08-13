package org.fed333.sql.data.generator.app.service;

import lombok.RequiredArgsConstructor;
import org.fed333.sql.data.generator.app.entity.ExamResult;
import org.fed333.sql.data.generator.app.repository.ExamResultRepository;
import org.springframework.stereotype.Service;

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
}
