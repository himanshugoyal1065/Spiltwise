package com.app.splitwise.framework.controller;

import com.app.splitwise.framework.service.DataService;
import com.app.splitwise.framework.vo.BaseVo;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<V extends BaseVo<V>> {


    private final DataService dataService;

    public BaseController(DataService dataService) {
        this.dataService = dataService;
    }

    @NonNull
    @GetMapping("")
    public List<V> findAll() {
        return dataService.findAll();
    }

    @NonNull
    @GetMapping("{uuid}")
    public V findByUuid(@PathVariable String uuid) {
        return (V) dataService.find(uuid);
    }

    @NonNull
    @PostMapping("")
    public V create(@RequestBody V vo) {
        return (V) dataService.create(vo);
    }

    @NonNull
    @PutMapping("{uuid}")
    public V update(@PathVariable int uuid, @RequestBody V vo) {
        return (V) dataService.update(uuid, vo.withUuid(uuid));
    }

    @DeleteMapping("{uuid}")
    public @NonNull Boolean delete(@PathVariable String uuid) {
        return dataService.delete(uuid);
    }
}
