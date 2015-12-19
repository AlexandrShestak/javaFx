package com.tp.course.entity;

import javax.persistence.*;

/**
 * Created by shestakam on 19.12.2015.
 */
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue
    @Column(name = "id" , unique = true , nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {

        return id;
    }
}
