package com.models.Hobby;

import com.models.TypeHobby.TypeHobby;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hobby_id", nullable = false, unique = true)
    private Long hobby_id;
    private String name;
    @ManyToOne(targetEntity = TypeHobby.class, fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "th_id")
    private TypeHobby th_id;
}
