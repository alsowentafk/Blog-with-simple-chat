package com.transoformers;

import com.models.Like.Like;
import com.models.Like.LikeDTO;
import org.springframework.stereotype.Service;

@Service
public class LikeLikeDTO {
    public Like ConvertToLike(LikeDTO likeDTO) {
        Like like = new Like();
        like.setId(likeDTO.getId());
        like.setArticle_id(likeDTO.getArticle_id());
        like.setUser_id(likeDTO.getUser_id());
        like.setAmount(likeDTO.getAmount());
        return like;
    }
    public LikeDTO ConvertToLikeDTO(Like like){
        LikeDTO likeDTO = new LikeDTO();
        likeDTO.setId(like.getId());
        likeDTO.setArticle_id(like.getArticle_id());
        likeDTO.setUser_id(like.getUser_id());
        likeDTO.setAmount(like.getAmount());
        return likeDTO;
    }
}
