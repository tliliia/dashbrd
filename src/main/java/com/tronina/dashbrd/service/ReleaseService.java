package com.tronina.dashbrd.service;

import com.tronina.dashbrd.entity.Release;
import com.tronina.dashbrd.entity.Status;
import com.tronina.dashbrd.entity.Task;
import com.tronina.dashbrd.repository.ReleaseRepository;
import com.tronina.dashbrd.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Service
public class ReleaseService extends AbstractService<Release, ReleaseRepository> {

    public ReleaseService(ReleaseRepository repository) {
        super(repository);
    }
    @Autowired
    private TaskRepository taskRepository;

    /**
     * Проверка стартовал ли релиз
     *
     * @param release объект
     * @return возвращает true, если прошла дата начала релиза
     */
    public boolean isStarted(Release release) {
        return release.getDateStart().before(new Date(Calendar.getInstance().getTimeInMillis()));
    }

    /**
     * Проверка все ли задачи релиза в статусе Выполнено
     *
     * @param release объект
     * @return возвращает true если задачи релиза в статусе Выполнено
     */
    private boolean canBeClosed(Release release) {
        List<Task> list = getAllTasks(release);
        return list.stream().allMatch(t -> t.getStatus().equals(Status.DONE));
    }

    /**
     * Закрыть релиз - проставить текущую дату завершения
     * @param releaseId id объекта
     */
    public void close(Long releaseId) {
        Release release = findById(releaseId);
        if (canBeClosed(release)) {
            release.setDateEnd(new Date(Calendar.getInstance().getTimeInMillis()));
            update(releaseId, release);
        }
    }

    //Base methods
    public List<Task> getAllTasks(Release release) {
        return taskRepository.findAllByReleaseId(release.getId());
    }
}
