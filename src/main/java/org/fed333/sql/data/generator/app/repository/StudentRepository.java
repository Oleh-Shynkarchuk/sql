package org.fed333.sql.data.generator.app.repository;

import org.fed333.sql.data.generator.app.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> {
    @Query(value = "SELECT * FROM student s WHERE s.surname REGEXP :regex", nativeQuery = true)
    List<Student> findBySurnameRegex(@Param("regex") String regex);
    @Query("SELECT DISTINCT s.primarySkill FROM Student s WHERE " +
            "s.primarySkill LIKE CONCAT('%', ' ', '%') OR " +
            "s.primarySkill LIKE CONCAT('%', '-', '%')")
    List<String> findSkills();
    @Query("SELECT s.name AS subjectName, COUNT(sr.student.id) AS numStudentsPassed " +
            "FROM ExamResult sr " +
            "JOIN sr.subject s " +
            "WHERE sr.mark >= :passingMark " +
            "GROUP BY s.name " +
            "ORDER BY numStudentsPassed DESC")
    List<Map<String, Integer>> findSubjectsAndNumStudentsPassed(Short passingMark);
}
