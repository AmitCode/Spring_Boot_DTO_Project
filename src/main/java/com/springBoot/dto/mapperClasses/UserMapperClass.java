package com.springBoot.dto.mapperClasses;

import com.springBoot.dto.pojo.UserInfo;
import com.springBoot.dto.userDto.UserDTOClass;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;
//Gathering all the User to Dto class conversion methods of a single mapper class.
public class UserMapperClass {
    public UserDTOClass covertUserToUserDto( UserInfo userInfo){
        UserDTOClass userDTOClass = new UserDTOClass();
        userDTOClass.setUserID(userInfo.getUserID());
        userDTOClass.setUserName(userInfo.getUserName());
        userDTOClass.setUserEmail(userInfo.getUserEmail());
        userDTOClass.setDob(userInfo.getDob());
        userDTOClass.setIsActive(userInfo.getIsActive());
        return userDTOClass;
    }

    public List<UserDTOClass> convertListOfUserToDto(List<UserInfo> userInfoList){
        List<UserDTOClass> listOfUserInfo = new ArrayList<>();
        for(UserInfo userInfo : userInfoList){
            UserDTOClass userDTOClass = new UserDTOClass();
            userDTOClass.setUserID(userInfo.getUserID());
            userDTOClass.setUserName(userInfo.getUserName());
            userDTOClass.setUserEmail(userInfo.getUserEmail());
            userDTOClass.setDob(userInfo.getDob());
            userDTOClass.setIsActive(userInfo.getIsActive());
            listOfUserInfo.add(userDTOClass);
        }
        return listOfUserInfo;
    }

    public UserInfo convertingJPAEntityToDto(UserDTOClass userDTOClass){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserID(userDTOClass.getUserID());
        userInfo.setUserName(userDTOClass.getUserName());
        userInfo.setUserEmail(userDTOClass.getUserEmail());
        userInfo.setDob(userDTOClass.getDob());
        return userInfo;
    }
}
