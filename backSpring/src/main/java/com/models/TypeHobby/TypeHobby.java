package com.models.TypeHobby;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TypeHobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "th_id", nullable = false, unique = true)
    private Long th_id;
    private String name;
}
