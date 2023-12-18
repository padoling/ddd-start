package com.example.dddstart.board.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class ArticleContent {
    private String content;

    private String contentType;

    protected ArticleContent() {
    }

    public ArticleContent(String content, String contentType) {
        this.content = content;
        this.contentType = contentType;
    }
}
