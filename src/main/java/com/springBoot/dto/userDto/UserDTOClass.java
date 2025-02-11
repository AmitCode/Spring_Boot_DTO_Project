package com.springBoot.dto.userDto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(
        description = "User DTO Model Information"
)
public class UserDTOClass {
    @Schema(
            description = "User Id"
    )
    Long userID;
    @Schema(
            description = "User Name"
    )
    String userName;
    @Schema(
            description = "User DOB"
    )
    String dob;
    @Schema(
            description = "User Email Address"
    )
    String userEmail;
    @Schema(
            description = "User is Active or not"
    )
    String isActive;
}
