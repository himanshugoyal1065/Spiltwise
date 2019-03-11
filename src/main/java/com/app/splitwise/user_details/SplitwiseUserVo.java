package com.app.splitwise.user_details;

import com.app.splitwise.balance.UserAmountVo;
import com.app.splitwise.framework.vo.BaseVo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Wither;

@Value
@Wither
@Builder(toBuilder = true)
@JsonDeserialize(builder = SplitwiseUserVo.SplitwiseUserVoBuilder.class)
public class SplitwiseUserVo implements BaseVo<SplitwiseUserVo> {

    private String uuid;

    private String name;

    private String userName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String email;

    private String mobileNo;

//    private Date date;

    /*private BigDecimal balance;

    private Map<String,BigDecimal> usersYouOwe;

    private Map<String,BigDecimal> usersOweYou;*/

    private UserAmountVo amount;

}
