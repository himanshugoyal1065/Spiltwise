
package com.app.splitwise.transaction;

import com.app.splitwise.framework.controller.BaseController;
import com.app.splitwise.framework.service.DataService;
import com.app.splitwise.user_details.SplitwiseUserVo;
import lombok.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/transaction")
public class TransactionController extends BaseController<TransactionVo> {
    private TransactionService transactionService;
    public TransactionController(TransactionService transactionService) {
        super(transactionService);
        this.transactionService = transactionService;
    }

//    @NotNull
//    @Override
//    public TransactionVo create(TransactionVo transactionVo){
//        List<UsersPaidWrapper> userPaid=transactionVo.getUserPaid();
//        List<SplitwiseUserVo> usersInvovled=transactionVo.getUsersInvovled();
//        BigDecimal transactionAmount=transactionVo.getTransactionAmount();
//
//        return null;
//    }

}
