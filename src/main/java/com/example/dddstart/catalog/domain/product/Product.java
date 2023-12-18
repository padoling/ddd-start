package com.example.dddstart.catalog.domain.product;

import com.example.dddstart.catalog.domain.category.CategoryId;
import com.example.dddstart.common.jpa.MoneyConverter;
import com.example.dddstart.order.domain.Money;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @EmbeddedId
    private ProductId productId;

    // 애그리거트 간 단방향 집합 연관
    // @ElementCollection을 이용하기 때문에 Product를 삭제할 때 조인 테이블의 데이터도 함께 삭제된다.
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"))
    private Set<CategoryId> categoryIds;

    private String name;

    @Convert(converter = MoneyConverter.class)
    private Money price;

    private String detail;

    // 상속 때문에 Entity로 지정했지만 Value이므로 독자적인 라이프사이클을 갖지 않고 Product에 의존한다.
    // 저장 및 삭제 시 함께 저장 및 삭제되도록 cascade를 설정한다.
    // 애그리거트 로딩 시 같이 로딩되도록 즉시 로딩 옵션 부여
    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    @OrderColumn(name = "list_idx")
    private List<Image> images = new ArrayList<>();

    // 애그리거트 조회 시 항상 즉시 로딩이 될 필요 없다면 LAZY 옵션 고려
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "product_option",
            joinColumns = @JoinColumn(name = "product_id"))
    @OrderColumn(name = "list_idx")
    private List<Option> options = new ArrayList<>();

    // 실제 Option 컬렉션에 접근할 때 로딩
    public void removeOption(int optIdx) {
        this.options.remove(optIdx);
    }

    public Product() {
    }

    // 하이버네이트에서 @OneToMany 매핑에서의 컬렉션의 clear()를 호출하면 각 개별 entity에 대해 delete를 실행한다.
    // 한번의 delete 쿼리로 삭제를 수행하려면 @Embeddable로 매핑된 단일 클래스로 구현해야 한다.
    public void changeImages(List<Image> newImages) {
        images.clear();
        images.addAll(newImages);
    }
}
