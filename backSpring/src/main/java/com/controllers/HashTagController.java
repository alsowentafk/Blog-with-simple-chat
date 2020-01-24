package com.controllers;

import com.models.Article.Article;
import com.models.Hashtag.HashTagDTO;
import com.models.Hobby.Hobby;
import com.repositorys.ArticleRepository;
import com.repositorys.HobbyRepository;
import com.services.HashTagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hashTag")
public class HashTagController {
    private final HashTagService hashTagService;
    private final ArticleRepository articleRepository;
    private final HobbyRepository hobbyRepository;

    @PostMapping("/hobbyId{hobbyId}articleId{articleId}")
    public void save(@PathVariable Long hobbyId, @PathVariable Long articleId,
                     @RequestBody HashTagDTO hashTagDTO) {
        Hobby hobby = hobbyRepository.findById(hobbyId).get();
        Article article = articleRepository.findById(articleId).get();
        hashTagDTO.setHobby_id(hobby);
        hashTagDTO.setArticle_id(article);
        hashTagService.save(hashTagDTO);
        log.info("save {} at {}", hashTagDTO, Calendar.getInstance().getTime());
    }

    @GetMapping("{id}")
    public HashTagDTO getHashTagById(@PathVariable Long id) {
        log.info("get HashTag by id: {} at {}", id, Calendar.getInstance().getTime());
        return hashTagService.getHashTagById(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody HashTagDTO hashTagDTO) {
        hashTagService.update(id, hashTagDTO);
        log.info("update {} at {}", hashTagDTO, Calendar.getInstance().getTime());
    }

    @GetMapping("/all")
    public List<HashTagDTO> getAllHashTag() {
        log.info("get all Hobbies at {}", Calendar.getInstance().getTime());
        return hashTagService.getAllHashTags();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) throws IOException {
        log.info("delete HashTag by Id {} at {}", id, Calendar.getInstance().getTime());
        hashTagService.delete(id);
    }
}
