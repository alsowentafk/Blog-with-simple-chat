package com.models.Like;

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
public class LikeDTO {
    private Long id;
    private Article article_id;
    private User user_id;
    private Integer amount;
}
