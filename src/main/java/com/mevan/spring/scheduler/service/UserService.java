package com.mevan.spring.scheduler.service;

import com.mevan.spring.scheduler.model.User;
import com.mevan.spring.scheduler.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;

    //  Schedule a job to add object in DB (Every 5 sec)
    @Scheduled(fixedRate = 5000)
    public void add2DBJob() {
        User user = new User();
        user.setName("user" + new Random().nextInt(374483));
        userRepository.save(user);
        System.out.println("Add Service Call in " + new Date());
    }

    //  Schedule a job to fetch object in DB (Every 15 sec)
    @Scheduled(cron = "0/15 * * * * *")
    public void fetchDBJob() {
        List<User> users = userRepository.findAll();
        System.out.println("Fetch Service Call in " + new Date());
        System.out.println("No of Record Fetched : " + users.size());
        LOGGER.info("fetchDBJobResponse : Users = {}", users);
    }
}