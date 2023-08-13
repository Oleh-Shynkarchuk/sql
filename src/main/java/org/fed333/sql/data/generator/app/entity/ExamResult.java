package org.fed333.sql.data.generator.app.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "exam_result")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExamResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(name = "mark")
    private Short mark;

    @Override
    public String toString() {
        return String.format("ExamResult(id=%d, subject=%s, mark=%s)", id, subject, mark);
    }

}
