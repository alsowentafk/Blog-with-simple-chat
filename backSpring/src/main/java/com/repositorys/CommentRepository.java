package com.repositorys;

import com.models.Article.Article;
import com.models.Comment.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findByArticleId(Article gameId);
}
