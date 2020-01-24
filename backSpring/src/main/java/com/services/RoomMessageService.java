package com.services;

import com.models.Message.Message;
import com.models.Message.MessageDTO;
import com.models.RoomMessage.RoomMessage;
import com.models.RoomMessage.RoomMessageDTO;
import com.repositorys.RoomMessageRepository;
import com.transoformers.RoomMessageRoomMessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RoomMessageService {
    @Autowired
    private RoomMessageRepository repository;

    @Autowired
    private RoomMessageRoomMessageDTO converter;
    public void save(RoomMessageDTO roomMessageDTO) {
        repository.save(converter.ConvertToRoomMessage(roomMessageDTO));
    }
    public List<RoomMessage> findMessagesFromRoom(Long idRoom){
        return repository.findMessageFromRoom(idRoom);
    }
}
