package com.kim.p2p.manager.service;

import com.kim.p2p.manager.model.dto.UserDTO;
import com.kim.p2p.manager.model.entity.User;
import com.kim.p2p.manager.model.vo.UserVO;

public interface UserService {


    UserDTO getFirstUser();

    Boolean deleteUserById(Integer userId);

    UserVO createUser(User user);
}
