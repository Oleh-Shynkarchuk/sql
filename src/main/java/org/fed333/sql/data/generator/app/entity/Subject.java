package org.fed333.sql.data.generator.app.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "subject")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "tutor")
    private String tutor;

}
