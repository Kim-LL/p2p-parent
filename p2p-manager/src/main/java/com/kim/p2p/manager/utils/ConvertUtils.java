package com.kim.p2p.manager.utils;

import com.kim.p2p.manager.model.dto.UserDTO;
import com.kim.p2p.manager.model.entity.User;
import com.kim.p2p.manager.model.po.UserPO;
import com.kim.p2p.manager.model.vo.UserVO;
import org.springframework.beans.BeanUtils;

public class ConvertUtils {

    public static UserDTO convert(UserPO po){
        if(po == null){
            return null;
        }

        UserDTO dto = new UserDTO();

        BeanUtils.copyProperties(po, dto);
        return dto;
    }

    public static UserVO convert(User entity){
        if(entity == null){
            return null;
        }

        UserVO vo = new UserVO();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }

}
