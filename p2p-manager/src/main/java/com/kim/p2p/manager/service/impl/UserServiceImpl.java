package com.kim.p2p.manager.service.impl;

import com.alibaba.fastjson.JSON;
import com.kim.p2p.common.utils.RedisUtils;
import com.kim.p2p.common.utils.StringUtils;
import com.kim.p2p.manager.constant.AuthorityConstant;
import com.kim.p2p.manager.mapper.UserMapper;
import com.kim.p2p.manager.model.dto.UserDTO;
import com.kim.p2p.manager.model.entity.User;
import com.kim.p2p.manager.model.po.UserPO;
import com.kim.p2p.manager.model.vo.UserVO;
import com.kim.p2p.manager.service.UserService;
import com.kim.p2p.manager.utils.ConvertUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private UserMapper userMapper;

    @Transactional(readOnly = true)
    @Override
    public UserDTO getFirstUser() {

        UserPO userPO = userMapper.selectFirstUser();


        return ConvertUtils.convert(userPO);
    }

    @Override
    public Boolean deleteUserById(Integer userId) {
        return userMapper.deleteUserByUserId(userId);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    @Override
    public UserVO createUser(User user) {


        UserVO vo = new UserVO();
        log.info("user: {}", JSON.toJSONString(user));
        //判断验证码图片是否一致
        String authorityId = user.getAuthorityId();
        if(authorityId == null){
            vo.setResult(false);
            vo.setMsg(AuthorityConstant.CODE_NO_FLASH);
            return vo;
        }
        String pictureCode = redisUtils.get(authorityId).toString();
        log.info("pictureCode: {}, redisPictureCode: {}", user.getPictureCode(), pictureCode);
        if(!pictureCode.equalsIgnoreCase(user.getPictureCode())){
            vo.setResult(false);
            vo.setMsg(AuthorityConstant.CODE_UNCORRENT);
        }
        if(!StringUtils.containDigitAndCharacter(user.getPassword())){
            vo.setResult(false);
            vo.setMsg(AuthorityConstant.PASSWORD_UNNORM);
        }

        //验证通过
        Boolean result = userMapper.insertUser(user);
        if(result){
            vo = ConvertUtils.convert(user);
        }

        return vo;
    }
}
