package com.tronina.dashbrd.controller;


import com.tronina.dashbrd.entity.Release;
import com.tronina.dashbrd.service.ReleaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/releases")
public class ReleaseController extends APIController<Release, ReleaseService> {

    public ReleaseController(ReleaseService service) {
        super(service);
    }
    /*
    У задачи должны быть указаны автор, исполнитель, версия релиза.
    Релиз имеет время начала выполнения и время завершения работ.
    Задача может быть в статусе IN_PROGRESS, только когда стартовал проект.
    Проект не должен быть закрыт, если хотя бы одна задача на доске не в статусе DONE.
    */
    /*
    ● Управление проектами (создание, редактирование)
    ● Управление задачами (создание, редактирование, удаление)
    ● Процесс выполнения задач (смена статуса задачи) и завершение выполнения проекта
     */
}
