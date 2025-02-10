package com.springBoot.dto.service.servicesImpl;

import com.springBoot.dto.mapperClasses.UserMapperClass;
import com.springBoot.dto.pojo.UserInfo;
import com.springBoot.dto.repository.UserInfoRepository;
import com.springBoot.dto.service.UserInfoServices;
import com.springBoot.dto.userDto.UserDTOClass;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserInfoServicesImpl implements UserInfoServices {
    @Autowired
    private UserInfoRepository userInfoRepository;
    UserMapperClass userMapperClass = new UserMapperClass();
    @Override
    public String insertUserInfo(UserInfo userInfo){
        String message="";
        try {
            System.out.println("UserInfoName:"+userInfo.getUserName());
            userInfoRepository.save(userInfo);
            message="Details saved successfully!...";
        }catch (Exception ex){
            message = "Details not saved "+ex.getMessage()+"!...";
        }
        return message;
    }

    @Override
    public UserDTOClass getUserInfoById(Long UserInfoId){
        Optional<UserInfo> UserInfoDetail = userInfoRepository.findById(UserInfoId);
        return userMapperClass.covertUserToUserDto(UserInfoDetail.get());
    }

    @Override
    public List<UserDTOClass> getAllUserInfo(){
        List<UserInfo> userInfoList = userInfoRepository.findAll();
        return userMapperClass.convertListOfUserToDto(userInfoList);
    }

    @Override
    public UserDTOClass updateUserInfo(UserInfo UserInfo){
        UserInfo oldUserInfo = userInfoRepository.findById(UserInfo.getUserID()).get();
        oldUserInfo.setUserName(UserInfo.getUserName());
        UserInfo updateUser = userInfoRepository.save(UserInfo);
        return userMapperClass.covertUserToUserDto(updateUser);
    }

    @Override
    public List<UserDTOClass> deleteUserInfo(Long UserInfoId){
        userInfoRepository.deleteById(UserInfoId);
        List<UserInfo> userInfoList = userInfoRepository.findAll();
        return  userMapperClass.convertListOfUserToDto(userInfoList);
    }
}
