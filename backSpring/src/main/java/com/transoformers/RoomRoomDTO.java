package com.transoformers;

import com.models.Room.Room;
import com.models.Room.RoomDTO;
import org.springframework.stereotype.Service;

@Service
public class RoomRoomDTO {
    public Room ConvertToRoom(RoomDTO chatDTO) {
        Room chat = new Room();
        chat.setId(chatDTO.getId());
        chat.setUser_id(chatDTO.getUser_id());
        chat.setName(chatDTO.getName());
        return chat;
    }
    public RoomDTO ConvertToRoomDTO(Room chat){
        RoomDTO chatDTO = new RoomDTO();
        chatDTO.setId(chat.getId());
        chatDTO.setUser_id(chat.getUser_id());
        chatDTO.setName(chat.getName());
        return chatDTO;
    }
}
