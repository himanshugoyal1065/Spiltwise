
package com.app.splitwise.utility.convertors;

import com.app.splitwise.framework.convertor.BaseConvertor;
import com.app.splitwise.framework.entity.BaseEntity;
import com.app.splitwise.framework.vo.BaseVo;
import com.app.splitwise.user_details.SplitwiseUserDetails;
import com.app.splitwise.user_details.SplitwiseUserVo;
import com.app.splitwise.user_details.UserConvertor;

public final class ConvertorFactory<T extends BaseEntity,V extends BaseVo> {

    private static ConvertorFactory convertorFactory;

    private ConvertorFactory(){
    }

    public BaseConvertor<T,V> convertor(String inTypeString){
        if(inTypeString.equalsIgnoreCase("user"))
            return (BaseConvertor<T, V>) new UserConvertor();
        return null;
    }

    public static ConvertorFactory getInstance(){
        if(convertorFactory==null){
            convertorFactory = new ConvertorFactory();
        }
        return convertorFactory;
    }

}