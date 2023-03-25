package com.tronina.dashbrd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String login;

    @Override
    public BaseEntity fillFromModel(BaseEntity model) {
        if (model instanceof User) {
            this.login = ((User)model).getLogin();
        }
        return this;
    }

//    @OneToMany
//    @JoinColumn (name = "owner_id")
//    private List<Task> owned;
//    @OneToMany
//    @JoinColumn (name = "performer_id")
//    private List<Task> toDo;
}
