package com.example.home.models;

public class Role {

    private int id;
    private String name;
    private String description;
    private String type;
    private int created_by;
    private int updated_by;

    public Role() {
        this.id = 0;
        this.name = "";
        this.description = "";
        this.type = "";
        this.created_by = 0;
        this.updated_by = 0;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
