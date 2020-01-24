package com.models.Message;

import com.models.Chat.Chat;
import com.models.User.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {
    private Long id;
    private Chat chat_id;
    private User user_id;
    private String text;
    private Date date;
}
