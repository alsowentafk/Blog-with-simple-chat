package com.repositorys;

import com.models.Like.Like;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface LikeRepository extends CrudRepository<Like,Long> {
    @Query(nativeQuery = true, value = "SELECT MAX(amount) FROM `like` " +
            "WHERE article_id = :id")
    Integer maxLike(@Param("id") Long id);
    @Query(nativeQuery = true, value = "SELECT * FROM `like`\n" +
            "WHERE article_id = :idArticle AND user_id = :idUser")
    Like checkUserLikeExist(@Param("idArticle") Long idArticle, @Param("idUser") Long idUser);
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE `like`\n" +
            "SET amount = amount - 1")
    void decrementRows();
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "DELETE FROM `like` WHERE user_id =:idUser")
    void deleteUserLike(@Param("idUser") Long idUSer);
}
