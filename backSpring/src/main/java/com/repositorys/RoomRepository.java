package com.repositorys;

import com.models.Room.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RoomRepository extends CrudRepository<Room, Long> {
    Room findRoomByName(String name);
    @Query(nativeQuery = true, value = "SELECT EXISTS(SELECT id, name, user_id FROM room\n" +
            "            WHERE user_id = :idUser OR name = :nameChat)")
    Integer checkRoomExist(@Param("idUser") Long idUser, @Param("nameChat") String nameChat);
}
