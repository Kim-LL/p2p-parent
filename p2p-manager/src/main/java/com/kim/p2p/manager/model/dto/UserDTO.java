package com.kim.p2p.manager.model.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 2354725211686808374L;

    @JSONField(serialize = false)
    private Integer userId;

    @JSONField(serialize = false)
    private Integer userType;

    private String phoneNumber;

    private String username;

    @JSONField(serialize = false)
    private String password;

    private String recommendPerson;

    private String email;

    private String nickname;

    @JSONField(serialize = false)
    private Integer userStatus;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss", name = "createTime")
    private Date createTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss", name = "updateTime")
    private Date updateTime;
}
