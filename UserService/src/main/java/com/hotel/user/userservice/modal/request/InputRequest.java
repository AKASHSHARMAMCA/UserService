package com.hotel.user.userservice.modal.request;

import com.hotel.user.userservice.modal.dao.UserDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InputRequest {

      UserDetail userDetail;
}
