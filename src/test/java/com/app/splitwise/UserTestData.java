package com.app.splitwise;

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

    public UserTestData() {

    }

    public SplitwiseUserVo createData(String inName, String inUserName) {

        try {
            return userService.findByUserName(inUserName);
        } catch (Exception e) {
            System.out.println(e);
        }

        UserAmountVo amount = new UserAmountVo(new BigDecimal(0), null, null);
        return SplitwiseUserVo.builder().amount(amount)
                .uuid(1)
                .email("random123@gmail.com")
                .mobileNo("9780797041")
                .name(inName)
                .userName(inUserName)
                .password("him22")
                .amount(amount)
                .build();
    }

    public boolean createUser(UserService inUserService, String inNameOfUser, String inUserNameOfUser) {
        try {
            UserController userController = new UserController(inUserService);
            return userController.create(createData(inNameOfUser, inUserNameOfUser)) != null;
        } finally {
            return false;
        }
    }
}
