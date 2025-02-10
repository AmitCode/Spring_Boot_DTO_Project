package com.springBoot.dto.mapperClasses;

import com.springBoot.dto.pojo.UserInfo;
import com.springBoot.dto.userDto.UserDTOClass;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapperClass {
    AutoUserMapperClass MAPPER = Mappers.getMapper(AutoUserMapperClass.class);
    //Field Name in both the class should be same but if different define like this.
    //@Mapping(source = "UserEmail",target = "Email")
    UserDTOClass mapToUserDto(UserInfo userInfo);
    UserInfo mapToJPAEntity(UserDTOClass userDTOClass);
}
