package com.controllers;

import com.models.Article.Article;
import com.models.Chat.Chat;
import com.models.Chat.ChatDTO;
import com.models.User.User;
import com.repositorys.ArticleRepository;
import com.repositorys.UserRepository;
import com.services.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chat")
public class ChatController {
    private final ChatService chatService;
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    @PostMapping("/saveChat")
    public Chat save(@RequestParam Long idFirstUser, @RequestParam Long idSecondUser) {
        if(chatService.checkIfCurrentChatExists(idFirstUser,idSecondUser)!=0){
            return chatService.findChatByUsersId(idFirstUser,idSecondUser);
        }
        if(chatService.checkIfCurrentChatExists(idSecondUser,idFirstUser)!=0){
            return chatService.findChatByUsersId(idSecondUser,idFirstUser);
        }
        User user1 = userRepository.findById(idFirstUser).get();
        User user2 = userRepository.findById(idSecondUser).get();
        ChatDTO chatDTO = new ChatDTO();
        chatDTO.setFirst_user_id(user1);
        chatDTO.setSecond_user_id(user2);
        log.info("save {} at {}", chatDTO, Calendar.getInstance().getTime());
        return chatService.save(chatDTO);
    }
    @DeleteMapping("/deleteChat")
    public void deleteChat(@RequestParam Long id){
        this.chatService.deleteChat(id);
    }
    @GetMapping("/check")
    public Integer check(@RequestParam Long idFirstUser, @RequestParam Long idSecondUser){
        return chatService.checkIfCurrentChatExists(idFirstUser, idSecondUser);
    }
    @GetMapping("/getChatByUserId")
    public List<Chat> getChatByUserId(@RequestParam Long userId)
    {
        return chatService.findChatsByUsersId(userId);
    }
}

