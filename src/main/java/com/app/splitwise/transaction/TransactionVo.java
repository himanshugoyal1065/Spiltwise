
package com.app.splitwise.transaction;

import com.app.splitwise.framework.vo.BaseVo;
import com.app.splitwise.user_details.SplitwiseUserVo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Wither;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Value
@Wither
@Builder(toBuilder = true)
@JsonDeserialize(builder = TransactionVo.TransactionVoBuilder.class)
public class TransactionVo implements BaseVo<TransactionVo> {

    int uuid;
//    Date date;
    String description;

    String userPaid;

    BigDecimal transactionAmount;


    // certain criteria(s) have to be included in this
    //  for example : the user_paid doing the transaction may or may not included
    List<String> usersInvovled;

}
