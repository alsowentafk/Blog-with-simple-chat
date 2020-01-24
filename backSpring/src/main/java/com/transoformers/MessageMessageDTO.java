package com.transoformers;

import com.models.Message.Message;
import com.models.Message.MessageDTO;
import org.springframework.stereotype.Service;

@Service
public class MessageMessageDTO {
    public Message ConvertToMessage(MessageDTO messageDTO) {
        Message message = new Message();
        message.setId(messageDTO.getId());
        message.setChat_id(messageDTO.getChat_id());
        message.setUser_id(messageDTO.getUser_id());
        message.setText(messageDTO.getText());
        message.setDate(messageDTO.getDate());
        return message;
    }
    public MessageDTO ConvertToMessageDTO(Message message){
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setId(message.getId());
        messageDTO.setChat_id(message.getChat_id());
        messageDTO.setUser_id(message.getUser_id());
        messageDTO.setText(message.getText());
        messageDTO.setDate(message.getDate());
        return messageDTO;
    }
}
