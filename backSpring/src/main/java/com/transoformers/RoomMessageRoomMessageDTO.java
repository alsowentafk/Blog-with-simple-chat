package com.transoformers;

import com.models.RoomMessage.RoomMessage;
import com.models.RoomMessage.RoomMessageDTO;
import org.springframework.stereotype.Service;

@Service
public class RoomMessageRoomMessageDTO {
    public RoomMessage ConvertToRoomMessage(RoomMessageDTO roomMessageDTO) {
        RoomMessage roomMessage = new RoomMessage();
        roomMessage.setId(roomMessageDTO.getId());
        roomMessage.setRoom_id(roomMessageDTO.getRoom_id());
        roomMessage.setUser_id(roomMessageDTO.getUser_id());
        roomMessage.setText(roomMessageDTO.getText());
        roomMessage.setDate(roomMessageDTO.getDate());
        return roomMessage;
    }
    public RoomMessageDTO ConvertToRoomMessageDTO(RoomMessage roomMessage){
        RoomMessageDTO roomMessageDTO = new RoomMessageDTO();
        roomMessageDTO.setId(roomMessage.getId());
        roomMessageDTO.setRoom_id(roomMessage.getRoom_id());
        roomMessageDTO.setUser_id(roomMessage.getUser_id());
        roomMessageDTO.setText(roomMessage.getText());
        roomMessageDTO.setDate(roomMessage.getDate());
        return roomMessageDTO;
    }
}
