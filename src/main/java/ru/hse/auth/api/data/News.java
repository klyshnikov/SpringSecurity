package ru.hse.auth.api.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String name;
    public String description;
    public Boolean isDeleted = false;

    public News(String name, String description, Boolean isDeleted) {
        this.name = name;
        this.description = description;
        this.isDeleted = isDeleted;
    }
}
