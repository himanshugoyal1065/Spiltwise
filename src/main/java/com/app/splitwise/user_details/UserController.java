package com.app.splitwise.user_details;

import com.app.splitwise.framework.controller.BaseController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController<SplitwiseUserVo> {

    private UserService userService;

    public UserController(UserService userService) {
        super(userService);
        this.userService = userService;
    }

}
