package com.app.splitwise.user_details;

import com.app.splitwise.balance.UserAmountConvertor;
import com.app.splitwise.framework.convertor.BaseConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserConvertor implements BaseConvertor<SplitwiseUserDetails, SplitwiseUserVo> {

    @Autowired
    private UserAmountConvertor userAmountConvertor;

    @Override
    public  SplitwiseUserDetails convertVoToEntity(SplitwiseUserVo splitwiseUserVo) {
        Map<SplitwiseUserVo,BigDecimal> map= new HashMap<>();
        SplitwiseUserDetails splitwiseUserDetails = new SplitwiseUserDetails();
        splitwiseUserDetails.setUuid(splitwiseUserVo.getUuid());
        splitwiseUserDetails.setUserName(splitwiseUserVo.getUserName());
        splitwiseUserDetails.setName(splitwiseUserVo.getName());
        splitwiseUserDetails.setEmail(splitwiseUserVo.getEmail());
        splitwiseUserDetails.setAmount(userAmountConvertor.convertVoToEntity(splitwiseUserVo.getAmount()));
//        splitwiseUserDetails.setBalance(splitwiseUserVo.getBalance() == null ? BigDecimal.ZERO : splitwiseUserVo.getBalance());
        splitwiseUserDetails.setMobileNo(splitwiseUserVo.getMobileNo());
//        splitwiseUserDetails.setDate(splitwiseUserVo.getDate());
        splitwiseUserDetails.setPassword(splitwiseUserVo.getPassword());
//        splitwiseUserDetails.setUsersOweYou(splitwiseUserVo.getUsersOweYou());
//        splitwiseUserDetails.setUsersYouOwe(splitwiseUserVo.getUsersYouOwe());
        return splitwiseUserDetails;
    }

    @Override
    public SplitwiseUserVo convertEntityToVo(SplitwiseUserDetails splitwiseUserDetails) {

//        Map<SplitwiseUserDetails>
        return SplitwiseUserVo.builder()
                .uuid(splitwiseUserDetails.getUuid())
//                .balance(splitwiseUserDetails.getBalance())
//                .date(splitwiseUserDetails.getDate())
                .email(splitwiseUserDetails.getEmail())
                .mobileNo(splitwiseUserDetails.getMobileNo())
                .amount(userAmountConvertor.convertEntityToVo(splitwiseUserDetails.getAmount()))
                .password(splitwiseUserDetails.getPassword())
                .userName(splitwiseUserDetails.getUserName())
                .name(splitwiseUserDetails.getName())
//               .usersOweYou(splitwiseUserDetails.getUsersOweYou())
//                .usersYouOwe(splitwiseUserDetails.getUsersYouOwe())
                .build();
    }

    @Override
    public SplitwiseUserDetails updateEntityFromVo(SplitwiseUserDetails splitwiseUserDetails, SplitwiseUserVo splitwiseUserVo) {
        SplitwiseUserDetails updatedSplitwiseUserDetails = new SplitwiseUserDetails();
        updatedSplitwiseUserDetails.setUuid(splitwiseUserDetails.getUuid());
        updatedSplitwiseUserDetails.setName(splitwiseUserVo.getName() == null ? splitwiseUserDetails.getName() : splitwiseUserVo.getName());
        updatedSplitwiseUserDetails.setUserName(splitwiseUserVo.getUserName() == null ? splitwiseUserDetails.getUserName() : splitwiseUserVo.getUserName());
        updatedSplitwiseUserDetails.setPassword(splitwiseUserVo.getPassword() == null ? splitwiseUserDetails.getPassword() : splitwiseUserVo.getPassword());
        updatedSplitwiseUserDetails.setEmail(splitwiseUserVo.getEmail() == null ? splitwiseUserDetails.getEmail() : splitwiseUserVo.getEmail());
        updatedSplitwiseUserDetails.setMobileNo(splitwiseUserVo.getMobileNo() == null ? splitwiseUserDetails.getMobileNo() : splitwiseUserVo.getMobileNo());
//        updatedSplitwiseUserDetails.setDate(splitwiseUserDetails.getDate());
//        updatedSplitwiseUserDetails.setBalance(splitwiseUserDetails.getBalance());
        updatedSplitwiseUserDetails.setAmount(userAmountConvertor.convertVoToEntity(splitwiseUserVo.getAmount()));
        return updatedSplitwiseUserDetails;
    }

    public List<SplitwiseUserVo> convertListVoFromListEntity(List<SplitwiseUserDetails> inListUserEntity){
        List<SplitwiseUserVo> userEntityList=new ArrayList<>();
        for(SplitwiseUserDetails userVo:inListUserEntity){
            userEntityList.add(convertEntityToVo(userVo));
        }
        return userEntityList;
    }

    public List<SplitwiseUserDetails> convertListEntityFromListVo(List<SplitwiseUserVo> inListUserVo){
        List<SplitwiseUserDetails> userVoList=new ArrayList<>();
        for(SplitwiseUserVo userVo:inListUserVo){
            userVoList.add(convertVoToEntity(userVo));
        }
        return userVoList;
    }
}
