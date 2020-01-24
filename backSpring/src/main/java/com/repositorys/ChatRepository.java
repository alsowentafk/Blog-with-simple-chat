package com.repositorys;

import com.models.Chat.Chat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRepository extends CrudRepository<Chat,Long> {
    @Query(nativeQuery = true, value = "SELECT EXISTS(SELECT id, first_user_id, second_user_id FROM chat\n" +
            "WHERE first_user_id = :idFirstUser AND second_user_id = :idSecondUser)")
    Integer checkIfCurrentChatExists(@Param("idFirstUser")Long idFirstUser
            , @Param("idSecondUser")Long idSecondUser);
    @Query(nativeQuery = true, value = "SELECT id, first_user_id, second_user_id FROM chat\n" +
            "WHERE first_user_id = :idFirstUser AND second_user_id = :idSecondUser")
    Chat findChatByUsersId(@Param("idFirstUser")Long idFirstUser
            , @Param("idSecondUser")Long idSecondUser);
    @Query(nativeQuery = true, value = "SELECT id, first_user_id, second_user_id FROM chat\n" +
            "WHERE first_user_id = :idFirstUser OR second_user_id = :idFirstUser")
    List<Chat> findChatsByUserId(@Param("idFirstUser") Long UserId);
}
