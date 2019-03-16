package com.app.splitwise.balance;

import com.app.splitwise.user_details.SplitwiseUserVo;

import java.math.BigDecimal;
import java.util.Map;

public final class UserNetBalanceCalculator {

    public static BigDecimal calculateNetBalance(SplitwiseUserVo userVo){

        BigDecimal netFinalAmount=BigDecimal.ZERO;

        Map<String,BigDecimal> userWhoTookMoney=userVo.getAmount().getUserWillGiveYouMoney();
        Map<String,BigDecimal> userWhoGaveYouMoney=userVo.getAmount().getYouWillGiveMoneyToUser();


        for(Map.Entry<String,BigDecimal> takenAmountFromOtherUser : userWhoGaveYouMoney.entrySet()){
            BigDecimal amountTakenFromUser=takenAmountFromOtherUser.getValue();
            netFinalAmount = netFinalAmount.add(amountTakenFromUser);
        }

        for(Map.Entry<String,BigDecimal> amountGivenToOtherUser: userWhoTookMoney.entrySet()){
            BigDecimal amountGivenToAnotherUser=amountGivenToOtherUser.getValue();
            System.out.println("amountGivenToAnotherUser "+amountGivenToAnotherUser);
            netFinalAmount=netFinalAmount.add(amountGivenToAnotherUser);
        }
        return netFinalAmount;
    }
}
