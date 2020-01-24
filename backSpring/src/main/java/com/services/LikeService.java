package com.services;

import com.models.Like.Like;
import com.models.Like.LikeDTO;
import com.repositorys.LikeRepository;
import com.repositorys.LikeRepository;
import com.transoformers.LikeLikeDTO;
import com.transoformers.LikeLikeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LikeService {
    @Autowired
    private LikeRepository repository;

    @Autowired
    private LikeLikeDTO converter;
    public void save(LikeDTO likeDTO) {
        repository.save(converter.ConvertToLike(likeDTO));
    }
    public Integer getLikes(Long id){
       return repository.maxLike(id);
    }
    public Like checkUserLikeExist(Long idArticle, Long idUser){
        return repository.checkUserLikeExist(idArticle,idUser);
    }
    public void decrementRows(){
        repository.decrementRows();
    }
    public void deleteUserLike(Long idUser){
        repository.deleteUserLike(idUser);
    }
}
