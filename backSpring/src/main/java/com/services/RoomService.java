package com.services;

import com.models.Room.Room;
import com.models.Room.RoomDTO;
import com.repositorys.RoomRepository;
import com.transoformers.RoomRoomDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RoomService {
    @Autowired
    private RoomRepository repository;

    @Autowired
    private RoomRoomDTO converter;
    public Room save(RoomDTO roomDTO) {
        return repository.save(converter.ConvertToRoom(roomDTO));
    }
    public List<Room> findAllRooms(){
        return (List<Room>) repository.findAll();
    }
    public Room findRoomByName(String name){
        return repository.findRoomByName(name);
    }
    public Integer checkRoomExist(Long idUser, String nameChat){
        return repository.checkRoomExist(idUser, nameChat);
    };
}
