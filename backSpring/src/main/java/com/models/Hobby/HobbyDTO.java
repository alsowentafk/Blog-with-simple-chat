package com.models.Hobby;

import com.models.TypeHobby.TypeHobby;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HobbyDTO {
    private Long hobby_id;
    private String name;
    private TypeHobby th_id;
}
