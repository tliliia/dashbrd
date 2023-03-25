package com.tronina.dashbrd.service;


import com.tronina.dashbrd.exception.BLException;
import com.tronina.dashbrd.entity.Status;
import com.tronina.dashbrd.entity.Task;
import com.tronina.dashbrd.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService extends AbstractService<Task, TaskRepository> {

    final private ReleaseService releaseService;

    public TaskService(TaskRepository repository, ReleaseService releaseService) {
        super(repository);
        this.releaseService = releaseService;
    }


    /**
     * Вернуть список задач для релиза
     * @param releaseId идентификатор релиза
     * @return список задач для релиза
     */
    public List<Task> getReleaseTasks(long releaseId) {
        return repository.findAllByReleaseId(releaseId);
    }

    /**
     * Вернуть список не назначенных задач
     * @return список не назначенных задач
     */
    public List<Task> findAllNotAssign() {
        return repository.findAllByPerformerIsNull();
    }


    public Task createOrUpdate(long taskId, Task task) {
        Task originalTask = repository.getReferenceById(taskId);
//    originalTask
        return repository.save(task);
    }



    public void startTask(long taskId) {
        Task task = repository.getReferenceById(taskId);
        if (releaseService.isStarted(task.getRelease())) {
            if (!task.getStatus().equals(Status.BACKLOG)) {
                throw new BLException("Переход из текущего состояния не поддерживается");
            }
            task.setStatus(Status.IN_PROGRESS);
            saveOrUpdate(task);
        } else {
            throw new RuntimeException("Релиз не стартовал");
        }
    }

    public void finishTask(long id) {
    }
}
