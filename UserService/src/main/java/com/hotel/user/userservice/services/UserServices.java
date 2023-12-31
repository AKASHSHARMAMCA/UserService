package com.hotel.user.userservice.services;

import com.hotel.user.userservice.modal.dao.UserDetail;
import com.hotel.user.userservice.modal.response.UserDetailsResponse;

import java.util.List;

public interface UserServices {

    UserDetail saveUser(UserDetail userDetail);
    List<UserDetailsResponse> getAllUserDetails();
    UserDetailsResponse getUserDetailsByUserId(String userId);
    //TODO: delete
    //TODO: Update

}
