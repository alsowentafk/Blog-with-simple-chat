package com.models.Hashtag;

import com.models.Article.Article;
import com.models.Hobby.Hobby;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HashTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    private Long id;
    @ManyToOne(targetEntity = Hobby.class, fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "hobby_id")
    private Hobby hobby_id;
    @ManyToOne(targetEntity = Article.class, fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "article_id")
    private Article article_id;
}
