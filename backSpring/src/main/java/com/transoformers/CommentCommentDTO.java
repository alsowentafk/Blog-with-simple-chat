package com.transoformers;

import com.models.Comment.Comment;
import com.models.Comment.CommentDTO;
import org.springframework.stereotype.Service;

@Service
public class CommentCommentDTO {
    public Comment ConvertToComment(CommentDTO cartDTO) {
        Comment cart = new Comment();
        cart.setId(cartDTO.getId());
        cart.setArticleId(cartDTO.getArticleId());
        cart.setUserId(cartDTO.getUserId());
        cart.setText(cartDTO.getText());
        return cart;
    }
    public CommentDTO ConvertToCommentDTO(Comment cart){
        CommentDTO cartDTO = new CommentDTO();
        cartDTO.setId(cart.getId());
        cartDTO.setArticleId(cart.getArticleId());
        cartDTO.setUserId(cart.getUserId());
        cartDTO.setText(cart.getText());
        return cartDTO;
    }
}
