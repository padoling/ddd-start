package com.example.dddstart.board.application;

import com.example.dddstart.board.domain.Article;
import com.example.dddstart.board.domain.ArticleContent;
import com.example.dddstart.board.domain.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WriteArticleService {
    private final ArticleRepository articleRepository;

    public Long write() {
        Article article = new Article("title", new ArticleContent("content", "type"));
        // EntityManager#save() 실행 시 식별자 생성
        articleRepository.save(article);
        // 저장 이후 식별자 이용 가능
        return article.getId();
    }
}
