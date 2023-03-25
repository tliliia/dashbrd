package com.tronina.dashbrd.controller;

import com.tronina.dashbrd.entity.Status;
import com.tronina.dashbrd.entity.Task;
import com.tronina.dashbrd.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import jdk.jfr.ContentType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController extends APIController<Task, TaskService> {

    public TaskController(TaskService service) {
        super(service);
    }

    @Operation(summary = "Получить задачи, у которых не назначен исполнитель")
    @GetMapping("/unassign")
    public ResponseEntity<List<Task>> getTasksNotAssign() {
        return ResponseEntity.ok(service.findAllNotAssign());
    }

    @Operation(summary = "Получить задачи проекта")
    @GetMapping("/release/{releaseId}")
    public ResponseEntity<List<Task>> getTasksOfProject(@PathVariable(name = "releaseId") Long releaseId) {
        return ResponseEntity.ok(service.getReleaseTasks(releaseId));
    }

    @Operation(summary = "Перевести задачу в статус IN_PROGRESS")
    @PutMapping(value = "/{id}/start")
    public ResponseEntity changeStatus(@PathVariable(name = "id") Long id) {
        service.startTask(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Перевести задачу в статус DONE")
    @PutMapping("/{id}/finish")
    public ResponseEntity finishTask(@PathVariable(name = "id") Long id) {
        service.finishTask(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}
