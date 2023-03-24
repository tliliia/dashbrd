package com.tronina.dashbrd.controller;

import com.tronina.dashbrd.service.TaskService;
import com.tronina.dashbrd.entity.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("")
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @GetMapping("/without-performer")
    public ResponseEntity<List<Task>> getTasksNotAssign() {
        return ResponseEntity.ok(taskService.findAllNotAssign());
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTask(@PathVariable(name = "taskId") long taskid) {
        return ResponseEntity.ok(taskService.findById(taskid));
    }

//    @Operation(summary = "Получить задачи проекта")
    @GetMapping("/release/{releaseId}")
    public ResponseEntity<List<Task>> getTasksOfProject(@PathVariable(name = "releaseId") long releaseId) {
        return ResponseEntity.ok(taskService.getReleaseTasks(releaseId));
    }

    //    @Operation(summary = "Удалить задачу")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteTask(@PathVariable(name = "id") long id) {
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    //    @Operation(summary = "Создать задачу")
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.saveOrUpdate(task));
    }

//    @Operation(summary = "Обновить задачу")
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@RequestBody Task task, @PathVariable(name = "id") long id) {
        return ResponseEntity.ok(taskService.createOrUpdate(id, task));
    }

//    @Operation(summary = "Сменить статус задачи",
    @PatchMapping("/{id}")
    public ResponseEntity startTask(@RequestBody Task task) {
        taskService.startTask(task.getId());
        return ResponseEntity.ok().build();
    }

//    @PatchMapping("/{id}")
//    public ResponseEntity finishTask(@RequestBody Task task) {
//        taskService.finishTask(task.getId());
//        return ResponseEntity.ok().build();
//    }

}
