package ru.hse.auth.controller.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hse.auth.api.controller.UserApi;
import ru.hse.auth.api.service.NewsService;
import ru.hse.auth.controller.NewsMapper;
import ru.hse.auth.controller.dto.News;
import ru.hse.auth.service.NewsServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController implements UserApi {
    private final NewsService newsService;

    public UserController(NewsService newsService) {
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
}
