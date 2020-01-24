package com.services;

import com.models.Article.Article;
import com.models.Comment.CommentDTO;
import com.repositorys.CommentRepository;
import com.transoformers.CommentCommentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CommentService {
    @Autowired
    private CommentRepository repository;

    @Autowired
    private CommentCommentDTO converter;

    public CommentDTO getCommentByID(Long id) {
        return converter.ConvertToCommentDTO(repository.findById(id).get());
    }

    public void save(CommentDTO commentODT) {
        repository.save(converter.ConvertToComment(commentODT));
    }

    public List<CommentDTO> findByArticleId(Article articleId){
        List<CommentDTO> commentDTOList = new ArrayList<>();
        repository.findByArticleId(articleId)
                .forEach(a -> commentDTOList.add(this.converter.ConvertToCommentDTO(a)));
        return commentDTOList;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
