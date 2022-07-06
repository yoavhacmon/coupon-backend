package com.jb.coupon3.controllers;

import com.jb.coupon3.beans.ClientType;
import com.jb.coupon3.beans.UserDetails;
import com.jb.coupon3.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@RequiredArgsConstructor
class LoginControllerTest {
    private final String url = "http://localhost:8080/GYGNcoupons/";
    private LoginService loginService;
    @Autowired
    private RestTemplate restTemplate;
    private UserDetails userDetails = new UserDetails(ClientType.ADMIN, "admin@admin.com", "ADMIN");

    @Test
    void login() {
        String token = restTemplate.getForObject(url+"login/admin@admin.com/ADMIN/ADMIN", String.class);
        System.out.println(token);
    }
}