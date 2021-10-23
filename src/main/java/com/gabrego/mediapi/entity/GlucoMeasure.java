package com.gabrego.mediapi.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "gluco_measure")
public class GlucoMeasure {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "measure", nullable = false, length = 7, precision = 2)
    private double measure;

    @ManyToOne
    @JoinColumn(name = "units_id", referencedColumnName = "id")
    private GlucoUnits units;

    @Column(name = "date", nullable = false)
    private java.sql.Date date;

    @Column(name = "time", nullable = false)
    private Time time;

    @Column(name = "comments")
    private String comments;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user_id;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updated_at;

    public GlucoMeasure() {
    }

    public GlucoMeasure(int id, double measure, GlucoUnits units, java.sql.Date date, Time time, Status status) {
        this.id = id;
        this.measure = measure;
        this.units = units;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMeasure() {
        return measure;
    }

    public void setMeasure(double measure) {
        this.measure = measure;
    }

    public GlucoUnits getUnits() {
        return units;
    }

    public void setUnits(GlucoUnits units) {
        this.units = units;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "GlucoMeasure{" +
                "id=" + id +
                ", measure=" + measure +
                ", units=" + units +
                ", date=" + date +
                ", time=" + time +
                ", comments='" + comments + '\'' +
                ", user_id=" + user_id +
                ", status=" + status +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
