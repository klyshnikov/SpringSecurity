package ru.hse.auth.api.service;


import ru.hse.auth.api.data.News;

import java.util.List;

public interface NewsService {
    List<News> getAllNotDeletedNews();
    News redactNews(String name, News redactedNews);
    News addNews(String name, News newNews);

}
