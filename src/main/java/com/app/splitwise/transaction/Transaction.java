package com.app.splitwise.transaction;

import com.app.splitwise.framework.entity.BaseEntity;
import com.app.splitwise.user_details.SplitwiseUserDetails;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "transaction_records")
public class Transaction extends BaseEntity {

    String description;

//    @OneToOne(cascade = CascadeType.REFRESH)
//    @JoinTable(name = "user_paid_transaction",
//            joinColumns = @JoinColumn(name = "transaction_id", referencedColumnName = "uuid"),
//            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "uuid"))
    String userPaid;

    BigDecimal transactionAmount;

    // certain criteria(s) have to be included in this
    //  for example : the user_paid doing the transaction may or may not included

//    @ManyToMany(cascade = CascadeType.REFRESH)
//    @JoinTable(name = "user_transaction",
//            joinColumns = @JoinColumn(name = "transaction_id", referencedColumnName = "uuid"),
//            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "uuid"))
    @ElementCollection
    List<String> usersInvovled;

}

