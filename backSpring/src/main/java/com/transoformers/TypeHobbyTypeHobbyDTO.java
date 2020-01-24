package com.transoformers;

import com.models.TypeHobby.TypeHobby;
import com.models.TypeHobby.TypeHobbyDTO;
import org.springframework.stereotype.Service;

@Service
public class TypeHobbyTypeHobbyDTO {
    public TypeHobby ConvertToTypeHobby(TypeHobbyDTO typeHobbyDTO) {
        TypeHobby typeHobby = new TypeHobby();
        typeHobby.setTh_id(typeHobbyDTO.getTh_id());
        typeHobby.setName(typeHobbyDTO.getName());
        return typeHobby;
    }

    public TypeHobbyDTO ConvertToTypeHobbyDTO(TypeHobby typeHobby) {
        TypeHobbyDTO typeHobbyDTO = new TypeHobbyDTO();
        typeHobbyDTO.setTh_id(typeHobby.getTh_id());
        typeHobbyDTO.setName(typeHobby.getName());
        return typeHobbyDTO;
    }
}
