package ru.hse.auth.service.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class News {
    public String name;
    public String description;
    public Boolean isDeleted = false;
}
