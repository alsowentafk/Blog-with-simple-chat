package com.transoformers;

import com.models.Hobby.Hobby;
import com.models.Hobby.HobbyDTO;
import org.springframework.stereotype.Service;

@Service
public class HobbyHobbyDTO {
    public Hobby ConvertToHobby(HobbyDTO hobbyDTO) {
        Hobby hobby = new Hobby();
        hobby.setHobby_id(hobbyDTO.getHobby_id());
        hobby.setName(hobbyDTO.getName());
        hobby.setTh_id(hobbyDTO.getTh_id());
        return hobby;
    }

    public HobbyDTO ConvertToHobbyDTO(Hobby hobby) {
        HobbyDTO hobbyDTO = new HobbyDTO();
        hobbyDTO.setHobby_id(hobby.getHobby_id());
        hobbyDTO.setName(hobby.getName());
        hobbyDTO.setTh_id(hobby.getTh_id());
        return hobbyDTO;
    }
}
