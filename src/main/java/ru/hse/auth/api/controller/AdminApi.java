package ru.hse.auth.api.controller;

import ru.hse.auth.controller.dto.News;

import java.util.List;

public interface AdminApi {
    List<News> getNews();
    News addNews(News news);
    News redactNews(News news);
}
