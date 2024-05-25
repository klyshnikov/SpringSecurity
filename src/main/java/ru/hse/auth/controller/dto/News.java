package ru.hse.auth.controller.dto;

import lombok.AllArgsConstructor;

public class News {
    public String name;
    public String description;
    public Boolean isDeleted = false;

    public News(String name, String description, Boolean isDeleted) {
        this.name = name;
        this.description = description;
        this.isDeleted = false;
    }
}
