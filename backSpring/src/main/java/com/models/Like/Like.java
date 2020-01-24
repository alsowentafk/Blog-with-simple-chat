package com.models.Like;

import com.models.Article.Article;
import com.models.User.User;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "`like`")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @ManyToOne(targetEntity = Article.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "article_id")
    private Article article_id;
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user_id;
    private Integer amount;
}
