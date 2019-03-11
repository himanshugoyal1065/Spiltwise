/*
package com.app.splitwise.testify;

import com.app.splitwise.framework.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor

public class Parents {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;

    String surname;

    @OneToMany
    @JoinColumn(name="parent_id",referencedColumnName = "id")
    Person persons;

}
*/
