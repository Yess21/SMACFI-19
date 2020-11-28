package com.example.home.models;

import java.sql.Timestamp;

public class Personas_canalizadas {

    private int id;
    private Alumnos alumno;
    private String observations;
    private boolean status;
    private Timestamp published_at;
    private User created_by;
    private User updated_by;
    private Timestamp created_at;
    private Timestamp updated_at;

    public Personas_canalizadas() {
        this.id = 0;
        this.alumno = null;
        this.observations = "";
        this.status = false;
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

    public Alumnos getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
