package com.tronina.dashbrd.repository;


import com.tronina.dashbrd.entity.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends BaseRepository<Task> {

    List<Task> findAllByReleaseId(long id);
    List<Task> findAllByPerformerIsNull();
}
