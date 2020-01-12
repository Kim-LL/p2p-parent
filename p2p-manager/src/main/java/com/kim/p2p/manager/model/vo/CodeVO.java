package com.kim.p2p.manager.model.vo;

import lombok.Data;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.Cookie;
import java.io.Serializable;

@Data
public class CodeVO implements Serializable {

    private static final long serialVersionUID = 193042836522192886L;

    private ResponseEntity<byte[]> responseEntity;

    private Boolean result;

    private Cookie cookie;
}
