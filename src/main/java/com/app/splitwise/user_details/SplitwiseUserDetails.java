package com.app.splitwise.user_details;

import com.app.splitwise.balance.UserAmount;
import com.app.splitwise.framework.entity.BaseEntity;
//import com.app.splitwise.transaction.Transaction;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SplitwiseUserDetails extends BaseEntity {

    @NotNull
    @Size(min = 3, message = "Name should be min 3 letters long")
    private String name;

    @NotNull
    @Size(min = 3, message = "Username should be 3 letters long")
    private String userName;

    @Size(min = 6, message = "Password should be atleast 6 letters long")
    private String password;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 10, max = 10, message = "Mobile no should be 10 digits long")
    private String mobileNo;

//    private Date date;

    /*@Digits(fraction = 2,integer = 100)
    private BigDecimal balance;

    @OneToMany
    @JoinColumn(name = "user_id",referencedColumnName = "uuid")
    private Map<String,BigDecimal> usersYouOwe;

    @OneToMany
    @JoinColumn(name = "user_id",referencedColumnName = "uuid")
    private Map<String,BigDecimal> usersOweYou;*/

    @OneToOne(cascade = CascadeType.ALL)
    private UserAmount amount;

}
