package ru.hse.auth.api.controller;

import ru.hse.auth.controller.dto.News;

import java.util.List;

public interface UserApi {
    List<News> getNews();
}
