package com.example.firstspringboot.controllerTest;

import com.example.firstspringboot.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TEst232 {

    @Autowired
    private UserRepository userRepository;
    @Test
    public void dsdtest() {
        Assert.assertEquals(2, userRepository.findAll().size());
    }
}

