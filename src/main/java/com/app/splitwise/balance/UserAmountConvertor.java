package com.app.splitwise.balance;

import org.springframework.stereotype.Component;

@Component
public class UserAmountConvertor {

    public UserAmountVo convertEntityToVo(UserAmount userAmount) {
        return UserAmountVo.builder()
                .netBalance(userAmount.getNetBalance())
                .userWillGiveYouMoney(userAmount.getTheUserOwesYou())
                .youWillGiveMoneyToUser(userAmount.getYouOweToTheUser())
                .build();
    }

    public UserAmount convertVoToEntity(UserAmountVo userAmountVo) {
        UserAmount userAmount = new UserAmount();
        userAmount.setNetBalance(userAmountVo.getNetBalance());
        userAmount.setTheUserOwesYou(userAmountVo.getUserWillGiveYouMoney());
        userAmount.setYouOweToTheUser(userAmountVo.getYouWillGiveMoneyToUser());
        return userAmount;
    }
            }
