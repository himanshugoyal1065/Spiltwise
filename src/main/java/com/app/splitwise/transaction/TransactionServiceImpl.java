package com.app.splitwise.transaction;

import com.app.splitwise.balance.UserNetBalanceCalculator;
import com.app.splitwise.framework.service.DataServiceImpl;
import com.app.splitwise.user_details.SplitwiseUserVo;
import com.app.splitwise.user_details.UserConvertor;
import com.app.splitwise.user_details.UserService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransactionServiceImplTestSuite extends DataServiceImpl<Transaction,TransactionVo> implements TransactionService {

    private TransactionRepository transactionRepository;

    private TransactionConvertor transactionConvertor;

    private UserService userService;

    private UserConvertor userConvertor;
    public TransactionServiceImplTestSuite(TransactionRepository transactionRepository, TransactionConvertor transactionConvertor, UserService userService) {
        super(transactionRepository, transactionConvertor);
        this.transactionConvertor = transactionConvertor;
        this.transactionRepository = transactionRepository;
        this.userService = userService;
    }

    @Override
    public TransactionVo create(TransactionVo transactionVo) {
        SplitwiseUserVo userPaid=userService.findByUserName(transactionVo.getUserPaid());

        List<String> usersInvovledStringList=transactionVo.getUsersInvovled();
        List<SplitwiseUserVo> usersInvovled=new ArrayList<>();

        for(String userString:usersInvovledStringList){
            usersInvovled.add(userService.findByUserName(userString));
        }

        BigDecimal amountPaid=transactionVo.getTransactionAmount();
        BigDecimal amountSplited=amountPaid.divide(new BigDecimal(usersInvovled.size()));
        Map<String,BigDecimal> userPaidMap=new HashMap<>();
        Map<String,BigDecimal> userInvovledMap=new HashMap<>();
        for(SplitwiseUserVo userInv:usersInvovled){
            if(userInv.getUuid() != userPaid.getUuid()){

                System.out.println("the user involved "+ userInv.getUserName() +"-- "+"the user paid "+userPaid.getUserName());
                userPaidMap=userPaid.getAmount().getUserWillGiveYouMoney();
                userInvovledMap=userInv.getAmount().getYouWillGiveMoneyToUser();

                // amount is added to the user who paid and it is added to each user who owes him this money
                if(userPaidMap.get(userInv.getUserName())==null){
                    userPaidMap.put(userInv.getUserName(),amountSplited);
                }
                else{
                    BigDecimal amountPresent=userPaidMap.get(userInv.getUserName());
                    userPaidMap.put(userInv.getUserName(),amountPresent.add(amountSplited));
                }

                //amount is deducted(or negactive amount is added for the user who owe the user who paid the amount
                if(userInvovledMap.get(userPaid.getUserName())==null){
                    userInvovledMap.put(userPaid.getUserName(),amountSplited.negate());
                }
                else{
                    BigDecimal amountPresent= userInvovledMap.get(userPaid.getUserName());
                    userInvovledMap.put(userPaid.getUserName(),amountPresent.add(amountSplited.negate()));

                }

                userInv.getAmount().withYouWillGiveMoneyToUser(userInvovledMap);
               BigDecimal amountBalance= UserNetBalanceCalculator.calculateNetBalance(userInv);
                System.out.println(amountBalance);
                userInv.getAmount().withNetBalance(amountBalance);
            }
        }

        userPaid.getAmount().withUserWillGiveYouMoney(userPaidMap);
        BigDecimal amountBalance= UserNetBalanceCalculator.calculateNetBalance(userPaid);
        System.out.println(amountBalance);
        userPaid.getAmount().withNetBalance(amountBalance);

    //TODO update the balance of the users accordinly(only for the current user)
        // one simple method could be use on list amongst them and calculate the net amount
        return transactionConvertor.convertEntityToVo(transactionRepository.save(transactionConvertor.convertVoToEntity(transactionVo)));
    }
}

//
//ur.findByUSername(username).map(t -> t.withWalletBalance(t.getWalletBalance + amountSplittrted)