package com.app.splitwise.framework.controller;

import com.app.splitwise.framework.service.DataService;
import com.app.splitwise.framework.vo.BaseVo;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class BaseController<V extends BaseVo<V>> {


    private final DataService dataService;

    public BaseController(DataService dataService) {
        this.dataService = dataService;
    }

    @NonNull
    @GetMapping("")
    public Flux<V> findAll() {
        return dataService.findAll();
    }

    @NonNull
    @GetMapping("{uuid}")
    public Mono<V> findByUuid(@PathVariable String uuid) {
        return dataService.find(uuid);
    }

    @NonNull
    @PostMapping("")
    public Mono<V> create(@RequestBody V vo) {
        return dataService.create(vo);
    }

    @NonNull
    @PutMapping("{uuid}")
    public Mono<V> update(@PathVariable String uuid, @RequestBody V vo) {
        return dataService.update(uuid, vo.withUuid(uuid));
    }

    @NonNull
    @DeleteMapping("{uuid}")
    public Mono<V> delete(@PathVariable String uuid) {
        return dataService.delete(uuid);
    }
}
