package com.hotel.user.userservice.services.impl;

import com.hotel.user.userservice.exceptions.ResourceNotFoundException;
import com.hotel.user.userservice.modal.Rating.Rating;
import com.hotel.user.userservice.modal.dao.UserDetail;
import com.hotel.user.userservice.modal.response.UserDetailsResponse;
import com.hotel.user.userservice.repositry.UserRepository;
import com.hotel.user.userservice.services.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServicesImpl implements UserServices {

    private static final Logger logger = LoggerFactory.getLogger(UserServicesImpl.class);

    @Autowired
    UserRepository userRepository;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public UserDetail saveUser(UserDetail userDetail) {
        return userRepository.save(userDetail);
    }

    @Override
    public List<UserDetailsResponse> getAllUserDetails() {
        List<UserDetailsResponse> userDetailsResponseList = new ArrayList<>();
        List<UserDetail> userDetailList = userRepository.findAll();
            userDetailList.forEach(userDetail -> {
                UserDetail userDetail1 = new UserDetail();
                setUserDetailsfor(userDetailsResponseList, userDetail1, userDetail);
            });
        return userDetailsResponseList;
    }

    private void setUserDetailsfor(List<UserDetailsResponse> userDetailsResponseList, UserDetail userDetail1, UserDetail userDetail){
        userDetail1.setUserId(userDetail.getUserId());
        userDetail1.setAbout(userDetail.getAbout());
        userDetail1.setDob(userDetail.getDob());
        userDetail1.setEmail(userDetail.getEmail());
        userDetail1.setMobile(userDetail.getMobile());
        userDetail1.setName(userDetail.getName());
        UserDetailsResponse userDetailsResponse = new UserDetailsResponse();
        userDetailsResponse.setUserDetail(userDetail1);
        setUserDetailsRating(userDetailsResponse,userDetail.getUserId());
        userDetailsResponseList.add(userDetailsResponse);

    }

    private void setUserDetailsRating(UserDetailsResponse userDetailsResponse, String userId) {
        ArrayList<Rating> rating = new ArrayList<>();
        try {
            rating = restTemplate.getForObject("http://localhost:9092/ratings/users/" + userId, ArrayList.class);
        }catch (Exception e ){
            logger.error("rating service is down");
        }
        userDetailsResponse.setRating(rating);
    }

    @Override
    public UserDetailsResponse getUserDetailsByUserId(String userId) {
        UserDetailsResponse userDetailsResponse = new UserDetailsResponse();
        UserDetail userDetail = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException());
        ArrayList<Rating> rating = restTemplate.getForObject("http://localhost:9092/ratings/users/"+ userId,ArrayList.class);
        userDetailsResponse.setUserDetail(userDetail);
        userDetailsResponse.setRating(rating);
        return userDetailsResponse;
    }
}
