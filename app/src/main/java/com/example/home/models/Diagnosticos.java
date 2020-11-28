package com.example.home.models;

import java.sql.Timestamp;

public class Diagnosticos {
    private int id;
    private String symptoms;
    private float temperature;
    private String diagnostic;
    private float weight;
    private float height;
    private Personas_canalizadas persona_canalizada;
    private boolean status;
    private Timestamp published_at;
    private User created_by;
    private User updated_by;
    private Timestamp created_at;
    private Timestamp updated_at;

    public Diagnosticos() {
        this.id = 0;
        this.symptoms = "";
        this.temperature = 0;
        this.diagnostic = "";
        this.weight = 0;
        this.height = 0;
        this.persona_canalizada = null;
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

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Personas_canalizadas getPersona_canalizada() {
        return persona_canalizada;
    }

    public void setPersona_canalizada(Personas_canalizadas persona_canalizada) {
        this.persona_canalizada = persona_canalizada;
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
