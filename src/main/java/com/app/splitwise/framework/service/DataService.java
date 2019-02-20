package com.app.splitwise.framework.service;

import com.app.splitwise.framework.vo.BaseVo;
import lombok.NonNull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DataService<V extends BaseVo<V>> {

    @NonNull
    Flux<V> findAll();

    @NonNull
    Mono<V> find(String uuid);

    @NonNull
    Mono<V> create(V vo);

    @NonNull
    Mono<V> update(String uuid, V vo);

    @NonNull
    Mono<Boolean> delete(String uuid);
}
