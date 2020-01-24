package com.controllers;

import com.models.Chat.Chat;
import com.models.Message.Message;
import com.models.Room.Room;
import com.models.RoomMessage.RoomMessage;
import com.models.RoomMessage.RoomMessageDTO;
import com.models.User.User;
import com.repositorys.ArticleRepository;
import com.repositorys.ChatRepository;
import com.repositorys.RoomRepository;
import com.repositorys.UserRepository;
import com.services.RoomMessageService;
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
@RequestMapping("/api/roomMessage")
public class RoomMessageController {
    private final RoomMessageService roomMessageService;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;
    @PostMapping("/saveRoomMessage")
    public void save(@RequestParam Long idFirstUser, @RequestParam Long idChat
    , @RequestBody RoomMessageDTO roomMessageDTO) {
        User user1 = userRepository.findById(idFirstUser).get();
        Room room = roomRepository.findById(idChat).get();
        roomMessageDTO.setUser_id(user1);
        roomMessageDTO.setRoom_id(room);
        roomMessageDTO.setDate(new Date(System.currentTimeMillis()));
        roomMessageService.save(roomMessageDTO);
        log.info("save {} at {}", roomMessageDTO, Calendar.getInstance().getTime());
    }
    @GetMapping("/findMessagesFromRoom")
    public List<RoomMessage> findMessagesFromRoom(@RequestParam String idRoom){
        return roomMessageService.findMessagesFromRoom(Long.valueOf(idRoom));
    }
}
