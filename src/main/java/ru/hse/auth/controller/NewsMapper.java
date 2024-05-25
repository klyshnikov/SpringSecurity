package ru.hse.auth.controller;


public class NewsMapper {
    public static ru.hse.auth.controller.dto.News ApiNewsToControllerNews(ru.hse.auth.api.data.News apiNews) {
        return new ru.hse.auth.controller.dto.News(apiNews.name, apiNews.description, apiNews.isDeleted);
    }

    public static ru.hse.auth.api.data.News ControllerNewsToApiNews(ru.hse.auth.controller.dto.News serviceNews) {
        return new ru.hse.auth.api.data.News(serviceNews.name, serviceNews.description, serviceNews.isDeleted);
    }
}
