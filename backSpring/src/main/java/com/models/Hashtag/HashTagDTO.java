package com.models.Hashtag;

import com.models.Article.Article;
import com.models.Hobby.Hobby;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HashTagDTO {
    private Long id;
    private Hobby hobby_id;
    private Article article_id;
}
