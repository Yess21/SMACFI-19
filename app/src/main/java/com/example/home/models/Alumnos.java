package com.example.home.models;

import java.sql.Timestamp;

public class Alumnos {
    private int id;
    private String enrollment;
    private String degree;
    private String educational_program;
    private String area;
    private int quarter;
    private String group;
    private String system;
    private Persona persona;
    private Timestamp published_at;
    private User created_by;
    private User updated_by;
    private Timestamp created_at;
    private Timestamp updated_at;

    public Alumnos() {
        this.id = 0;
        this.enrollment = "";
        this.degree = "";
        this.educational_program = "";
        this.area = "";
        this.quarter = 0;
        this.group = "";
        this.system = "";
        this.persona = null;
        this.published_at = null;
        this.created_by = null;
        this.updated_by = null;
        this.created_at = null;
        this.updated_at = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getEducational_program() {
        return educational_program;
    }

    public void setEducational_program(String educational_program) {
        this.educational_program = educational_program;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Timestamp getPublished_at() {
        return published_at;
    }

    public void setPublished_at(Timestamp published_at) {
        this.published_at = published_at;
    }

    public User getCreated_by() {
        return created_by;
    }

    public void setCreated_by(User created_by) {
        this.created_by = created_by;
    }

    public User getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(User updated_by) {
        this.updated_by = updated_by;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}
