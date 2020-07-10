package com.friend.finder;

import com.friend.finder.models.Newsfeed;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class FriendFinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FriendFinderApplication.class, args);
    }

}
