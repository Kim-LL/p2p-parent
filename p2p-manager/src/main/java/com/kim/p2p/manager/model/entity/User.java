package com.kim.p2p.manager.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 998626163207502685L;

    private Integer userId;

    private Integer userType;

    private String phoneNumber;

    @Length(min = 8, message = "用户名最小8个字符")
    @NotBlank
    private String username;

    @Length(min = 8, message = "密码最小8个字符")
    @NotBlank
    private String password;

    private String recommendPerson;

    @Email(message = "邮件格式不符合匹配")
    private String email;

    private String nickname;

    private Integer userStatus;

    @Length(min = 4, max = 6)
    @NotBlank(message = "图片验证码为空")
    private String pictureCode;

    @Length(min = 4, max = 6)
    @NotBlank(message = "短信验证码为空")
    private String phoneCode;

    private String authorityId;

}
