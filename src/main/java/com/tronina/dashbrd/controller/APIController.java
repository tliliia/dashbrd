package com.tronina.dashbrd.controller;
//
//import com.tronina.dashboard.model.BaseEntity;
////import com.tronina.dashboard.DAO.DAO;
////import io.swagger.v3.oas.annotations.Operation;
////import io.swagger.v3.oas.annotations.media.Content;
////import io.swagger.v3.oas.annotations.media.Schema;
////import io.swagger.v3.oas.annotations.responses.ApiResponse;
////import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
///**
// * Абстрактный контроллер с круд операциями
// */
//@RequiredArgsConstructor
public abstract class APIController {//<E extends BaseEntity, S extends DAO<E>> {
//  protected final S service;
//
//  @GetMapping("/{id}")
////  @Operation(summary = "Get element by Id", tags = "getById")
////  @ApiResponses(value = {
////          @ApiResponse(
////                  responseCode = "200",
////                  description = "OK",
////                  content = {@Content(
////                          mediaType = MediaType.APPLICATION_JSON_VALUE,
////                          schema = @Schema(implementation = Model.class))}),
////          @ApiResponse(responseCode = "400", description = "Некорректный запрос", content = @Content),
////          @ApiResponse(responseCode = "401", description = "Неавторизованный пользователь", content = @Content),
////          @ApiResponse(responseCode = "403", description = "Доступ запрещен", content = @Content),
////          @ApiResponse(responseCode = "404", description = "Объект не найден", content = @Content)})
//  public ResponseEntity<E> getById(@PathVariable Long id) {
//    return ResponseEntity.ok(service.findById(id));
//  }
//
//  @PutMapping
////  @Operation(summary = "Update element", tags = "update")
////  @ApiResponses(value = {
////          @ApiResponse(
////                  responseCode = "200",
////                  description = "OK",
////                  content = {@Content(
////                          mediaType = MediaType.APPLICATION_JSON_VALUE,
////                          schema = @Schema(implementation = Model.class))}),
////          @ApiResponse(responseCode = "400", description = "Некорректный запрос", content = @Content),
////          @ApiResponse(responseCode = "401", description = "Неавторизованный пользователь", content = @Content),
////          @ApiResponse(responseCode = "403", description = "Доступ запрещен", content = @Content),
////          @ApiResponse(responseCode = "404", description = "Объект не найден", content = @Content)})
//  public ResponseEntity<E> update(@RequestBody E element) throws Exception {
//    return ResponseEntity.ok(service.update(element));
//  }
//
//  @PostMapping
////  @Operation(summary = "Create new element", tags = "create")
////  @ApiResponses(value = {
////          @ApiResponse(
////                  responseCode = "200",
////                  description = "OK",
////                  content = {@Content(
////                          mediaType = MediaType.APPLICATION_JSON_VALUE,
////                          schema = @Schema(implementation = Model.class))}),
////          @ApiResponse(responseCode = "400", description = "Некорректный запрос", content = @Content),
////          @ApiResponse(responseCode = "401", description = "Неавторизованный пользователь", content = @Content),
////          @ApiResponse(responseCode = "403", description = "Доступ запрещен", content = @Content),
////          @ApiResponse(responseCode = "409", description = "Такой пользователь уже существует", content = @Content)})
//  public ResponseEntity<E> create(@RequestBody E element) throws DbException {
//    return ResponseEntity.ok(service.create(element));
//  }
//
//  @DeleteMapping
////  @Operation(summary = "Delete element", tags = "delete")
////  @ApiResponses(value = {
////          @ApiResponse(
////                  responseCode = "200",
////                  description = "OK",
////                  content = {@Content(
////                          mediaType = MediaType.APPLICATION_JSON_VALUE,
////                          schema = @Schema(implementation = Boolean.class))}),
////          @ApiResponse(responseCode = "400", description = "Некорректный запрос", content = @Content),
////          @ApiResponse(responseCode = "401", description = "Неавторизованный пользователь", content = @Content),
////          @ApiResponse(responseCode = "403", description = "Доступ запрещен", content = @Content),
////          @ApiResponse(responseCode = "404", description = "Объект не найден", content = @Content)})
//  public ResponseEntity<Boolean> delete(@RequestBody Long elementId) {
//    return ResponseEntity.ok(service.delete(elementId));
//  }
}
