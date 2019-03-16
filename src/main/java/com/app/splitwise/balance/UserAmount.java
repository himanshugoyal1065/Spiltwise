package com.app.splitwise.balance;

import com.app.splitwise.framework.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Map;
@Entity
@Data
@NoArgsConstructor
public class UserAmount extends BaseEntity {

    private BigDecimal netBalance;

    @ElementCollection
    private Map<String, BigDecimal> youOweToTheUser;

    @ElementCollection
    private Map<String, BigDecimal> theUserOwesYou;
}
