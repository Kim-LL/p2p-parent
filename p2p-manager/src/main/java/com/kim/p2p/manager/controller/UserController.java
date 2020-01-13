package com.kim.p2p.manager.controller;

import com.kim.p2p.common.constant.BaseConstant;
import com.kim.p2p.common.utils.BindingUtils;
import com.kim.p2p.common.utils.ResultUtils;
import com.kim.p2p.manager.constant.AuthorityConstant;
import com.kim.p2p.manager.model.dto.UserDTO;
import com.kim.p2p.manager.model.entity.User;
import com.kim.p2p.manager.model.vo.UserVO;
import com.kim.p2p.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping(value = {"/user"}, produces = {BaseConstant.PRODUCE_JSON})
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/getFirstPerson"})
    public String getFirstPerson(){
        UserDTO user = userService.getFirstUser();

        return ResultUtils.ok(user);
    }

    @GetMapping(value = {"/removePerson"})
    public String removeSpecifiedPerson(@RequestParam(value = "userId", defaultValue = "1", required = false)Integer userId,
                                        HttpServletRequest request,
                                        HttpServletResponse response){
        Boolean result = userService.deleteUserById(userId);
        if(result){
            return ResultUtils.ok(null);
        }else{
            return ResultUtils.error(null);
        }
    }

    @PostMapping(value = {"/register"})
    public String register(
            @Valid User user,
            BindingResult bindingResult,
            HttpServletRequest request){
        Map<String, String> data = BindingUtils.judgeBinding(bindingResult);
        if(data != null){
            return ResultUtils.error(data);
        }
        String authorityId = null;
        for(Cookie cookie: request.getCookies()){
            if(cookie.getName().equals(AuthorityConstant.AUTHORITY_ID)){
                authorityId = cookie.getValue();
                break;
            }
        }
        if(authorityId == null){
            return ResultUtils.error(AuthorityConstant.CODE_NO_FLASH);
        }
        user.setAuthorityId(authorityId);
        UserVO vo = userService.createUser(user);

        if(vo.getResult()){
            return ResultUtils.ok(vo);
        }else{
            return ResultUtils.error(vo.getMsg(), null);
        }
    }


    @PostMapping(value = {"/createUser"})
    public String createUser(@RequestBody @Valid User user,
                             BindingResult bindingResult){
        Map<String, String> data = BindingUtils.judgeBinding(bindingResult);
        if(data != null){
            return ResultUtils.error(data);
        }

        UserVO vo = userService.createUser(user);
        if(vo != null){
            return ResultUtils.ok(vo);
        }else{
            return ResultUtils.error(null);
        }
    }
}
