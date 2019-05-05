package com.app.splitwise.transaction;

import java.math.BigDecimal;
import java.util.Collections;
//TODO convert the class into builder design pattern
public class TransactionData {
    private static TransactionVo TRANSACTIONDATA;

    private TransactionData() {

    }

    public static TransactionVo getTransactionData() {
        if (TRANSACTIONDATA == null) {

            TRANSACTIONDATA = TransactionVo.builder().uuid(1)
                                    .description("himanshu paid")
                                    .transactionAmount(new BigDecimal(500))
                                    .userPaid("himanshu")
                                    .usersInvovled(Collections.singletonList(null))
                                    .build();
        }
        return TRANSACTIONDATA;
    }
}
