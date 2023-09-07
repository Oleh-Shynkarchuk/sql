package org.fed333.sql.data.generator.app.repository;

import org.fed333.sql.data.generator.app.entity.ExamResult;
import org.fed333.sql.data.generator.app.entity.Student;
import org.fed333.sql.data.generator.app.entity.Subject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ExamResultRepository extends JpaRepository<ExamResult, Integer> {

    @Query("SELECT sr.subject.name AS subjectName, sr.mark AS examMark, COUNT(sr.student.id) AS numStudents " +
            "FROM ExamResult sr " +
            "WHERE sr.mark = :mark " +
            "GROUP BY sr.subject.name, sr.mark")
    List<Map<String, Object>> countStudentsBySubjectAndMark(Short mark);

    @Query("SELECT e.student " +
            "FROM ExamResult e " +
            "WHERE e.mark >= :passingMark " +
            "GROUP BY e.student.id " +
            "HAVING COUNT(DISTINCT e.subject) >= 2")
    List<Student> findStudentsPassedAtLeastTwoSubjects(Short passingMark);

    @Query("SELECT e.student " +
            "FROM ExamResult e " +
            "WHERE e.mark >= :passingMark " +
            "GROUP BY e.student.id, e.subject.id " +
            "HAVING COUNT(e.subject.id) >= 2")
    List<Student> findStudentsPassedAtLeastTwoExamsForSameSubject(Short passingMark);

    @Query("SELECT e.subject " +
            "FROM ExamResult e " +
            "WHERE e.student.primarySkill = :primarySkill " +
            "GROUP BY e.subject " +
            "HAVING COUNT(DISTINCT e.student) = 1")
    List<Subject> findSubjectsPassedOnlyByStudentsWithSamePrimarySkill(String primarySkill);

    @Query("SELECT DISTINCT e.subject " +
            "FROM ExamResult e " +
            "WHERE e.subject NOT IN (" +
            "    SELECT e1.subject " +
            "    FROM ExamResult e1 " +
            "    WHERE e1.student.primarySkill = e.student.primarySkill" +
            ")")
    List<Subject> findSubjectsWithDifferentPrimarySkills();

    @Query("SELECT DISTINCT e.subject " +
            "FROM ExamResult e " +
            "WHERE e.subject NOT IN (" +
            "    SELECT e1.subject " +
            "    FROM ExamResult e1 " +
            "    WHERE e1.student.primarySkill = ANY (" +
            "        SELECT e2.student.primarySkill " +
            "        FROM ExamResult e2 " +
            "        WHERE e2.subject = e.subject" +
            "    )" +
            ")")
    List<Subject> findSubjectsWithDifferentPrimarySkillsUsingAny();

    @Query("SELECT e.student " +
            "FROM ExamResult e " +
            "GROUP BY e.student " +
            "HAVING AVG(e.mark) > (SELECT AVG(e2.mark) FROM ExamResult e2)")
    List<Student> findStudentsWithAverageMarkGreaterThanOverallAverage();

    List<Student> findTop5StudentsWithLastExamBetterThanAverage(Pageable pageable);

    @Query("SELECT e.student, " +
            "COALESCE(" +
            "    CASE " +
            "        WHEN MAX(e.mark) BETWEEN 1 AND 3 THEN 'BAD' " +
            "        WHEN MAX(e.mark) BETWEEN 4 AND 6 THEN 'AVERAGE' " +
            "        WHEN MAX(e.mark) BETWEEN 7 AND 8 THEN 'GOOD' " +
            "        WHEN MAX(e.mark) BETWEEN 9 AND 10 THEN 'EXCELLENT' " +
            "        ELSE 'NOT PASSED' " +
            "    END, 'NOT PASSED'" +
            ") " +
            "FROM ExamResult e " +
            "GROUP BY e.student")
    List<Object[]> findBiggestMarkWithDescriptionForStudents();

    @Query("SELECT " +
            "  COUNT(CASE WHEN e.mark BETWEEN 1 AND 3 THEN 1 ELSE null END) AS badCount, " +
            "  COUNT(CASE WHEN e.mark BETWEEN 4 AND 6 THEN 1 ELSE null END) AS averageCount, " +
            "  COUNT(CASE WHEN e.mark BETWEEN 7 AND 8 THEN 1 ELSE null END) AS goodCount, " +
            "  COUNT(CASE WHEN e.mark BETWEEN 9 AND 10 THEN 1 ELSE null END) AS excellentCount " +
            "FROM ExamResult e")
    List<Object[]> countMarksByType();
}
