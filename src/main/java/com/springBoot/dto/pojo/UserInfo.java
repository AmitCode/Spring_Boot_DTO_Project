package com.springBoot.dto.pojo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
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
@Entity
@Table(name = "USER_GE_INFO")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userID;
    @NotEmpty(message = "User Name is required")
    String userName;
    @NotEmpty(message = "DOB is required")
    String dob;
    @NotEmpty(message = "Email is required")
    @Email(message = "Email Address must in a valid format")
    String userEmail;
    @CreationTimestamp
    String infoCreationDateTime;
    @UpdateTimestamp
    String infoUpdateDateTime;
    String userPassword;
    String isActive;
}
