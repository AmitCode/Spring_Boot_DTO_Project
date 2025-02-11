package com.springBoot.dto.service;



import com.springBoot.dto.pojo.UserInfo;
import com.springBoot.dto.userDto.UserDTOClass;

import java.util.List;

public interface UserInfoServices {
    String insertUserInfo(UserInfo userInfo);
    public UserDTOClass getUserInfoById(Long userId);
    public List<UserDTOClass> getAllUserInfo();
    public UserDTOClass updateUserInfo(UserInfo userInfo);
    public List<UserDTOClass> deleteUserInfo(Long userId);
    public UserDTOClass markUserInActive(UserInfo userInfo);
}
