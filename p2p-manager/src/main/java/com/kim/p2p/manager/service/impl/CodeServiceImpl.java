package com.kim.p2p.manager.service.impl;

import com.kim.p2p.common.constant.TimeConstant;
import com.kim.p2p.common.model.pojo.ValidateCode;
import com.kim.p2p.common.utils.ImageUtils;
import com.kim.p2p.common.utils.RedisUtils;
import com.kim.p2p.common.utils.ValidateCodeUtils;
import com.kim.p2p.manager.constant.AuthorityConstant;
import com.kim.p2p.manager.model.vo.CodeVO;
import com.kim.p2p.manager.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import java.util.UUID;

@Service
public class CodeServiceImpl implements CodeService {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private ValidateCodeUtils validateCodeUtils;

    @Override
    public CodeVO getCodeInfo() {


        ValidateCode validateCode = validateCodeUtils.getCode(140, 40, 4, 20);

        CodeVO vo = new CodeVO();
        vo.setResult(true);
        byte[] bytes = ImageUtils.imageToBytes(validateCode.getBuffImg(), ImageUtils.FORMAT_PNG);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentLength(bytes.length);
        headers.setContentType(MediaType.IMAGE_PNG);
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
        vo.setResponseEntity(entity);
        String code = validateCode.getCode();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        redisUtils.set(uuid, code);
        redisUtils.expire(uuid, TimeConstant.SECOND_60);
        Cookie cookie = new Cookie(AuthorityConstant.AUTHORITY_ID, uuid);
        vo.setCookie(cookie);

        return vo;
    }
}