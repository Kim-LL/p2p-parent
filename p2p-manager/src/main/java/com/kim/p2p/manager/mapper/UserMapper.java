package com.kim.p2p.manager.mapper;

import com.kim.p2p.manager.model.entity.User;
import com.kim.p2p.manager.model.po.UserPO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {

    UserPO selectFirstUser();

    @Delete(value = {"DELETE FROM p_user WHERE user_id=#{userId,jdbcType=INTEGER}"})
    Boolean deleteUserByUserId(@Param("userId") Integer userId);

    Boolean insertUser(User user);
}
