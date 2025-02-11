package com.springBoot.dto.controller;

import com.springBoot.dto.error.ErrorMessage;
import com.springBoot.dto.exception.UserInfoNotFoundException;
import com.springBoot.dto.pojo.UserInfo;
import com.springBoot.dto.service.UserInfoServices;
import com.springBoot.dto.userDto.UserDTOClass;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(
        name="CRUD Rest API for User Management",
        description = "Create User, Delete User, Update User, Get User By Id, Get All Users"
)
@RequestMapping("/userServices")
public class UserInfoRestController {
    @Autowired
    private UserInfoServices userInfoServices;

    @Operation(
            summary = "Create new user rest api",
            description = "Create user rest api for creating new user details"

    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 CREATED"
    )
    @PostMapping("/createNewUser")
    @ResponseStatus(HttpStatus.CREATED)
    public String createNewUser(@Valid @RequestBody UserInfo userInfo){
        return userInfoServices.insertUserInfo(userInfo);
    }
    @Operation(
            summary = "Get a single user rest api",
            description = "Get a single user rest api for from user details"

            )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 Success"
    )
    @GetMapping("/getSingleUserInfo")
    //@RequestHeader("bookId") for sending request using header.
    //@PathVariable("bookId") for sending request using url variable (like (url/booId))
    public UserDTOClass getSingleUserInfo(@RequestHeader("userId") Long userId){
        UserDTOClass userInfo = userInfoServices.getUserInfoById(userId);
        return new ResponseEntity<>(userInfo,HttpStatus.OK).getBody();
    }
    @Operation(
            summary = "Get all user rest api",
            description = "Get all users rest api for from user details"

            )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 SUCCESS"
    )
    @GetMapping("/getAllUserDetails")
    public ResponseEntity<List<UserDTOClass>> getUserDetails(){
        List<UserDTOClass> userInfo = userInfoServices.getAllUserInfo();
        return new ResponseEntity<>(userInfo,HttpStatus.OK);
    }
    @Operation(
            summary = "Update a user rest api",
            description = "Update user rest api"

    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 UPDATED"
    )
    @PutMapping("/updateUserDetails")
    public ResponseEntity<UserDTOClass> updateUserDetails(@Valid @RequestBody UserInfo userInfo){
        return new ResponseEntity<>(userInfoServices.updateUserInfo(userInfo),HttpStatus.OK);
    }
    @Operation(
            summary = "Delete a user rest api",
            description = "Delete a user rest api from user details"

    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 DELETED"
    )
    @DeleteMapping("/deleteUserDetail")
    public ResponseEntity<List<UserDTOClass>> deleteUserDetail(@RequestHeader("userId") Long userId){
        return new ResponseEntity<>(userInfoServices.deleteUserInfo(userId),HttpStatus.OK);
    }

    @PostMapping("/markUserInActive")
    public ResponseEntity<UserDTOClass> markUserInActive (@RequestBody UserInfo userInfo){
        return new ResponseEntity<>(userInfoServices.markUserInActive(userInfo),HttpStatus.OK);
    }

}
