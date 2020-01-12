package com.kim.p2p.manager.controller;

import com.kim.p2p.manager.constant.AuthorityConstant;
import com.kim.p2p.manager.model.vo.CodeVO;
import com.kim.p2p.manager.service.CodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


@Slf4j
@RestController
@RequestMapping(value = {"/code"})
public class CodeController {

    @Autowired
    private CodeService codeService;

    @GetMapping(value = {"/getPicture"})
    public ResponseEntity<byte[]> getPictureCode(
            HttpServletResponse response){

        CodeVO vo = codeService.getCodeInfo();
        if(vo.getResult()){
            response.addCookie(vo.getCookie());
            return vo.getResponseEntity();
        }
        return null;
    }
}
