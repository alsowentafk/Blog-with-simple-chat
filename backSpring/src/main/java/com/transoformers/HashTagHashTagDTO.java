package com.transoformers;

import com.models.Hashtag.HashTag;
import com.models.Hashtag.HashTagDTO;
import org.springframework.stereotype.Service;

@Service
public class HashTagHashTagDTO {
    public HashTag ConvertToHashTag(HashTagDTO hashtagDTO) {
        HashTag hashtag = new HashTag();
        hashtag.setId(hashtagDTO.getId());
        hashtag.setHobby_id(hashtagDTO.getHobby_id());
        hashtag.setArticle_id(hashtagDTO.getArticle_id());
        return hashtag;
    }

    public HashTagDTO ConvertToHashTagDTO(HashTag hashtag) {
        HashTagDTO hashtagDTO = new HashTagDTO();
        hashtagDTO.setId(hashtag.getId());
        hashtagDTO.setArticle_id(hashtag.getArticle_id());
        hashtagDTO.setHobby_id(hashtag.getHobby_id());
        return hashtagDTO;
    }
}
