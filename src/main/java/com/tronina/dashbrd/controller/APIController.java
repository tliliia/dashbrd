package com.tronina.dashbrd.controller;

import com.tronina.dashbrd.dto.Model;
import com.tronina.dashbrd.entity.BaseEntity;
import com.tronina.dashbrd.repository.BaseRepository;
import com.tronina.dashbrd.service.AbstractService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Абстрактный контроллер с круд операциями
 */
@RequiredArgsConstructor
public abstract class APIController <E extends BaseEntity, S extends AbstractService> {
    protected final S service;

    @GetMapping("/{id}")
    @Operation(summary = "Получить элемент по id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {@Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = BaseEntity.class))}),
            @ApiResponse(responseCode = "400", description = "Некорректный запрос", content = @Content),
            @ApiResponse(responseCode = "401", description = "Неавторизованный пользователь", content = @Content),
            @ApiResponse(responseCode = "403", description = "Доступ запрещен", content = @Content),
            @ApiResponse(responseCode = "404", description = "Объект не найден", content = @Content)})
    public ResponseEntity<E> getById(@PathVariable Long id) {
        return (ResponseEntity<E>) ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("")
    @Operation(summary = "Получить список всех элементов")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {@Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = BaseEntity.class))}),
            @ApiResponse(responseCode = "400", description = "Некорректный запрос", content = @Content),
            @ApiResponse(responseCode = "401", description = "Неавторизованный пользователь", content = @Content),
            @ApiResponse(responseCode = "403", description = "Доступ запрещен", content = @Content),
            @ApiResponse(responseCode = "404", description = "Объект не найден", content = @Content)})
    public ResponseEntity<List<E>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping
    @Operation(summary = "Сохранить или изменить элемент")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {@Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = BaseEntity.class))}),
            @ApiResponse(responseCode = "400", description = "Некорректный запрос", content = @Content),
            @ApiResponse(responseCode = "401", description = "Неавторизованный пользователь", content = @Content),
            @ApiResponse(responseCode = "403", description = "Доступ запрещен", content = @Content),
            @ApiResponse(responseCode = "404", description = "Объект не найден", content = @Content)})
    public ResponseEntity<E> saveOrUpdate(@RequestBody E element) throws Exception {
        return (ResponseEntity<E>) ResponseEntity.ok(service.saveOrUpdate(element));
    }

    @DeleteMapping
    @Operation(summary = "Удалить элемент по Id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {@Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Boolean.class))}),
            @ApiResponse(responseCode = "400", description = "Некорректный запрос", content = @Content),
            @ApiResponse(responseCode = "401", description = "Неавторизованный пользователь", content = @Content),
            @ApiResponse(responseCode = "403", description = "Доступ запрещен", content = @Content),
            @ApiResponse(responseCode = "404", description = "Объект не найден", content = @Content)})
    public ResponseEntity<Boolean> deleteById(@RequestBody Long elementId) {
        service.deleteById(elementId);
        return ResponseEntity.noContent().build();
    }
}