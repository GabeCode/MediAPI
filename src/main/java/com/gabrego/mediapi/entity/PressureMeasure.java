package com.gabrego.mediapi.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "pressure_measure")
public class PressureMeasure {

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

    @Column(name = "systolic_pressure", length = 7, precision = 2)
    private double systolic_pressure;

    @Column(name = "diastolic_pressure", length = 7, precision = 2)
    private double diastolic_pressure;

    @Column(name = "heart_rate", length = 7, precision = 2)
    private double heart_rate;

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

    public PressureMeasure() {
    }

    public PressureMeasure(int id, double measure, GlucoUnits units, java.sql.Date date, Time time, double systolic_pressure, double diastolic_pressure, double heart_rate, String comments, User user_id, Status status) {
        this.id = id;
        this.measure = measure;
        this.units = units;
        this.date = date;
        this.time = time;
        this.systolic_pressure = systolic_pressure;
        this.diastolic_pressure = diastolic_pressure;
        this.heart_rate = heart_rate;
        this.comments = comments;
        this.user_id = user_id;
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

    public double getSystolic_pressure() {
        return systolic_pressure;
    }

    public void setSystolic_pressure(double systolic_pressure) {
        this.systolic_pressure = systolic_pressure;
    }

    public double getDiastolic_pressure() {
        return diastolic_pressure;
    }

    public void setDiastolic_pressure(double diastolic_pressure) {
        this.diastolic_pressure = diastolic_pressure;
    }

    public double getHeart_rate() {
        return heart_rate;
    }

    public void setHeart_rate(double heart_rate) {
        this.heart_rate = heart_rate;
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
        return "PressureMeasure{" +
                "id=" + id +
                ", measure=" + measure +
                ", units=" + units +
                ", date=" + date +
                ", time=" + time +
                ", systolic_pressure=" + systolic_pressure +
                ", diastolic_pressure=" + diastolic_pressure +
                ", heart_rate=" + heart_rate +
                ", comments='" + comments + '\'' +
                ", user_id=" + user_id +
                ", status=" + status +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
