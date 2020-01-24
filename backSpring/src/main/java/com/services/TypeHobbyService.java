package com.services;

import com.models.TypeHobby.TypeHobbyDTO;
import com.repositorys.TypeHobbyRepository;
import com.transoformers.TypeHobbyTypeHobbyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeHobbyService {
    @Autowired
    private TypeHobbyRepository repository;

    @Autowired
    private TypeHobbyTypeHobbyDTO converter;

    public TypeHobbyDTO getTypeHobbyById(long id) {
        return converter.ConvertToTypeHobbyDTO(repository.findById(id).get());
    }

    public void save(TypeHobbyDTO typeHobbyODT) {
        repository.save(converter.ConvertToTypeHobby(typeHobbyODT));
    }

    public void update(Long id, TypeHobbyDTO typeHobbyDTO) {
        TypeHobbyDTO temp = converter.ConvertToTypeHobbyDTO(repository.findById(id).get());
        temp.setTh_id(typeHobbyDTO.getTh_id());
        temp.setName(typeHobbyDTO.getName());
        repository.save(converter.ConvertToTypeHobby(temp));
    }

    public List<TypeHobbyDTO> getAllTypeHobbies() {
        List<TypeHobbyDTO> typeHobbyDTOList = new ArrayList<>();
        repository.findAll().forEach(a -> typeHobbyDTOList.add(this.converter.ConvertToTypeHobbyDTO(a)));
        return typeHobbyDTOList;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
