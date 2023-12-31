package com.hotel.user.userservice.modal.response;

import com.hotel.user.userservice.modal.Rating.Rating;
import com.hotel.user.userservice.modal.dao.UserDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsResponse {
    private UserDetail userDetail;
    private List<Rating> rating;
}
