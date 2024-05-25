package ru.hse.auth.controller.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.hse.auth.api.controller.AdminApi;
import ru.hse.auth.api.service.NewsService;
import ru.hse.auth.controller.NewsMapper;
import ru.hse.auth.controller.dto.News;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController implements AdminApi {
    private final NewsService newsService;

    public AdminController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/news")
    public List<News> getNews() {
        NewsMapper newsMapper = new NewsMapper();
        List<ru.hse.auth.api.data.News> allApiNews = newsService.getAllNotDeletedNews();
        List<News> allNews = new ArrayList<News>();
        for (var n : allApiNews) {
            allNews.add(newsMapper.ApiNewsToControllerNews(n));
        }
        return allNews;
    }

    @PostMapping("/news")
    public News addNews(News news) {
        NewsMapper newsMapper = new NewsMapper();
        return newsMapper.ApiNewsToControllerNews(newsService.addNews(news.name, newsMapper.ControllerNewsToApiNews(news)));
    }

    @PutMapping("/news")
    public News redactNews(News news) {
        NewsMapper newsMapper = new NewsMapper();
        return newsMapper.ApiNewsToControllerNews(newsService.redactNews(news.name, newsMapper.ControllerNewsToApiNews(news)));
    }
}
