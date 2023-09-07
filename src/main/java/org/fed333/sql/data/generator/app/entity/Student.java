package org.fed333.sql.data.generator.app.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "student")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "dob")
    private LocalDate dateOfBirthday;

    @Column(name = "primary_skill")
    private String primarySkill;

    @Column(name = "created_datetime")
    private LocalDateTime createdDatetime;

    @Column(name = "updated_datetime")
    private LocalDateTime updatedDatetime;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<Phone> phones;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<ExamResult> exams;

}
