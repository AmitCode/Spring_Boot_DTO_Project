package com.springBoot.dto.userDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTOClass {
    Long userID;
    String userName;
    String dob;
    String userEmail;
    String isActive;
}
