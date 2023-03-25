package com.tronina.dashbrd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/*Задача может находится в одном из трех статусов (BACKLOG, IN_PROGRESS, DONE).
У задачи должны быть указаны автор, исполнитель, версия релиза.
Задача может быть в статусе IN_PROGRESS, только когда стартовал проект*/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
@Entity
public class Task extends BaseEntity {
    @Column(name = "title", nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "release_id")
    private Release release;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @ManyToOne
    @JoinColumn(name = "performer_id")
    private User performer;

    @Override
    public BaseEntity fillFromModel(BaseEntity model) {
        return this;
    }
}
