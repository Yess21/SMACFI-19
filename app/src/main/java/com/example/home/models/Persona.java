package com.example.home.models;

import java.sql.Timestamp;

public class Persona {

    private int id;
    private String name;
    private String father_surname;
    private String mother_surname;
    private boolean gender;
    private String no_imss;
    private String barcode;
    private boolean status;
    private Timestamp published_at;
    private int created_by;
    private int updated_by;
    private Timestamp created_at;
    private Timestamp updated_at;

    public Persona() {
        this.id = 0;
        this.name = "";
        this.father_surname = "";
        this.mother_surname = "";
        this.gender = false;
        this.no_imss = "";
        this.barcode = "";
        this.status = false;
        this.published_at = null;
        this.created_by = 0;
        this.updated_by = 0;
        this.created_at = null;
        this.updated_at = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFather_surname() {
        return father_surname;
    }

    public void setFather_surname(String father_surname) {
        this.father_surname = father_surname;
    }

    public String getMother_surname() {
        return mother_surname;
    }

    public void setMother_surname(String mother_surname) {
        this.mother_surname = mother_surname;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getNo_imss() {
        return no_imss;
    }

    public void setNo_imss(String no_imss) {
        this.no_imss = no_imss;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
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

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public int getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(int updated_by) {
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
