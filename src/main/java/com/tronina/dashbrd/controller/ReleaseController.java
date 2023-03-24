package com.tronina.dashbrd.controller;


import com.tronina.dashbrd.entity.Release;
import com.tronina.dashbrd.entity.User;
import com.tronina.dashbrd.service.ReleaseService;
import com.tronina.dashbrd.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/releases")
@RequiredArgsConstructor
public class ReleaseController {
    private final ReleaseService service;
    private final UserService repo;

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

    @GetMapping("/users/")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        return ResponseEntity.ok(repo.findById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<Release>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

//    @Operation(summary = "Создать проект")
    @PostMapping
    public ResponseEntity<Release> createRelease(@RequestBody Release release) {
        return new ResponseEntity<>(service.saveOrUpdate(release), HttpStatus.CREATED);
    }

//    @Operation(summary = "Обновить проект")
    @PutMapping("/{id}")
    public ResponseEntity<Release> updateRelease(@RequestBody Release release,
                                                    @PathVariable("id") long id) {
        return ResponseEntity.ok(service.saveOrUpdate(release));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        service.deleteById(id);
        ResponseEntity.noContent().build();
    }


}
