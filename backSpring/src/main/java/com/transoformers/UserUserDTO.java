package com.transoformers;

import com.models.User.User;
import com.models.User.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserUserDTO {

    public User ConvertToUser(UserDTO userDTO) {
        User user = new User();
        user.setUser_id(userDTO.getUser_id());
        user.setEmail(userDTO.getEmail());
        user.setIs_confirmed(userDTO.getIs_confirmed());
        user.setPassword(userDTO.getPassword());
        user.setImage(userDTO.getImage());
        user.setLogin(userDTO.getLogin());
        user.setBirthday(userDTO.getBirthday());
        user.setAbout(userDTO.getAbout());
        user.setPhone(userDTO.getPhone());
        return user;
    }

    public UserDTO ConvertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUser_id(user.getUser_id());
        userDTO.setEmail(user.getEmail());
        userDTO.setIs_confirmed(user.getIs_confirmed());
        userDTO.setPassword(user.getPassword());
        userDTO.setImage(user.getImage());
        userDTO.setLogin(user.getLogin());
        userDTO.setBirthday(user.getBirthday());
        userDTO.setAbout(user.getAbout());
        userDTO.setPhone(user.getPhone());
        return userDTO;
    }
}
