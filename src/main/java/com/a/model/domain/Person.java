package com.a.model.domain;

import com.a.common.type.DataBaseType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Table(name = "PERSON")
@Entity(name = "person")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "personSeq", sequenceName = "person_seq", allocationSize = 1)
public class Person implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "personSeq")
    private Long personId;
    @Column(columnDefinition = DataBaseType.VARCHAR2_20)
    private String name;
    @Column(columnDefinition = DataBaseType.VARCHAR2_20)
    private String family;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "personId")
    private List<Car> cars;
}
