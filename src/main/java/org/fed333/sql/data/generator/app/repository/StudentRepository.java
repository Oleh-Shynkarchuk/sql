package org.fed333.sql.data.generator.app.repository;

import org.fed333.sql.data.generator.app.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
