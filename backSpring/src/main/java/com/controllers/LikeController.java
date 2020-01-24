package com.controllers;

import com.models.Article.Article;
import com.models.Like.LikeDTO;
import com.models.User.User;
import com.repositorys.ArticleRepository;
import com.repositorys.UserRepository;
import com.services.LikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/like")
public class LikeController {
    private final LikeService likeService;
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    @PostMapping("/saveLike")
    public void save(@RequestParam Long idArticle, @RequestParam Long idUser) {
        Article article = articleRepository.findById(idArticle).get();
        User user = userRepository.findById(idUser).get();
        LikeDTO likeDTO = new LikeDTO();
        Integer likes = likeService.getLikes(idArticle);
        if(likes == null)
        {
            likes = 0;
        }
        likeDTO.setAmount(++likes);
        likeDTO.setUser_id(user);
        likeDTO.setArticle_id(article);
        if(likeService.checkUserLikeExist(idArticle, idUser) != null) {
            likeService.deleteUserLike(idUser);
            likeService.decrementRows();
            return;
        }
        likeService.save(likeDTO);
        log.info("save {} at {}", likeDTO, Calendar.getInstance().getTime());
    }

    @GetMapping("/getArticleLikes")
    public Integer getLikes(@RequestParam Long id){
        return likeService.getLikes(id);
    }
}
