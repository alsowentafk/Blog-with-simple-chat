package com.repositorys;

import com.models.Article.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {
    List<Article> findAllByCategory(String category);

    @Query(value = "SELECT * FROM Article ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<Article> findTop3OrderByRAND();
}
