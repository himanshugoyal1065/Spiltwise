package com.app.splitwise.framework.convertor;

import com.app.splitwise.framework.entity.BaseEntity;
import com.app.splitwise.framework.vo.BaseVo;

import java.util.Optional;

public interface BaseConvertor<T extends BaseEntity, V extends BaseVo> {

    T convertVoToEntity(V v);

    V convertEntityToVo(T t);

    T updateEntityFromVo(T t, V v);

}
