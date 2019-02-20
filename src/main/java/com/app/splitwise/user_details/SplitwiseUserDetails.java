package com.app.splitwise.user_details;

import com.app.splitwise.framework.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SplitwiseUserDetails extends BaseEntity {

    private String name;

    private String userName;

    private String password;

    private String email;

    private String mobileNo;

//    private Date date;

    private BigDecimal balance;

}
