package com.jb.coupon3.clr.servicesTests;

import com.jb.coupon3.beans.Company;
import com.jb.coupon3.beans.Customer;
import com.jb.coupon3.exceptions.CustomExceptions;
import com.jb.coupon3.repositories.CompanyRepo;
import com.jb.coupon3.repositories.CustomerRepo;
import com.jb.coupon3.service.AdminService;
import com.jb.coupon3.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

/**
 * @author Yoav Hacmon, Guy Endvelt, Niv Pablo and Gery Glazer
 * 05.2022
 */

//@Component
@Order(2)
@RequiredArgsConstructor
/**
 * this class is used for the implementation and testing of all admin service(administrator)(client side) methods and Hibernate queries
 * Admin is one of the 3 clients in this Coupon management system
 * implements CommandLineRunner to indicate that a bean(Entity) should run when SpringApplication is initialized
 */
public class AdminTests implements CommandLineRunner {
    private final AdminService adminService;
    private final CompanyRepo companyRepo;
    private final CustomerRepo customerRepo;
    private final GuestService guestService;


    @Override
    public void run(String... args) throws Exception {
        //Admin login
        adminService.login("admin@admin.com", "admin");
        //add new company
        guestService.addCompany(new Company(0, "oneplus", "aone@plusone.com", "1+1", null));
        //update company
        //get one company test
        try {
            Company company = adminService.getOneCompany(companyRepo.findByName("oneplus").getId());
            company.setEmail("one@plusone.com");
            adminService.updateCompany(company);
            System.out.println(company);
        } catch (CustomExceptions customExceptions) {
            System.out.println(customExceptions.getMessage());
        }
        //get all companies
        System.out.println(adminService.getAllCompanies());
        //delete company
        adminService.deleteCompany(adminService.getOneCompany(companyRepo.findByName("oneplus").getId()).getId());
        //
        //add customer
       guestService.addCustomer(new Customer(
                0, "guy", "endvelt", "guy@gmail.com", "guyguy", null));

        //update customer
        //get one customer
        try {
        Customer customer = adminService.getOneCustomer(customerRepo.findByEmail("guy@gmail.com").getId());
        customer.setPassword("guyendvelt");
        adminService.updateCustomer(customer);
        } catch (CustomExceptions customExceptions) {
            System.out.println(customExceptions.getMessage());
        }
        //get all customers
        System.out.println(adminService.getAllCustomers());
        //delete customer
        adminService.deleteCustomer(adminService.getOneCustomer(customerRepo.findByEmail("guy@gmail.com").getId()).getId());
        System.out.println(adminService.getAllCustomers());
    }

}
