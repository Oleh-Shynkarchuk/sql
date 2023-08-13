package org.fed333.sql.data.generator.app.repository;

import org.fed333.sql.data.generator.app.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
