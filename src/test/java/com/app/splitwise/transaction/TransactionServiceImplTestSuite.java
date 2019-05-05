package com.app.splitwise.transaction;

import com.app.splitwise.user_details.UserService;
import com.sun.javafx.fxml.BeanAdapter;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionServiceImplTestSuite extends TestCase {

    @Autowired
    TransactionServiceImpl transactionService;

    @Test
    public void testWorking() {
        assertTrue(true);
    }

    @Test
    public void testCreateMethod() {
        TransactionVo transactionVo = new TransactionVo(
                1,
                "himanshu test transaction",
                "himanshu",
                new BigDecimal(500),
                Arrays.asList(new String[]{"himanshu", "Arpit"})
        );

        TransactionVo transactionVoObtained = transactionService.create(transactionVo);

        assertNotNull(transactionVoObtained);
    }
}
