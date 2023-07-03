package com.lcwd.user.service.services.impl;

import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.repositories.UserRepository;
import com.lcwd.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public User saveUser(User user) {
        //generate unique user id
       String randomUserId =  UUID.randomUUID().toString();
       user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        //implement rating service call using rest template
       ArrayList<Rating> ratingsOfAll =  restTemplate.getForObject("http://localhost:8086/ratings", ArrayList.class);
      logger.info("{}",ratingsOfAll);

//        getAllUser().
        return userRepository.findAll();
    }




    //get single user
    @Override
    public User getUser(String userId) {
        //get user from database with help of UserRepository
        User user= userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user with given id is not found on server!!: "+userId));
   //fetch rating of above user with help of RATING SERVICE
        //http://localhost:8086/ratings/users/05833e41-07b4-47cb-9d8c-d7f8017d59af


        ArrayList<Rating> ratingsOfUser=restTemplate.getForObject("http://localhost:8086/ratings/users/"+ user.getUserId(), ArrayList.class);
        logger.info("{}",ratingsOfUser);

        user.setRatings(ratingsOfUser);
        return user;
    }
}
