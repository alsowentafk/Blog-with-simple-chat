package com.models.RoomMessage;

import com.models.Chat.Chat;
import com.models.Room.Room;
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
public class RoomMessageDTO {
    private Long id;
    private Room room_id;
    private User user_id;
    private String text;
    private Date date;
}
