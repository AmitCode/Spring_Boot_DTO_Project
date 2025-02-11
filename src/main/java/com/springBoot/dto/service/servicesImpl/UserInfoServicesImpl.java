package com.springBoot.dto.service.servicesImpl;

import com.springBoot.dto.exception.UserInfoNotFoundException;
import com.springBoot.dto.mapperClasses.AutoUserMapperClass;
import com.springBoot.dto.mapperClasses.UserMapperClass;
import com.springBoot.dto.pojo.UserInfo;
import com.springBoot.dto.repository.UserInfoRepository;
import com.springBoot.dto.service.UserInfoServices;
import com.springBoot.dto.userDto.UserDTOClass;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserInfoServicesImpl implements UserInfoServices {
    @Autowired
    private UserInfoRepository userInfoRepository;
    private ModelMapper modelMapper;
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
        UserInfo UserInfoDetail = userInfoRepository.findById(UserInfoId).orElseThrow(
                () -> new UserInfoNotFoundException("User ","id",UserInfoId)
        );
        //UserInfo userInfo = UserInfoDetail.get();
        //Using user defined mapper class
        //return userMapperClass.covertUserToUserDto(UserInfoDetail.get());
        //Using Model Mapper Class
        //return modelMapper.map(userInfo, UserDTOClass.class);
        //Using MapStruct
        return AutoUserMapperClass.MAPPER.mapToUserDto(UserInfoDetail);
    }

    @Override
    public List<UserDTOClass> getAllUserInfo(){
        List<UserInfo> userInfoList = userInfoRepository.findAll();
        return userInfoList.stream().map(userInfo -> modelMapper.map(userInfo,UserDTOClass.class))
                .collect(Collectors.toList());
        //return userMapperClass.convertListOfUserToDto(userInfoList);
    }

    @Override
    public UserDTOClass updateUserInfo(UserInfo UserInfo){
        UserInfo oldUserInfo = userInfoRepository.findById(UserInfo.getUserID()).get();
        oldUserInfo.setUserName(UserInfo.getUserName());
        UserInfo updateUser = userInfoRepository.save(UserInfo);
        //return userMapperClass.covertUserToUserDto(updateUser);
        return modelMapper.map(updateUser,UserDTOClass.class);
    }

    @Override
    public List<UserDTOClass> deleteUserInfo(Long UserInfoId){
        userInfoRepository.deleteById(UserInfoId);
        List<UserInfo> userInfoList = userInfoRepository.findAll();
        //return  userMapperClass.convertListOfUserToDto(userInfoList);
        //Doing same this using Model Mapper Class
        return userInfoList.stream().map(userInfo -> modelMapper.map(userInfo,UserDTOClass.class))
                .collect(Collectors.toList());
    }
}
