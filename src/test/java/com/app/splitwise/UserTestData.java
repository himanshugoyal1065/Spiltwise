package com.app.splitwise;

import com.app.splitwise.balance.UserAmount;
import com.app.splitwise.balance.UserAmountVo;
import com.app.splitwise.user_details.SplitwiseUserVo;

import java.math.BigDecimal;
//TODO definately convert the class into builder design pattern
public class UserTestData {

    private static SplitwiseUserVo SPLITWISEUSERVO = null;
    private UserTestData() {

    }

    public static SplitwiseUserVo createData() {
        if(SPLITWISEUSERVO == null) {
            UserAmountVo amount = new UserAmountVo(new BigDecimal(0),null,null);
            SPLITWISEUSERVO = SplitwiseUserVo.builder().amount(amount)
                    .uuid(1)
                    .email("himanshu1996@")
                    .mobileNo("98707")
                    .name("himanshu")
                    .userName("himanshu")
                    .password("him22")
                    .build();
            return SPLITWISEUSERVO;
        }
        return SPLITWISEUSERVO;
    }
}
