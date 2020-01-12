package com.kim.p2p.manager.model.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserVO implements Serializable {

    private static final long serialVersionUID = 6069830281562135168L;

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

    @JSONField(format = "yyyy-MM-dd HH:mm:ss", name = "createTime", serialize = false)
    private Date createTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss", name = "updateTime", serialize = false)
    private Date updateTime;

    @JSONField(serialize = false)
    private Boolean result;

    @JSONField(serialize = false)
    private String msg;

}
