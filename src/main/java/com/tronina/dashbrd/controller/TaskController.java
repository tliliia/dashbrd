package com.tronina.dashbrd.controller;

import com.tronina.dashbrd.entity.Task;
import com.tronina.dashbrd.repository.TaskRepository;
import com.tronina.dashbrd.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController extends APIController <Task, TaskService> {

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
    public ResponseEntity<List<Task>> getTasksOfProject(@PathVariable(name = "releaseId") long releaseId) {
        return ResponseEntity.ok(service.getReleaseTasks(releaseId));
    }

    @Operation(summary = "Сменить статус задачи")
    @PatchMapping("/{id}")
    public ResponseEntity startTask(@RequestBody Task task) {
        service.startTask(task.getId());
        return ResponseEntity.ok().build();
    }

//    @PatchMapping("/{id}")
//    public ResponseEntity finishTask(@RequestBody Task task) {
//        ((TaskService)service).finishTask(task.getId());
//        return ResponseEntity.ok().build();
//    }

}
