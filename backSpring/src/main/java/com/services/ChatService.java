package com.services;

import com.models.Chat.Chat;
import com.models.Chat.ChatDTO;
import com.repositorys.ChatRepository;
import com.transoformers.ChatChatDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ChatService {
    @Autowired
    private ChatRepository repository;

    @Autowired
    private ChatChatDTO converter;
    public Chat save(ChatDTO chatDTO) {
       return repository.save(converter.ConvertToChat(chatDTO));
    }
    public void deleteChat(Long id){
        repository.deleteById(id);
    }
    public Integer checkIfCurrentChatExists(Long idFirstUser, Long idSecondUser){
       return repository.checkIfCurrentChatExists(idFirstUser,idSecondUser);
    }
    public Chat findChatByUsersId(Long idFirstUser, Long idSecondUser){
        return repository.findChatByUsersId(idFirstUser,idSecondUser);
    }
    public List<Chat> findChatsByUsersId(Long userId){
        return repository.findChatsByUserId(userId);
    }
}
