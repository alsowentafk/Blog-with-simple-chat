package com.controllers;

import com.models.Article.Article;
import com.models.Comment.CommentDTO;
import com.services.CommentService;
import com.models.User.User;
import com.repositorys.ArticleRepository;
import com.repositorys.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {
    private final CommentService commentService;
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    @PostMapping("/saveComment")
    public void save(@RequestParam Long idArticle, @RequestParam Long idUser, @RequestBody CommentDTO commentDTO) {
        Article article = articleRepository.findById(idArticle).get();
        User user = userRepository.findById(idUser).get();
        commentDTO.setArticleId(article);
        commentDTO.setUserId(user);
        commentService.save(commentDTO);
        log.info("save {} at {}", commentDTO, Calendar.getInstance().getTime());
    }
    @GetMapping("/getArticleComments")
    public List<CommentDTO> getGameComments(@RequestParam String id){
        return commentService.findByArticleId(articleRepository.findById(Long.parseLong(id)).get());
    }
}
