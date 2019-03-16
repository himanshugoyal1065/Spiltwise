package com.app.splitwise.user_details;

import com.app.splitwise.framework.exception.NotFoundException;
import com.app.splitwise.framework.service.DataServiceImpl;
import lombok.NonNull;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl extends DataServiceImpl<SplitwiseUserDetails, SplitwiseUserVo> implements UserService {

    private UserRepository userRepository;

    private UserConvertor userConvertor;

    public UserServiceImpl(UserRepository userRepository, UserConvertor userConvertor) {
        super(userRepository, userConvertor);
        this.userRepository = userRepository;
        this.userConvertor = userConvertor;
    }

    @Override
    public @NonNull SplitwiseUserVo create(SplitwiseUserVo splitwiseUserVo) {
        String plainTextPassword = splitwiseUserVo.getPassword();
        String hash = BCrypt.gensalt();
        String hashedpw = BCrypt.hashpw(plainTextPassword, hash);

        return super.create(splitwiseUserVo.withPassword(hashedpw));

       /* return Mono.just(userConvertor.convertVoToEntity(splitwiseUserVo.withPassword(hashedpw)))
                .flatMap(t -> Mono.just(userRepository.save(t)))
                .flatMap(e -> Mono.just(userConvertor.convertEntityToVo(e)));*/
    }

    public SplitwiseUserVo findByUserName(String userName) {
        if(userRepository.findByUserName(userName)!= null){
            return userConvertor.convertEntityToVo(userRepository.findByUserName(userName));
        }
        throw new NotFoundException("Record not found in database");
    }
}
