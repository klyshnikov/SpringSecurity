package ru.hse.auth.api.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NewsRepository extends CrudRepository<News, Long> {
    List<News> findAll();
    List<News> findByName(String name);
}
