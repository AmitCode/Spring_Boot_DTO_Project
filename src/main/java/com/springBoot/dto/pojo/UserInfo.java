package com.springBoot.dto.pojo;

import jakarta.persistence.*;
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
    String userName;
    String dob;
    String userEmail;
    @CreationTimestamp
    String infoCreationDateTime;
    @UpdateTimestamp
    String infoUpdateDateTime;
    String userPassword;
    String isActive;
}
