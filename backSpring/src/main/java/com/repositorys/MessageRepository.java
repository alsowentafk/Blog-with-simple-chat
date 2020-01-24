package com.repositorys;

import com.models.Message.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message,Long> {
    @Query(nativeQuery = true, value = "SELECT message.id, message.user_id, message.text, message.chat_id, message.date from message\n" +
            "INNER JOIN chat c on message.chat_id = c.id\n" +
            "WHERE c.first_user_id = :id_first_user AND c.second_user_id = :id_second_user")
    List<Message> findMessagesFromChatByUsersId(@Param("id_first_user")Long idFirstUser,
                                      @Param("id_second_user")Long idSecondUser);
    @Query(nativeQuery = true, value = "SELECT m.id, chat_id, user_id, text, date FROM chat\n" +
            "INNER JOIN message m on chat.id = m.chat_id\n" +
            "WHERE chat_id = :idChat\n" +
            "ORDER BY date")
    List<Message> findMessageFromChat(@Param("idChat") Long idCHat);
}
