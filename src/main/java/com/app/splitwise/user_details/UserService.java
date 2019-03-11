package com.app.splitwise.user_details;

import com.app.splitwise.framework.service.DataService;

public interface UserService extends DataService<SplitwiseUserVo> {
    SplitwiseUserVo findByUserName(String userName);
}
