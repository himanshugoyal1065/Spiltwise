package com.app.splitwise.user_details;

import com.app.splitwise.framework.vo.BaseVo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Wither;

import java.math.BigDecimal;
import java.util.Date;

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

    private BigDecimal balance;

}
