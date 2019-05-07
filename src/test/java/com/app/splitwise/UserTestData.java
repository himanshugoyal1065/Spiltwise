package com.app.splitwise;

import com.app.splitwise.balance.UserAmount;
import com.app.splitwise.balance.UserAmountVo;
import com.app.splitwise.user_details.SplitwiseUserVo;
import com.app.splitwise.user_details.UserController;
import com.app.splitwise.user_details.UserService;
import com.app.splitwise.user_details.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
//TODO definately convert the class into builder design pattern
public class UserTestData {

    @Autowired
    UserServiceImpl userService;

    private static SplitwiseUserVo SPLITWISEUSERVO = null;
    public UserTestData() {

    }

    public SplitwiseUserVo createData() {
        if(SPLITWISEUSERVO == null) {
            UserAmountVo amount = new UserAmountVo(new BigDecimal(0),null,null);
            SPLITWISEUSERVO = SplitwiseUserVo.builder().amount(amount)
                    .uuid(1)
                    .email("himanshu1996@gmail.com")
                    .mobileNo("9780797041")
                    .name("himanshu")
                    .userName("himanshu")
                    .password("him22")
                    .amount(amount)
                    .build();
            return SPLITWISEUSERVO;
        }
        return SPLITWISEUSERVO;
    }

    public boolean createUser(UserService inUserService) {
        try {
            UserController userController = new UserController(inUserService);
            return userController.create(createData()) != null;
        }
        finally {
            return false;
        }
    }
}
