package com.example.home.model;

public class Alumno {

    private String name;
    private String father_surname;
    private String mother_surname;
    private boolean gender;
    private int no_imss;
    private boolean status;
    private int barcode;

    public Alumno(String name, String father_surname, String mother_surname, boolean gender, int no_imss, boolean status, int barcode) {
        this.name = name;
        this.father_surname = father_surname;
        this.mother_surname = mother_surname;
        this.gender = gender;
        this.no_imss = no_imss;
        this.status = status;
        this.barcode = barcode;
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

    public int getNo_imss() {
        return no_imss;
    }

    public void setNo_imss(int no_imss) {
        this.no_imss = no_imss;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }
}
