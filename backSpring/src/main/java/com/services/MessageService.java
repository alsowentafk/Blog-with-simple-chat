package com.services;

import com.models.Message.Message;
import com.models.Message.MessageDTO;
import com.repositorys.MessageRepository;
import com.transoformers.MessageMessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MessageService {
    @Autowired
    private MessageRepository repository;

    @Autowired
    private MessageMessageDTO converter;
    public void save(MessageDTO messageDTO) {
        repository.save(converter.ConvertToMessage(messageDTO));
    }
    public List<Message> findMessagesFromChat(Long idChat){
        return repository.findMessageFromChat(idChat);
    }
}
