package com.jb.coupon3.clr.servicesTests;

import com.jb.coupon3.beans.Category;
import com.jb.coupon3.beans.Coupon;
import com.jb.coupon3.beans.Customer;
import com.jb.coupon3.repositories.CompanyRepo;
import com.jb.coupon3.repositories.CouponRepo;
import com.jb.coupon3.repositories.CustomerRepo;
import com.jb.coupon3.service.CompanyService;
import com.jb.coupon3.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

import java.util.Set;
/**
 * @author Yoav Hacmon, Guy Endvelt, Niv Pablo and Gery Glazer
 * 05.2022
 */

//@Component
@Order(4)
@RequiredArgsConstructor
/**
 * this class is used for the implementation and testing of all customer service(client side) methods and Hibernate queries
 * implements CommandLineRunner to indicate that a bean(Entity) should run when SpringApplication is initialized
 */
public class CustomerServiceTests implements CommandLineRunner {
private final CustomerService customerService;
private final CustomerRepo customerRepo;
private final CouponRepo couponRepo;
private final CompanyService companyService;
private final CompanyRepo companyRepo;

    @Override
    public void run(String... args) throws Exception {

        Customer customer = customerRepo.findByEmail("zeevik@gmail.com");
        //customer login
        customerService.login(customer.getEmail(), customer.getPassword());

        Coupon coupon = couponRepo.findById(1).get();
        //purchase coupon
        //customerService.purchaseCoupon(coupon);
        //get all customer`s coupons
        Set<Coupon> customerCoupons = customerService.getAllCustomerCoupons();
        System.out.println("1 - " + customerCoupons);
        //get all customer`s coupons by category
        Set<Coupon> customerCouponsByCategory = customerService.getCustomerCoupons(Category.ELECTRIC_APPLIANCE);
        System.out.println("2 - " + customerCouponsByCategory);
        //get all customer's coupons by maxPrice
        Set<Coupon> customerCouponsByMaxPrice = customerService.getCustomerCoupons(2001);
        System.out.println("3- " + customerCouponsByMaxPrice);
        //get customer details
        System.out.println(customerService.getCustomerDetails());
    }

}
//        companyService.addCoupon(new Coupon(
//                0, companyRepo.findByName("rikushet").getId(), null, Category.EXTREME, "helmet", "for_dirt_bike",
//                Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now().plusDays(30)), 500, 199, ""));