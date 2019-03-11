package com.app.splitwise.framework.service;

import com.app.splitwise.framework.vo.BaseVo;
import lombok.NonNull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface DataService<V extends BaseVo<V>> {

    @NonNull
    List<V> findAll();

    @NonNull
    V find(String uuid);

    @NonNull
    V create(V vo);

    @NonNull
    V update(String uuid, V vo);

    @NonNull
    Boolean delete(String uuid);
}
