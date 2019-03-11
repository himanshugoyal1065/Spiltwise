
package com.app.splitwise.transaction;

import com.app.splitwise.framework.convertor.BaseConvertor;
import com.app.splitwise.user_details.SplitwiseUserDetails;
import com.app.splitwise.user_details.SplitwiseUserVo;
import com.app.splitwise.user_details.UserConvertor;
import com.app.splitwise.utility.convertors.ConvertorFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionConvertor implements BaseConvertor<Transaction, TransactionVo> {

    @Override
    public Transaction convertVoToEntity(TransactionVo transactionVo) {
        //List<SplitwiseUserDetails> list = transactionVo.getUserPaid().stream().map(t -> userConvertor.convertVoToEntity(t.getSplitwiseUserVo())).collect(Collectors.toList());
        Transaction transaction=new Transaction();
        transaction.setDescription(transactionVo.getDescription());
      //  transaction.setDate(transactionVo.getDate());
        transaction.setTransactionAmount(transactionVo.getTransactionAmount());
        transaction.setUserPaid(transactionVo.getUserPaid());
        transaction.setUuid(transactionVo.getUuid());
       transaction.setUsersInvovled(transactionVo.getUsersInvovled());
        return transaction;
    }

    @Override
    public TransactionVo convertEntityToVo(Transaction transaction) {

    //    List<UsersPaidWrapper>=
      return   TransactionVo.builder()
                .uuid(transaction.getUuid())
                //.date(transaction.getDate())
                .description(transaction.getDescription())
                .transactionAmount(transaction.getTransactionAmount())
              .userPaid(transaction.getUserPaid())
              .usersInvovled(transaction.getUsersInvovled())
              .build();
    }

    @Override
    public Transaction updateEntityFromVo(Transaction transaction, TransactionVo transactionVo) {
        return null;
    }
}

