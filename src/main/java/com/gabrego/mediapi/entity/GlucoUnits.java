package com.gabrego.mediapi.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "gluco_units")
public class GlucoUnits {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "description", nullable = false, length = 10)
    private String description;

    public GlucoUnits() {
    }

    public GlucoUnits(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{" + '\'' +
                "id=" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
