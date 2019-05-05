package com.app.splitwise.framework.vo;

public interface BaseVo<V> {

    V withUuid(int uuid);

    int getUuid();
}
