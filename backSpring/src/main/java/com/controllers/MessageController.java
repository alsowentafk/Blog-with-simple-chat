package com.controllers;

import com.models.Chat.Chat;
import com.models.Message.Message;
import com.models.Message.MessageDTO;
import com.models.User.User;
import com.repositorys.ChatRepository;
import com.repositorys.UserRepository;
import com.services.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/message")
public class MessageController {
    private final MessageService messageService;
    private final UserRepository userRepository;
    private final ChatRepository chatRepository;
    @PostMapping("/saveMessage")
    public void save(@RequestParam Long idFirstUser, @RequestParam Long idChat,
                     @RequestBody MessageDTO messageDTO) {
        User user1 = userRepository.findById(idFirstUser).get();
        Chat chat = chatRepository.findById(idChat).get();
        messageDTO.setUser_id(user1);
        messageDTO.setChat_id(chat);
        messageDTO.setDate(new Date(System.currentTimeMillis()));
        messageService.save(messageDTO);
        log.info("save {} at {}", messageDTO, Calendar.getInstance().getTime());
    }
    @GetMapping("/findMessagesFromChat")
    public List<Message> findMessagesFromChat(@RequestParam String idChat){
        return messageService.findMessagesFromChat(Long.valueOf(idChat));
    }
}
