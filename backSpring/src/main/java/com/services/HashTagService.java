package com.services;

import com.models.Hashtag.HashTagDTO;
import com.repositorys.HashTagRepository;
import com.transoformers.HashTagHashTagDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HashTagService {
    @Autowired
    private HashTagRepository repository;

    @Autowired
    private HashTagHashTagDTO converter;

    public HashTagDTO getHashTagById(long id) {
        return converter.ConvertToHashTagDTO(repository.findById(id).get());
    }

    public void save(HashTagDTO hashTagODT) {
        repository.save(converter.ConvertToHashTag(hashTagODT));
    }

    public void update(Long id, HashTagDTO hashTagDTO) {
        HashTagDTO temp = converter.ConvertToHashTagDTO(repository.findById(id).get());
        temp.setId(hashTagDTO.getId());
        temp.setHobby_id(hashTagDTO.getHobby_id());
        temp.setArticle_id(hashTagDTO.getArticle_id());
        repository.save(converter.ConvertToHashTag(temp));
    }

    public List<HashTagDTO> getAllHashTags() {
        List<HashTagDTO> hashTagDTOList = new ArrayList<>();
        repository.findAll().forEach(a -> hashTagDTOList.add(this.converter.ConvertToHashTagDTO(a)));
        return hashTagDTOList;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
