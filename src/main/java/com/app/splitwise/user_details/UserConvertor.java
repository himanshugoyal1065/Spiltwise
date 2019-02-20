package com.app.splitwise.user_details;

import com.app.splitwise.framework.convertor.BaseConvertor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class UserConvertor implements BaseConvertor<SplitwiseUserDetails, SplitwiseUserVo> {

    @Override
    public SplitwiseUserDetails convertVoToEntity(SplitwiseUserVo splitwiseUserVo) {
        SplitwiseUserDetails splitwiseUserDetails = new SplitwiseUserDetails();
        splitwiseUserDetails.setUuid(splitwiseUserVo.getUuid());
        splitwiseUserDetails.setUserName(splitwiseUserVo.getUserName());
        splitwiseUserDetails.setName(splitwiseUserVo.getName());
        splitwiseUserDetails.setEmail(splitwiseUserVo.getEmail());
        splitwiseUserDetails.setBalance(splitwiseUserVo.getBalance() == null ? BigDecimal.ZERO : splitwiseUserVo.getBalance());
        splitwiseUserDetails.setMobileNo(splitwiseUserVo.getMobileNo());
//        splitwiseUserDetails.setDate(splitwiseUserVo.getDate());
        splitwiseUserDetails.setPassword(splitwiseUserVo.getPassword());
        return splitwiseUserDetails;
    }

    @Override
    public SplitwiseUserVo convertEntityToVo(SplitwiseUserDetails splitwiseUserDetails) {
        return SplitwiseUserVo.builder()
                .uuid(splitwiseUserDetails.getUuid())
                .balance(splitwiseUserDetails.getBalance())
//                .date(splitwiseUserDetails.getDate())
                .email(splitwiseUserDetails.getEmail())
                .mobileNo(splitwiseUserDetails.getMobileNo())
                .password(splitwiseUserDetails.getPassword())
                .userName(splitwiseUserDetails.getUserName())
                .name(splitwiseUserDetails.getName())
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
        updatedSplitwiseUserDetails.setBalance(splitwiseUserDetails.getBalance());
        return updatedSplitwiseUserDetails;
    }
}
