package com.models.Chat;

import com.models.Article.Article;
import com.models.User.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatDTO {
    private Long id;
    private User first_user_id;
    private User second_user_id;
}
