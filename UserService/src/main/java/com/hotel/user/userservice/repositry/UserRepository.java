package com.hotel.user.userservice.repositry;

import com.hotel.user.userservice.modal.dao.UserDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDetail,String> {

}
