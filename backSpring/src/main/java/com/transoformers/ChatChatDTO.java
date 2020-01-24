package com.transoformers;

import com.models.Chat.Chat;
import com.models.Chat.ChatDTO;
import org.springframework.stereotype.Service;

@Service
public class ChatChatDTO {
    public Chat ConvertToChat(ChatDTO chatDTO) {
        Chat chat = new Chat();
        chat.setId(chatDTO.getId());
        chat.setFirst_user_id(chatDTO.getFirst_user_id());
        chat.setSecond_user_id(chatDTO.getSecond_user_id());
        return chat;
    }
    public ChatDTO ConvertToChatDTO(Chat chat){
        ChatDTO chatDTO = new ChatDTO();
        chatDTO.setId(chat.getId());
        chatDTO.setFirst_user_id(chat.getFirst_user_id());
        chatDTO.setSecond_user_id(chat.getSecond_user_id());
        return chatDTO;
    }
}
