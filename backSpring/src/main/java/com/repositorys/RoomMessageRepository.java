package com.repositorys;

import com.models.Message.Message;
import com.models.RoomMessage.RoomMessage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomMessageRepository extends CrudRepository<RoomMessage, Long> {
    @Query(nativeQuery = true, value = "SELECT  room_message.id, room_message.user_id, room_message.room_id, room_message.text, room_message.date FROM room_message\n" +
            "INNER JOIN room r on room_message.room_id = r.id\n" +
            "WHERE room_id = :idRoom")
    List<RoomMessage> findMessageFromRoom(@Param("idRoom") Long idRoom);
}
