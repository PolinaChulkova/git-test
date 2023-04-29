package com.example.gistest.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "entities")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Entity {
    @Id
    @Column("entity_id")
    private Long id;
    @Column("user_id")
    private Long userId;
    @Column("name")
    private String name;

    public Entity(Long userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}
