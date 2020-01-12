package com.kim.p2p.manager.model.po;

import lombok.Data;

import java.util.Date;

@Data
public class UserPO {

    private Integer userId;

    private Integer userType;

    private String phoneNumber;

    private String username;

    private String password;

    private String recommendPerson;

    private String email;

    private String nickname;

    private Integer userStatus;

    private Date createTime;

    private Date updateTime;

}
