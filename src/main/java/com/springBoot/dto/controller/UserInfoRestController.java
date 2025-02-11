package com.springBoot.dto.controller;

import com.springBoot.dto.error.ErrorMessage;
import com.springBoot.dto.exception.UserInfoNotFoundException;
import com.springBoot.dto.pojo.UserInfo;
import com.springBoot.dto.service.UserInfoServices;
import com.springBoot.dto.userDto.UserDTOClass;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/userServices")
public class UserInfoRestController {
    @Autowired
    private UserInfoServices userInfoServices;
    @PostMapping("/createNewUser")
    @ResponseStatus(HttpStatus.CREATED)
    public String createNewUser(@Valid @RequestBody UserInfo userInfo){
        return userInfoServices.insertUserInfo(userInfo);
    }
    @GetMapping("/getSingleUserInfo")
    //@RequestHeader("bookId") for sending request using header.
    //@PathVariable("bookId") for sending request using url variable (like (url/booId))
    public UserDTOClass getSingleUserInfo(@RequestHeader("userId") Long userId){
        UserDTOClass userInfo = userInfoServices.getUserInfoById(userId);
        return new ResponseEntity<>(userInfo,HttpStatus.OK).getBody();
    }

    @GetMapping("/getAllUserDetails")
    public ResponseEntity<List<UserDTOClass>> getUserDetails(){
        List<UserDTOClass> userInfo = userInfoServices.getAllUserInfo();
        return new ResponseEntity<>(userInfo,HttpStatus.OK);
    }

    @PutMapping("/updateUserDetails")
    public ResponseEntity<UserDTOClass> updateUserDetails(@Valid @RequestBody UserInfo userInfo){
        return new ResponseEntity<>(userInfoServices.updateUserInfo(userInfo),HttpStatus.OK);
    }

    @DeleteMapping("/deleteUserDetail")
    public ResponseEntity<List<UserDTOClass>> deleteUserDetail(@RequestHeader("userId") Long userId){
        return new ResponseEntity<>(userInfoServices.deleteUserInfo(userId),HttpStatus.OK);
    }

}
