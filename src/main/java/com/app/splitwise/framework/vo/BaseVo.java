package com.app.splitwise.framework.vo;

public interface BaseVo<V> {

    V withUuid(String uuid);

    String getUuid();
}
