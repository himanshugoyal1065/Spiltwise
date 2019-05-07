package com.app.splitwise.transaction;

import com.app.splitwise.UserTestData;
import com.app.splitwise.user_details.SplitwiseUserVo;
import com.app.splitwise.user_details.UserService;
import com.app.splitwise.user_details.UserServiceImpl;
import com.sun.javafx.fxml.BeanAdapter;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableConfigurationProperties
public class TransactionServiceImplTestSuite extends TestCase {

    @Autowired
    TransactionServiceImpl transactionService;

    @Autowired
    UserServiceImpl userService;

    @Test
    public void testWorking() {
        assertTrue(true);
    }

    @Test
    public void testCreateMethod() {

        createUser();

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

    private void createUser() {
        SplitwiseUserVo userVo = userTestData.createData();
        userTestData.createUser(userService);
    }

    UserTestData userTestData = new UserTestData();
}
