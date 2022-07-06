package com.jb.coupon3.repositories;

import com.jb.coupon3.beans.Category;
import com.jb.coupon3.beans.Coupon;
import com.jb.coupon3.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    boolean existsByEmailAndPassword(String email, String password);
    boolean existsByEmail(String email);
    Customer findByFirstNameAndLastName(String fName, String lname);
    Customer findByEmailAndPassword(String email,String password);
    Customer findByEmail (String email);


    @Transactional
    @Modifying
    @Query(value = "INSERT INTO customer_vs_coupons (customer_id, coupon_id) VALUES (?,?)", nativeQuery = true)
    void addCouponToCustomer(int customer_id, int coupon_id);

    @Query(value = "SELECT * FROM customer_vs_coupons WHERE customer_id =? and coupon_id=?", nativeQuery = true)
    List<Coupon> isCouponPurchased(int customer_id, int coupon_id);

    @Query("SELECT coup FROM Coupon coup WHERE coup.id IN " +
            "(SELECT coup.id FROM coup.customers cust WHERE cust.id = ?1 and coup.id = ?2)")
    Coupon findCustomerCoupon(int custId, int cpnId);

    @Query("SELECT coup FROM Coupon coup WHERE coup.id= any " +
            "(SELECT coup.id FROM coup.customers cust WHERE cust.id = ?1)")
    Set<Coupon> findAllCustomerCoupons(int custId);

    @Query("SELECT coup FROM Coupon coup join coup.customers cust where cust.id =?1 and coup.category = ?2")
    public Set<Coupon> findAllCustomerCouponsByCategory(int custId, Category category);

    @Query("SELECT coup FROM Coupon coup join coup.customers cust where cust.id =?1 and coup.price < ?2")
    public Set<Coupon> findAllCustomerCouponsMaxPrice(int custId, double max_price);
}
