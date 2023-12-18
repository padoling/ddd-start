package com.example.dddstart.board.domain;

import org.springframework.data.repository.Repository;

public interface ArticleRepository extends Repository<Article, Long> {

    Article save(Article article);
}
