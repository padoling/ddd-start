package com.example.dddstart.board.domain;

import jakarta.persistence.*;
import lombok.Getter;

// SecondaryTable의 name은 밸류를 저장할 테이블 지정
// ppkJoinColumns는 밸류 테이블에서 엔티티 테이블로 조인할 때 사용할 컬럼 지정
@Entity
@Getter
@Table(name = "article")
@SecondaryTable(
        name = "article_content",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "id")
)
public class Article {

    // 식별자로 DB 자동 증가 컬럼 사용
    // insert 쿼리를 실행해야 식별자가 생성되므로 도메인 객체를 생성하는 시점에는 식별자를 알 수 없다
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @AttributeOverrides({
            @AttributeOverride(
                    name = "content",
                    column = @Column(table = "article_content", name = "content")),
            @AttributeOverride(
                    name = "contentType",
                    column = @Column(table = "article_content", name = "content_type"))
    })
    @Embedded
    private ArticleContent content;

    protected Article() {
    }

    public Article(String title, ArticleContent content) {
        this.title = title;
        this.content = content;
    }
}
