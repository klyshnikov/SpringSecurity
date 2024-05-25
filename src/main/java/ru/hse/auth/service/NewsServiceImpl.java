package ru.hse.auth.service;

import org.springframework.stereotype.Service;
import ru.hse.auth.api.data.News;
import ru.hse.auth.api.data.NewsRepository;
import ru.hse.auth.api.service.NewsService;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    private NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<News> getAllNotDeletedNews() {
        var allNews = newsRepository.findAll();
        return allNews.stream().filter(obj -> !obj.isDeleted).toList();
    }

    @Override
    public News redactNews(String name, News redactedNews) {
        var toRedactList = newsRepository.findByName(name);
        if (toRedactList.isEmpty()) {
            return null;
        }

        var toRedact = toRedactList.get(0);
        toRedact = redactedNews;
        return newsRepository.save(toRedact);
    }

    @Override
    public News addNews(String name, News newNews) {
        var toRedactList = newsRepository.findByName(name);
        if (toRedactList.isEmpty()) {
            return null;
        }

        var toRedact = toRedactList.get(0);
        toRedact = newNews;
        return newsRepository.save(toRedact);
    }


}
