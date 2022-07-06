package com.jb.coupon3.controllers;

import com.jb.coupon3.beans.ClientType;
import com.jb.coupon3.exceptions.CustomExceptions;
import com.jb.coupon3.service.AdminService;
import com.jb.coupon3.service.LoginService;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class AdminControllerTest {
    private final String url = "http://localhost:8080/GYGNcoupons/";
    private LoginService loginService;
    private AdminService adminService;
    private RestTemplate restTemplate;
    //private Company company = new Company(1, "samsung", "sam@sung.com", "s2m5un6", new HashSet<>());

    @BeforeClass
    public void init() throws CustomExceptions {
        loginService.login("admin@admin.com", "ADMIN", ClientType.ADMIN);
    }

    @Test
    void loginPass() throws CustomExceptions {
        Assert.isTrue(adminService.login("admin@admin.com", "ADMIN"));
    }

    @Test
    void login(){
        String token = restTemplate.getForObject(url, String.class);
    }
    @Test
    void addCompany() {

    }

    @Test
    void updateCompany() {
    }

    @Test
    void deleteCompany() {
    }

    @Test
    void getAllCompanies() {
    }

    @Test
    void getOneCompany() {
    }

    @Test
    void addCustomer() {
    }

    @Test
    void updateCustomer() {
    }

    @Test
    void getOneCustomer() {
    }

    @Test
    void getAllCustomers() {
    }

    @Test
    void deleteCustomer() {
    }
}