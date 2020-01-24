package com.controllers;

import com.models.Room.RoomDTO;
import com.models.Room.Room;
import com.models.Room.RoomDTO;
import com.models.User.User;
import com.repositorys.ArticleRepository;
import com.repositorys.UserRepository;
import com.services.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/room")
public class RoomController {
    private final RoomService roomService;
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    @PostMapping("/saveRoom")
    public Room save(@RequestParam Long idFirstUser, @RequestBody RoomDTO roomDTO) {
        if(roomService.checkRoomExist(idFirstUser,roomDTO.getName())!=0){
            return roomService.findRoomByName(roomDTO.getName());
        }
        User user1 = userRepository.findById(idFirstUser).get();
        roomDTO.setUser_id(user1);
        return roomService.save(roomDTO);
    }
    @GetMapping("/findAll")
    public List<Room> findAll(){
        return roomService.findAllRooms();
    }
    @GetMapping("/findByName")
    public Room findAll(@RequestParam  String name){
        return roomService.findRoomByName(name);
    }
}
