package org.fed333.sql.data.generator.app.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "phone")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "number")
    private String number;

    @Override
    public String toString() {
        return String.format("Phone(id=%d, number=%s)", id, number);
    }
}
