package com.hotel.user.userservice.modal.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("userDetail")
public class UserDetail {

    @Id
    private String userId;
    private String name;
    private String email;
    private String about;
    private String dob;
    private String mobile;

}
