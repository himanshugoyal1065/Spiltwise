package com.app.splitwise.user_details;

import com.app.splitwise.framework.service.DataServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends DataServiceImpl<SplitwiseUserDetails, SplitwiseUserVo> implements UserService {

    private UserRepository userRepository;

    private UserConvertor userConvertor;

    public UserServiceImpl(UserRepository userRepository, UserConvertor userConvertor) {
        super(userRepository, userConvertor);
    }
}
