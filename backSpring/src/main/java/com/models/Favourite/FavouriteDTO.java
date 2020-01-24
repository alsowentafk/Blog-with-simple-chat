package com.models.Favourite;

import com.models.TypeHobby.TypeHobby;
import com.models.User.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FavouriteDTO {
    private Long id;
    private User user_id;
    private TypeHobby th_id;
}
