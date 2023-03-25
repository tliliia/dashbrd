package com.tronina.dashbrd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "releases")
@Entity
public class Release extends BaseEntity {
    @Column(name = "version")
    private String version;

    @Column(name = "date_start", nullable = false)
    private Date dateStart;

    @Column(name = "date_end", nullable = false)
    private Date dateEnd;

    @Transient()
    @OneToMany(mappedBy = "release")
    List<Task> tasks;

    @Override
    public BaseEntity fillFromModel(BaseEntity model) {
        return this;
    }
}
