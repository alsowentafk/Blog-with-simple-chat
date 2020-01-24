package com.services;

import com.models.Hobby.HobbyDTO;
import com.repositorys.HobbyRepository;
import com.transoformers.HobbyHobbyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HobbyService {
    @Autowired
    private HobbyRepository repository;

    @Autowired
    private HobbyHobbyDTO converter;

    public HobbyDTO getHobbyById(long id) {
        return converter.ConvertToHobbyDTO(repository.findById(id).get());
    }

    public void save(HobbyDTO hobbyODT) {
        repository.save(converter.ConvertToHobby(hobbyODT));
    }

    public void update(Long id, HobbyDTO hobbyDTO) {
        HobbyDTO temp = converter.ConvertToHobbyDTO(repository.findById(id).get());
        temp.setHobby_id(hobbyDTO.getHobby_id());
        temp.setName(hobbyDTO.getName());
        temp.setTh_id(hobbyDTO.getTh_id());
        repository.save(converter.ConvertToHobby(temp));
    }

    public List<HobbyDTO> getAllHobbys() {
        List<HobbyDTO> hobbyDTOList = new ArrayList<>();
        repository.findAll().forEach(a -> hobbyDTOList.add(this.converter.ConvertToHobbyDTO(a)));
        return hobbyDTOList;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
