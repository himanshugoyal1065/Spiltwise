package com.app.splitwise.framework.controller;

import com.app.splitwise.framework.service.DataService;
import com.app.splitwise.framework.vo.BaseVo;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<V extends BaseVo<V>> {

    private final DataService dataService;

    public BaseController(DataService dataService) {
        System.out.println("dataService intialized "+ dataService);
        this.dataService = dataService;
    }

    @NonNull
    @GetMapping("")
    public List<V> findAll() {
        return dataService.findAll();
    }

    @NonNull
    @GetMapping("{uuid}")
    public V findByUuid(@PathVariable Integer uuid) {
        return (V) dataService.find(uuid);
    }

    @NonNull
    @PostMapping("")
    public V create(@RequestBody V vo) {
        System.out.println("called the create method");
        return (V) dataService.create(vo);
    }

    @NonNull
    @PutMapping("{uuid}")
    public V update(@PathVariable Integer uuid, @RequestBody V vo) {
        return (V) dataService.update(uuid, vo.withUuid(uuid));
    }

    @DeleteMapping("{uuid}")
    public @NonNull Boolean delete(@PathVariable Integer uuid) {
        return dataService.delete(uuid);
    }
}
